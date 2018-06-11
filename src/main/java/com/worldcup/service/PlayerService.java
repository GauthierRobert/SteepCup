package com.worldcup.service;

import java.util.List;

import com.worldcup.model.Player;

public interface PlayerService {

	List<Player> createRanking();
	
	Player createPlayer(String username);

	Player getCurrentPlayer(String username);

	Player save(Player player);
	
	List<String> ListAllPlayerUsername();

	Boolean isGroupCompleted(String group, Player player);

}
