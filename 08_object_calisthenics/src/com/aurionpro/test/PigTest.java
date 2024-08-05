package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.PigRefactor;

public class PigTest {
	public static void main(String[] args) {

		  Scanner scanner = new Scanner(System.in);
		  PigRefactor player = new PigRefactor(); 
		  boolean won =false;
		  int no_of_lives = 6;
		  while(won != true && player.getNo_of_turns()<no_of_lives) {
		   won = play(scanner,player);
		  }
		  if(won==true) {
		   System.out.println("Congratulations, you win the game ! ");
		   System.out.println("Number of turns required : "+player.getNo_of_turns());
		   return;
		  }
		  System.out.println("Game Over, Better luck next time ! ");
		  
		 }
		 
		 public static boolean play(Scanner scanner,PigRefactor player) {
		  System.out.println("Enter you choice : ");
		  System.out.println("1 -> Roll ");
		  System.out.println("2 -> Hold ");
		  int choice = scanner.nextInt();
		  if(choice==1) {
		   player.roll();
		   return false;
		  }
		  boolean  won = player.hold();
		  return won;
		 }

}
