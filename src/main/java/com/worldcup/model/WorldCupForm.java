package com.worldcup.model;

import java.util.List;

public class WorldCupForm {

	private List<WorldCup> worldCupGames;

	public WorldCupForm(List<WorldCup> worldCupGames) {
	    this.worldCupGames = worldCupGames;
	}

		public List<WorldCup> getWorldCupGames() {
		return worldCupGames;
	}
	     
	public void setWorldCupGames(List<WorldCup> worldCupGames) {
		this.worldCupGames = worldCupGames;
	}


}

