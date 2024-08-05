package com.aurionpro.model;

import java.util.Random;

public class PigRefactor {
	private int no_of_turns;
	 private int turn_score;
	 private int total_score;
	 
	 
	 
	 
	 public boolean hold() {
	  this.total_score+=turn_score;
	  System.out.println("Score for turn: "+this.turn_score);
	  System.out.println("Total score: "+this.total_score);
	  this.turn_score=0;
	  this.no_of_turns++;
	  boolean won = hasWon();
	  return won;
	 }
	 
	 public void roll() {
	  Random random = new Random();
	  int roll = random.nextInt(6)+1;
	  System.out.println("Die: " + roll);
	  if(roll==1) {
	   this.turn_score=0;
	   System.out.println("Turn over. No score.");
	   this.no_of_turns++;
	   return;
	  }
	  this.turn_score+=roll;
	 }
	 public boolean hasWon() {
	  if(total_score>=20) {
	   return true;
	  }
	  return false;
	 }

	 public int getNo_of_turns() {
	  return no_of_turns;
	 }

}
