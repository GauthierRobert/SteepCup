package com.worldcup.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldcup.model.Game;
import com.worldcup.model.Player;
import com.worldcup.repository.GameRepository;
import com.worldcup.repository.PlayerRepository;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public List<Player> createRanking() {

		return playerRepository.createRankingPlayers();
		
	}
	


	@Override
	public Player createPlayer(String username) {
		Player player = new Player();
		player.setUsername(username);
		
		return player;
	}

	
	@Override
	public Player save(Player player) {
		
		return playerRepository.save(player);
		
	}


	@Override
	public Player getCurrentPlayer(String username) {
		
		return playerRepository.findPlayerByUsername(username);
	}



	@Override
	public List<String> ListAllPlayerUsername() {
		
		Stream<Player> players = playerRepository.findAllStream();
				
		return players.map(x -> x.getUsername()).collect(Collectors.toList());
	}



	@Override
	public Boolean isGroupCompleted(String group, Player player) {

		List<Game> Games16 = gameRepository.findGroupGames(group, player);
		
		for (Game game : Games16) {
			if(game.getScoreAway()==null || game.getScoreAway()==null) {
				return false;
			}
		}
		
		return true;
		
	}
	

	
}
