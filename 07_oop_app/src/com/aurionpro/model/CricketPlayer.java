package com.aurionpro.model;

public class CricketPlayer {
	private int playerId;
	private String name;
	private int numberOfMatches;
	private int runs;
	private int numberOfWickets;
	public double average;
	
//	public CricketPlayer() { //default
//		playerId=7;
//		name="Dhoni";
//		numberOfMatches=67;
//		runs=4000;
//		numberOfWickets=23;
		
	//}
	public CricketPlayer(int playerId, String name, int numberOfMatches, int runs, int numberOfWickets) { //parameterized
		this.playerId=playerId;
		this.name=name;
		this.numberOfMatches=numberOfMatches;
		this.runs=runs;
		this.numberOfWickets=numberOfWickets;
	}
	public void setplayerId(int playerId) {
		this.playerId=playerId;		
	}
	public int getplayerId() {
		return playerId;
	}
	public void setname(String name) {
		this.name=name;		
	}
	public String name() {
		return name;
	}
	public void setnumberOfMatches(int numberOfMatches) {
		this.playerId=playerId;		
	}
	public int getnumberOfMatches() {
		return numberOfMatches;
	}
	public void setruns(int runs) {
		this.playerId=playerId;		
	}
	public int getruns() {
		return runs;
	}
	public void setnumberOfWickets(int numberOfWickets) {
		this.numberOfWickets=numberOfWickets;		
	}
	public int getnumberOfWickets() {
		return numberOfWickets;
	}
	public void setaverage(double average) {
		this.average=average;
	}
	public double getaverage() {
		return average;
	}
	
	

}
