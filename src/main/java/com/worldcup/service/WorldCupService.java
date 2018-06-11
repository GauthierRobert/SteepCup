package com.worldcup.service;

import java.util.List;

import com.worldcup.model.WorldCup;

public interface WorldCupService {
	
	List<WorldCup> saveListWorldCup(List<WorldCup> worldCupGames);

	List<WorldCup> findAllWorldCupGames();

	Boolean isPhase1Completed();
	
	Boolean isPhaseTypeCompleted(String type);

	List<WorldCup> findGroupWorldCupGames();
	
	List<WorldCup> findGroupWorldCupGamesByType(String type);
	
	void fillRoundOf16();

	void fillQuarters();

	void fillSemis();

	void fillFinals();

}
