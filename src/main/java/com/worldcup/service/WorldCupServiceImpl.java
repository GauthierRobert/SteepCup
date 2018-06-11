package com.worldcup.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldcup.model.Game;
import com.worldcup.model.Player;
import com.worldcup.model.TeamInGroup;
import com.worldcup.model.WorldCup;
import com.worldcup.repository.GameRepository;
import com.worldcup.repository.PlayerRepository;
import com.worldcup.repository.WorldCupRepository;

@Service("worldCupService")
public class WorldCupServiceImpl implements WorldCupService {

	@Autowired
	WorldCupRepository worldCupRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	GameService gameService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	PlayerRepository playerRepository;
	
	
	@Override
	public void fillFinals() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void fillQuarters() {
	
		
	}



	@Override
	public void fillRoundOf16() {
		
		List<WorldCup> Games08 = worldCupRepository.findWorldCupGamesByGroup("08");
		if (Games08.get(7).getWinner() == null) {
			String[] group =  {"A","B","C","D","E","F","G","H"};
			
			for (String L : group) {
				List<WorldCup> GamesGroup = worldCupRepository.findWorldCupGamesByGroup(L);
				List<TeamInGroup> group12 = get12(GamesGroup, L);
			
				String G1 = group12.get(3).getTeam();
				String G2 = group12.get(2).getTeam();
			
	
			
				for (WorldCup game : Games08) {
			
					if (game.getHome().equals("1" + L)) {
						game.setHome(G1);
						save(game);
					}
		
					if (game.getAway().equals("2" + L)) {
						game.setAway(G2);
						save(game);
			
					}
				}
			}
		}
	}
	
	

	@Override
	public void fillSemis() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<WorldCup> findAllWorldCupGames() {
		
		return worldCupRepository.findAllWorldCupGames();
		
	}
	
	@Override
	public List<WorldCup> findGroupWorldCupGames() {
		
		return worldCupRepository.findGroupWorldCupGames();
		
	}
	
	private List<TeamInGroup> get12 (List<WorldCup> GamesGroup, String group) {
		
		List<String>  teams = worldCupRepository.findWorldCupGamesByGroup(group)
				.stream().map(x -> x.getHome()).distinct().collect(Collectors.toList());
		
		List<TeamInGroup> groupRanking = new ArrayList<TeamInGroup>();
		
		for (String team : teams) {
			groupRanking.add(new TeamInGroup(team,group));
		}
		
		for (WorldCup game : GamesGroup) {
			
			int Home = game.getScoreHome().intValue();
			int Away = game.getScoreAway().intValue();
			
			TeamInGroup TeamHome = getTeam(groupRanking,game.getHome());
			TeamInGroup TeamAway = getTeam(groupRanking,game.getAway());
			int iH = groupRanking.indexOf(TeamHome);
			int iA = groupRanking.indexOf(TeamAway);
			
			if (Home > Away) {
				TeamHome = setWinTeam(TeamHome, Home, Away);
				TeamAway = setLoseTeam(TeamAway, Away, Home);
			} else if (Home == Away) {
				TeamHome = setDrawTeam(TeamHome, Home, Away);
				TeamAway = setDrawTeam(TeamAway, Away, Home);
			} else {
				TeamHome = setLoseTeam(TeamHome, Home, Away);
				TeamAway = setWinTeam(TeamAway, Away, Home);
			}	
			
			groupRanking.set(iH, TeamHome);
			groupRanking.set(iA, TeamAway);
			
		}
		return groupRanking.stream()
				.sorted(Comparator.comparing(TeamInGroup::getPoint)
						.thenComparing(TeamInGroup::getGoalDiff))
				.collect(Collectors.toList());
		
	}
	
	private Integer getResult(WorldCup worldCup,String homeAway) {
		
		int Home = worldCup.getScoreHome().intValue();
		int Away = worldCup.getScoreAway().intValue();
		
		if (Home > Away) {
			if (homeAway.equals("Home")) {
				return 3;
			} else {
				return 0;
			}		
		} else if (Home == Away) {
			return 1;	
		} else {
			if (homeAway.equals("Away")) {
				return 3;
			} else {
				return 0;
			}
		}		
	}
	
	private TeamInGroup getTeam(List<TeamInGroup> TeamsInGroup, String name) {
		
		for (TeamInGroup p : TeamsInGroup) {
		    if (p.getTeam().equals(name)) {
		    	return p;
		    }
		    
		}		
		return null;
	}
	
	@Override
	public Boolean isPhase1Completed() {
		
		List<WorldCup> wc =  worldCupRepository.findGroupWorldCupGames();
		
		
		for (WorldCup game : wc) {
			if(game.getScoreAway()==null || game.getScoreAway()==null) {
				return false;
			}
		}
		
		return true;
		
	}
	
	@Override
	public Boolean isPhaseTypeCompleted(String type) {

		List<WorldCup> wc = findGroupWorldCupGamesByType(type);
		
		for (WorldCup game : wc) {
			if(game.getScoreAway()==null || game.getScoreAway()==null) {
				return false;
			}
		}
		
		return true;
		
	}


	public WorldCup save(WorldCup worldCup) {
		
		if (worldCup.getScoreAway() !=null 
				&& worldCup.getScoreHome() !=null ) {
			worldCup.setPointHome(getResult(worldCup,"Home"));
			worldCup.setPointAway(getResult(worldCup,"Away"));
		}
		return worldCupRepository.save(worldCup);
		
	}


	@Override
	@Transactional
	public List<WorldCup> saveListWorldCup(List<WorldCup> worldCupGames) {	
		
		List<Player> players = playerRepository.findAll();
		
		List<WorldCup> games08wc = worldCupRepository.findWorldCupGamesByGroup("08");
		List<WorldCup> games08wc_b = games08wc;
		List<WorldCup> games04wc = worldCupRepository.findWorldCupGamesByGroup("04");
		List<WorldCup> games02wc = worldCupRepository.findWorldCupGamesByGroup("02");
		List<WorldCup> games01wc = worldCupRepository.findWorldCupGamesByGroup("01");
		
		List<String> team_1_08wc = games08wc.stream().map(x -> x.getHome()).collect(Collectors.toList());  
		List<String> team_2_08wc = games08wc_b.stream().map(x -> x.getAway()).collect(Collectors.toList());
		List<String> team_04wc = games04wc.stream().filter(c -> c.getWinner() != null).map(x -> x.getWinner()).collect(Collectors.toList());  
		List<String> team_02wc = games02wc.stream().filter(c -> c.getWinner() != null).map(x -> x.getWinner()).collect(Collectors.toList());  
		List<String> team_01wc = games01wc.stream().filter(c -> c.getWinner() != null).map(x -> x.getWinner()).collect(Collectors.toList()); 
		String winner_wc =  worldCupRepository.findOne((long) 64).getWinner();
		
		for(int i = 0; i < players.size(); i++) {
			
			int points=0;
			int pointsKO=0;
			int nbrGames=0;
			int nbrGoodScore=0; //5 points	
			int nbrGoodDiff=0; // 3 points
			int nbrGoodResult=0; // 2 points
			
//			
//			int points=players.get(i).getPoints();
//			int pointsKO=players.get(i).getPoints();
//			int nbrGames=players.get(i).getPoints();
//			int nbrGoodScore=players.get(i).getPoints(); //5 points	
//			int nbrGoodDiff=players.get(i).getPoints(); // 3 points
//			int nbrGoodResultplayers.get(i).getPoints(); // 2 points
			
			Player player = players.get(i);
			
			if (isPhase1Completed()) {
				List<Game> games08 = gameRepository.findKnockOutPhaseByType("08", players.get(i));
				List<Game> games08_b = games08;
				List<Game> games08_c = games08;	
				List<Game> games04 = gameRepository.findKnockOutPhaseByType("04", players.get(i));
				List<Game> games02 = gameRepository.findKnockOutPhaseByType("02", players.get(i));
				Game game01 = gameRepository.findOne(Long.parseLong(players.get(i).getId() + "64"));
				

				
				List<String> team_1_08 = games08.stream().map(x -> x.getHome()).collect(Collectors.toList());  
				List<String> team_2_08 = games08_b.stream().map(x -> x.getAway()).collect(Collectors.toList());
				List<String> team_04 = games08_c.stream().filter(c -> c.getWinner() != null).map(x -> x.getWinner()).collect(Collectors.toList());  
				List<String> team_02 = games04.stream().filter(c -> c.getWinner() != null).map(x -> x.getWinner()).collect(Collectors.toList());  
				List<String> team_01 = games02.stream().filter(c -> c.getWinner() != null).map(x -> x.getWinner()).collect(Collectors.toList()); 
				String winner = null;
				
				if (!(game01 == null)) {
					winner = game01.getWinner();
				}
				
				int w = 0;
				if ((winner_wc != null) && (winner != null)) {
					if (winner.equals(winner_wc)) {
						w = 1;
					}	
				}
				
				pointsKO = 5*(howManyInList(team_1_08,team_1_08wc)+howManyInList(team_2_08,team_2_08wc))
						+8*howManyInList(team_04,team_04wc)
						+15*howManyInList(team_02,team_02wc)
						+30*howManyInList(team_01,team_01wc)
						+50*w;			
			}
			
			for(int j = 0; j < worldCupGames.size(); j++) {
				
				WorldCup worldcup = worldCupGames.get(j);
				if (worldcup.getScoreAway() !=null 
						&& worldcup.getScoreHome() !=null 
						&& !player.getUsername().equals("user_admin")) {
					
					
					
					if (!isPhase1Completed()) { // phase 1 groups
						
						Game game = gameService.findGameByWorldCupByPlayer(worldcup, player);
						

							int p = gameService.getPointsByGame(worldcup, game);
						
							if (p >= 0) {
							
								game.setPoint(p);
								gameService.save(game);
							
								points = points+p;
								nbrGames++;
								if (p == 5) {
									nbrGoodScore++;
								} else if (p == 3) {
									nbrGoodDiff++;
								} else if (p == 2) {
									nbrGoodResult++;
								}
							}
					} else { // phase 2 final 
						
						Game game = gameService.findGameByWorldCupByPlayer(worldcup, player);
						
							int p = gameService.getPointsByGame(worldcup, game);
							p = p*2;
							if (p >= 0) {
						
								game.setPoint(p);
								gameService.save(game);
						
								points = points+p;
								nbrGames++;
								if (p == 10) {
									nbrGoodScore++;
								} else if (p == 6) {
									nbrGoodDiff++;
								} else if (p == 4) {
									nbrGoodResult++;
								}	
							}					
					} 	
				}
			}
			
			
			player.setNbrGames(nbrGames);
			player.setNbrGoodScore(nbrGoodScore);
			player.setNbrGoodDiff(nbrGoodDiff);
			player.setNbrGoodResult(nbrGoodResult);
			player.setPointsKO(pointsKO);
			player.setPoints(points);
			
			playerService.save(player);
		}
		
		for(int i = 0; i < worldCupGames.size(); i++) {		
			worldCupGames.set(i,save(worldCupGames.get(i)));
		}
		
		return worldCupGames;
		
	}


	private TeamInGroup setDrawTeam(TeamInGroup team, Integer gf, Integer ga) {
		team.setGames(team.getGames()+1);
		team.setDraw(team.getDraw()+1);
		team.setGoalFor(team.getGoalFor()+gf);
		team.setGoalAgainst(team.getGoalAgainst()+ga);
		team.setPoint(team.getPoint()+1);
		return team;
	}


	private TeamInGroup setLoseTeam(TeamInGroup team, Integer gf, Integer ga) {
		team.setGames(team.getGames()+1);
		team.setLose(team.getLose()+1);
		team.setGoalFor(team.getGoalFor()+gf);
		team.setGoalAgainst(team.getGoalAgainst()+ga);
		team.setGoalDiff(team.getGoalFor()-team.getGoalAgainst());
		return team;
	}


	private TeamInGroup setWinTeam(TeamInGroup team, Integer gf, Integer ga) {
		team.setGames(team.getGames()+1);
		team.setWin(team.getWin()+1);
		team.setPoint(team.getPoint()+3);
		team.setGoalFor(team.getGoalFor()+gf);
		team.setGoalAgainst(team.getGoalAgainst()+ga);
		team.setGoalDiff(team.getGoalFor()-team.getGoalAgainst());
		return team;
	}


	@Override
	public List<WorldCup> findGroupWorldCupGamesByType(String type) {
		
		return worldCupRepository.findWorldCupGamesByGroup(type);
	}

	private int howManyInList(List<String> l1, List<String> l2) {
		
		int n = 0;
		
		for (String a : l1) {
			for (String b : l2) {
				if ((a != null) && (b != null)) { 
					if (a.equals(b)) {
						n++;
					}
				}
			}
		}
	
		
		return n;
		
	}
	
}
