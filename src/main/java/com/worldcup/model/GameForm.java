package com.worldcup.model;

import java.util.List;

public class GameForm {
	

    private List<Game> games;
     
    public GameForm(List<Game> games) {
        this.games = games;
    }

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}



}
