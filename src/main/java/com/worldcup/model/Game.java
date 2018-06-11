package com.worldcup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Game {
	
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@NotNull
	private String home;

	@NotNull
	private String away;

	private Integer scoreHome;

	private Integer scoreAway;

	private Integer point;
		
	private String winner; // for Knock out phase
	
	@ManyToOne
	private Player player;
	
	@NotNull
	private String gameTime;
	
	@NotNull
	private String gameDate;
	
	@NotNull
	private String type;// PO poule, 08 8eme, 04, 02, 01 !!!
	
	@NotNull
	private String seq; // 01, 02, Numero du game
	
	@ManyToOne
	private WorldCup worldCup;
	
	public Game() {
		
	}

	public Game(WorldCup worldCup) {

		this.home = worldCup.getHome();
		this.away = worldCup.getAway();
		this.gameTime = worldCup.getGameTime();
		this.gameDate = worldCup.getGameDate();
		this.type = worldCup.getType();
		this.seq = worldCup.getSeq();
		this.worldCup = worldCup;
		
	}

	public String getAway() {
		return away;
	}

	public String getGameDate() {
		return gameDate;
	}

	public String getGameTime() {
		return gameTime;
	}

	public String getHome() {
		return home;
	}

	public long getId() {
		return id;
	}

	public Player getPlayer() {
		return player;
	}

	public String getSeq() {
		return seq;
	}

	public String getType() {
		return type;
	}

	public WorldCup getWorldCup() {
		return worldCup;
	}

	public void setAway(String away) {
		this.away = away;
	}
	
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public void setWorldCup(WorldCup worldCup) {
		this.worldCup = worldCup;
	}

	public Integer getScoreHome() {
		return scoreHome;
	}

	public void setScoreHome(Integer scoreHome) {
		this.scoreHome = scoreHome;
	}

	public Integer getScoreAway() {
		return scoreAway;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public void setScoreAway(Integer scoreAway) {
		this.scoreAway = scoreAway;
	}

	

}
