package com.aurionpro.model;

public class CricketerApp {
	private int playerId;
    private String name;
    private int matches;
    private int runs;
    private int wickets;
    public double average;

    public CricketerApp(int playerId, String name, int matches, int runs, int wickets) {
        this.playerId = playerId;
        this.name = name;
        this.matches = matches;
        this.runs = runs;
        this.wickets = wickets;
        this.average = calculateAverage();
    }
    public void setPlayerId(int playerId)
	{
		this.playerId = playerId;
	}

	public int getPlayerId()
	{
		return this.playerId;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}
	
	public void setMatches(int Matches)
	{
		this.matches = Matches;
	}

	public int getMatches()
	{
		return this.matches;
	}
	public void setRuns(int runs)
	{
		this.runs= runs;
	}

	public int getRuns()
	{
		return this.runs;
	}
	public void setWickets(int wickets)
	{
		this.wickets= wickets;
	}

	public int getWickets()
	{
		return this.wickets;
	}
	public  double calculateAverage()
	{
		double result = runs/matches;
		System.out.println("Average:"+result);
		return result;
	}
	public void display()
	{
		System.out.println("Player ID: " + playerId);
        System.out.println("Name: " + name);
        System.out.println("Matches Played: " + matches);
        System.out.println("Runs Scored: " + runs);
        System.out.println("Wickets Taken: " + wickets);
        System.out.println("Average: " + calculateAverage());

	}

}