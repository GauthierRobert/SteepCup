package com.worldcup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class WorldCup {

	// List of all games in the world cup
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@NotNull
	private String home;

	@NotNull
	private String away;
	
	@NotNull
	private String gameTime;
	
	@NotNull
	private String gameDate;
	
	private Integer scoreHome;
	private Integer scoreAway;
	private Integer pointHome;
	private Integer pointAway;
	
	private String winner; // for Knock out phase

	@NotNull
	private String type;// PO poule, 08 8eme, 04, 02, 01 !!!

	@NotNull
	private String seq; // 01, 02, Numero du game
	


	@OneToMany(mappedBy="worldCup", fetch= FetchType.LAZY, cascade=CascadeType.ALL )
	private List<Game> games = new ArrayList<Game>();

	public String getAway() {
		return away;
	}

	public String getGameDate() {
		return gameDate;
	}

	public List<Game> getGames() {
		return games;
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

	public Integer getPointAway() {
		return pointAway;
	}

	public Integer getPointHome() {
		return pointHome;
	}

	public Integer getScoreAway() {
		return scoreAway;
	}

	public Integer getScoreHome() {
		return scoreHome;
	}

	public String getSeq() {
		return seq;
	}

	public String getType() {
		return type;
	}

	public String getWinner() {
		return winner;
	}

	public void setAway(String away) {
		this.away = away;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public void setGames(List<Game> games) {
		this.games = games;
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

	public void setPointAway(Integer pointAway) {
		this.pointAway = pointAway;
	}

	public void setPointHome(Integer pointHome) {
		this.pointHome = pointHome;
	}

	public void setScoreAway(Integer scoreAway) {
		this.scoreAway = scoreAway;
	}

	public void setScoreHome(Integer scoreHome) {
		this.scoreHome = scoreHome;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	
}
