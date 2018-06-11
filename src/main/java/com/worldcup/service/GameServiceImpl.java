package com.worldcup.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldcup.model.Game;
import com.worldcup.model.GameForm;
import com.worldcup.model.KnockOutPhase;
import com.worldcup.model.KnockOutPhaseForm;
import com.worldcup.model.Player;
import com.worldcup.model.TeamInGroup;
import com.worldcup.model.WorldCup;
import com.worldcup.repository.GameRepository;
import com.worldcup.repository.KnockOutPhaseRepository;
import com.worldcup.repository.PlayerRepository;
import com.worldcup.repository.WorldCupRepository;

@Service("gameService")
public class GameServiceImpl implements GameService{
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private WorldCupRepository worldCupRepository;
	
	@Autowired
	private WorldCupService worldCupService;
	
	@Autowired
	private KnockOutPhaseRepository knockOutPhaseRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	
	@Override
	@Transactional
	public List<Game> createEmptyGroups(Player player) { 
		
		List<WorldCup> worldCup  = worldCupRepository.findGroupWorldCupGames();
		
		List<Game> games = new ArrayList<Game>();
		
		for (int i = 0; i < worldCup.size(); i++) {
			
			Game game = new Game(worldCup.get(i));
			
			game.setPlayer(player);
			games.add(i,game);
			
		}
		
		return saveList(games);

	}
	
	@Override
	@Transactional
	public List<Game> createEmptyKnockOutStage(Player player) { 
		
		List<WorldCup> worldCup  = worldCupRepository.findKnockOutWorldCupGames();
		
		List<Game> games = new ArrayList<Game>();
		
		for (int i = 0; i < worldCup.size(); i++) {
			
			Game game = new Game(worldCup.get(i));
			Game game2 = new Game(worldCup.get(i));
			
			game.setWorldCup(null);
			game.setPlayer(player);
			
			game2.setPlayer(player);
			
			games.add(i,game);
			games.add(i,game2);
			
		}
		
		return saveList(games);

	}
	
	@Override
	@Transactional
	public void createRoundOfForAll(String type) {
		
		List<Player> players = playerRepository.findAll();
		
		for (Player player : players) {
			if(!(player.getUsername().equals("user_admin"))) {
				createRoundOf(player, type);
			}
		}
	}
	

	@Override
	@Transactional
	public List<Game> createRoundOf(Player player,String type) { 

		
		List<WorldCup> worldCup  = worldCupRepository.findWorldCupGamesByGroup(type);
		
		List<Game> games = new ArrayList<Game>();
		
		for (int i = 0; i < worldCup.size(); i++) {
			
			
			Game game = new Game(worldCup.get(i));
		
			Game game_same = gameRepository.findGameByWorldCupByPlayer(worldCup.get(i), player);
			
			if (game_same.getScoreHome() == null && game_same.getScoreAway() == null) {
			
				game.setPlayer(player);
				games.add(i,game);
				
			}
		}
		
		return saveList(games);

	}
	
	
	@Override
	public void fillGroupForRoundOf16(Player player, String group) {
		
		List<Game> GamesGroup = gameRepository.findGroupGames(group, player);
		
		List<TeamInGroup> group12 = get12(GamesGroup, group);
		
		String G1 = group12.get(3).getTeam();
		String G2 = group12.get(2).getTeam();
		
		KnockOutPhase R16_1 = new KnockOutPhase();
		R16_1.setPlayer(player);
		R16_1.setTeam(G1);
		R16_1.setType("08");
		R16_1.setSeq("1" + transform(group));

		save(R16_1);
		
		KnockOutPhase R16_2 = new KnockOutPhase();
		R16_2.setPlayer(player);
		R16_2.setTeam(G2);
		R16_2.setType("08");
		R16_2.setSeq("2" + transform(group));

		save(R16_2);
			
		List<Game> Games08 = gameRepository.findKnockOutPhaseByType("08", player);
		
		for (Game game : Games08) {
			
			if (game.getHome().equals("1" + group)) {
				game.setHome(G1);
				save(game);
			}

			if (game.getAway().equals("2" + group)) {
				game.setAway(G2);
				save(game);
				
			}
			
			
		}
	}
	
	@Override
	public Game findGameByWorldCupByPlayer(WorldCup worldCup, Player player) {
		
		    return gameRepository.findGameByWorldCupByPlayer(worldCup, player);
		
	}

	@Override
	@Transactional
	public GameForm findGroupGames(String group, Player player) {

		List<Game> games = gameRepository.findGroupGames(group,player);
		
		return new GameForm(games);
	}
	
	@Override
	public GameForm findKnockOutPhase(Player player) {

		List<Game> games = gameRepository.findKnockOutPhase(player);
		
		return new GameForm(games);
	}

	@Override
	public GameForm findFinalPhase(Player player) {

		List<Game> games = gameRepository.findFinalPhase(player);
		
		return new GameForm(games);
	}

	@Override
	@Transactional
	public KnockOutPhaseForm findKnockOutPhaseForm(Player player) {

		List<KnockOutPhase> games = knockOutPhaseRepository.findKnockOutPhaseForm(player);
		
		return new KnockOutPhaseForm(games);
	}
	
	@Override
	public List<Game> findListByPlayer(Player player) {
	
		return gameRepository.findListByPlayer(player);
	}

	public List<TeamInGroup> get12 (List<Game> GamesGroup, String group) {
		
		List<String>  teams = worldCupRepository.findWorldCupGamesByGroup(group)
				.stream().map(x -> x.getHome()).distinct().collect(Collectors.toList());
		
		List<TeamInGroup> groupRanking = new ArrayList<TeamInGroup>();
		
		for (String team : teams) {
			groupRanking.add(new TeamInGroup(team,group));
		}
		
		for (Game game : GamesGroup) {
			
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

	private int getDiff(int Home, int Away) {
		
		return Home-Away;
		
	}

	public int getPointsByGame(WorldCup worldCup, Game game) {
		
		if (game.getScoreHome()==null || game.getScoreAway()==null || game == null) {
			return -1;
		} else {
		
			int wcHome = worldCup.getScoreHome().intValue();
			int wcAway = worldCup.getScoreAway().intValue();
			int pHome = game.getScoreHome().intValue();
			int pAway = game.getScoreAway().intValue();
			
			if (getResult(worldCup).equals(getResult(game))) {
				if (wcHome == pHome && wcAway == pAway) {				
					return 5;			
				} else if (getDiff(wcHome,wcAway)==getDiff(pHome,pAway)){
					return 3;
				}
				return 2;
			} else {
				return 0;
			}
		}
	}
	
	private String getResult(Game game) {

		int Home = game.getScoreHome().intValue();
		int Away = game.getScoreAway().intValue();
		
		if (Home > Away) {
			return game.getHome();
		} else if (Home == Away) {
			return "Draw";	
		} else {
			return game.getAway();
		}
		
	}
	
	private String getResult(WorldCup worldCup) {
		
		int Home = worldCup.getScoreHome().intValue();
		int Away = worldCup.getScoreAway().intValue();
		
		if (Home > Away) {
			return worldCup.getHome();
		} else if (Home == Away) {
			return "Draw";	
		} else {
			return worldCup.getAway();
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
	
	@Transactional
	public Game save(Game game) {
		String id_s;
		if (game.getWorldCup() == null) {
			id_s = Long.toString(game.getPlayer().getId()) + game.getType() + game.getSeq() ;

		} else {
			id_s = Long.toString(game.getPlayer().getId()) +  Long.toString(game.getWorldCup().getId());
		}
		
		long id = Long.parseLong(id_s);
		game.setId(id);
		
		if (worldCupService.isPhase1Completed()) {
			Game game2 = gameRepository.findOne(id);
			if (game2.getWinner() != null) {
				return game2;	
			}
		}
		
		game = gameRepository.save(game);
		
		return game;
	}
	
	
	@Transactional
	public KnockOutPhase save(KnockOutPhase team) {
		
		String id_s = Long.toString(team.getPlayer().getId()) + team.getType() + team.getSeq();
		long id = Long.parseLong(id_s);
		team.setId(id);
		
		team = knockOutPhaseRepository.save(team);
		
		return team;
	}
	
	
	@Override
	@Transactional
	public List<Game> saveList(List<Game> pronostic) { 
		
		for(int i = 0; i < pronostic.size(); i++) {
			pronostic.set(i,save(pronostic.get(i)));
		}
		
		return pronostic;
	}
	
	@Override
	public List<KnockOutPhase> saveListKnockOutPhase(List<KnockOutPhase> games) {
		// TODO Auto-generated method stub
		return null;
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

	private int transform (String group) {
		if (group.equals("A")){
			return 1;
		} else if (group.equals("B")) {
			return 2;
		} else if (group.equals("C")) {
			return 3;
		} else if (group.equals("D")) {
			return 4;
		} else if (group.equals("E")) {
			return 5;
		} else if (group.equals("F")) {
			return 6;
		} else if (group.equals("G")) {
			return 7;
		} else if (group.equals("H")) {
			return 8;
		}
		return 0;
	}



}
