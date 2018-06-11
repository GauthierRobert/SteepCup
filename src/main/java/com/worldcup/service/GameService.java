package com.worldcup.service;

import java.util.List;

import com.worldcup.model.Game;
import com.worldcup.model.GameForm;
import com.worldcup.model.KnockOutPhase;
import com.worldcup.model.KnockOutPhaseForm;
import com.worldcup.model.Player;
import com.worldcup.model.WorldCup;

public interface GameService {

	List<Game> createEmptyGroups(Player player);
	
	List<Game> createEmptyKnockOutStage(Player player);

	List<Game> createRoundOf(Player player, String type);
	
	void fillGroupForRoundOf16(Player player, String group);
	
	GameForm findFinalPhase(Player player);
	
	Game findGameByWorldCupByPlayer(WorldCup worldCup,Player player);
	
	GameForm findGroupGames(String group, Player player);
	
	GameForm findKnockOutPhase(Player player);
	
	KnockOutPhaseForm findKnockOutPhaseForm(Player player);
	
	List<Game> findListByPlayer(Player player);
	
	int getPointsByGame(WorldCup worldCup, Game game);

	Game save(Game game);

	List<Game> saveList(List<Game> pronostic);

	List<KnockOutPhase> saveListKnockOutPhase(List<KnockOutPhase> games);

	void createRoundOfForAll(String type);

	




	
}
