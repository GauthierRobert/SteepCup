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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	private User user;
    
	private String username;

	private int points;
	
	private int pointsKO;

	public int getPointsKO() {
		return pointsKO;
	}
	public void setPointsKO(int pointsKO) {
		this.pointsKO = pointsKO;
	}
	private int nbrGames;
	
	private int nbrGoodScore; //5 points
	
	private int nbrGoodDiff; // 3 points
	
	private int nbrGoodResult; // 2 points 
	
	@OneToMany(mappedBy="player", fetch= FetchType.LAZY, cascade=CascadeType.ALL )
	private List<Game> games = new ArrayList<Game>();
	
	@OneToMany(mappedBy="player", fetch= FetchType.LAZY, cascade=CascadeType.ALL )
	private List<KnockOutPhase> KnockOutPhases = new ArrayList<KnockOutPhase>();
	
	public Player() {
		this.points = 0;
		this.pointsKO = 0;
		this.nbrGames = 0;
		this.nbrGoodDiff = 0;
		this.nbrGoodScore = 0;
		this.nbrGoodResult = 0;
	}
	public List<Game> getGames() {
		return games;
	}
	public long getId() {
		return id;
	}
	public List<KnockOutPhase> getKnockOutPhases() {
		return KnockOutPhases;
	}
	public int getNbrGames() {
		return nbrGames;
	}
	
	public int getNbrGoodDiff() {
		return nbrGoodDiff;
	}
	
	public int getNbrGoodResult() {
		return nbrGoodResult;
	}

	public int getNbrGoodScore() {
		return nbrGoodScore;
	}

	public int getPoints() {
		return points;
	}

	public User getUser() {
		return user;
	}

	public String getUsername() {
		return username;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setKnockOutPhases(List<KnockOutPhase> knockOutPhases) {
		KnockOutPhases = knockOutPhases;
	}

	public void setNbrGames(int nbrGames) {
		this.nbrGames = nbrGames;
	}

	public void setNbrGoodDiff(int nbrGoodDiff) {
		this.nbrGoodDiff = nbrGoodDiff;
	}

	public void setNbrGoodResult(int nbrGoodResult) {
		this.nbrGoodResult = nbrGoodResult;
	}

	public void setNbrGoodScore(int nbrGoodScore) {
		this.nbrGoodScore = nbrGoodScore;
	}


	public void setPoints(int points) {
		this.points = points;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
