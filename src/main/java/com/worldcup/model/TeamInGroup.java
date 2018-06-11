package com.worldcup.model;

public class TeamInGroup {
	
	
	private String team;	
	private String groupN;// A, B, C ...
	private Integer point; 
	private Integer games;
	private Integer win; 
	private Integer lose; 
	private Integer draw;
	private Integer goalFor; 
	private Integer goalAgainst;
	private Integer goalDiff;

	public TeamInGroup(String team, String groupN) {
		
		this.team = team;
		this.groupN = groupN;
		this.point = 0;
		this.games = 0;
		this.win  = 0;
		this.lose = 0;
		this.draw = 0;
		this.goalFor = 0;
		this.goalAgainst = 0;
		this.goalDiff = 0;
		
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getGroupN() {
		return groupN;
	}

	public void setGroupN(String groupN) {
		this.groupN = groupN;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getGames() {
		return games;
	}

	public void setGames(Integer games) {
		this.games = games;
	}

	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public Integer getLose() {
		return lose;
	}

	public void setLose(Integer lose) {
		this.lose = lose;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getGoalFor() {
		return goalFor;
	}

	public void setGoalFor(Integer goalFor) {
		this.goalFor = goalFor;
	}

	public Integer getGoalAgainst() {
		return goalAgainst;
	}

	public void setGoalAgainst(Integer goalAgainst) {
		this.goalAgainst = goalAgainst;
	}

	public Integer getGoalDiff() {
		return goalDiff;
	}

	public void setGoalDiff(Integer goalDiff) {
		this.goalDiff = goalDiff;
	}

	
	
}
