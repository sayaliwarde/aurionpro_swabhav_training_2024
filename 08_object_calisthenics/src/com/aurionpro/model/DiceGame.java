package com.aurionpro.model;

import java.util.Random;

public class DiceGame {
	int turnScore;
	int turn;
	int totalScore;
//    int WINNING_SCORE = 20;		//private static final

    public DiceGame() {
        this.turn = 0;
        this.turnScore = 0;
        this.totalScore = 0;
    }

    // Method to hold the current turn score and check for a win
    public boolean hold() {
        totalScore += turnScore;
        System.out.println("Score for turn: " + turnScore);
        System.out.println("Total score: " + totalScore);
        turnScore = 0;
        turn++;
        return hasWon();
    }

    // Method to roll the dice and update turn score accordingly
    public void roll() {
        Random random = new Random();
        int roll = random.nextInt(6) + 1;
        System.out.println("Die: " + roll);

        if (roll == 1) {
            System.out.println("Turn over. No score.");
            turnScore = 0;
            turn++;
            return;
        }

        turnScore += roll;
    }

    // Check if the player has won
    public boolean hasWon() {
        return totalScore >= 20;
    }

    // Getter for number of turns played
    public int getturns() {
        return turn;
    }
	

	
	

}
