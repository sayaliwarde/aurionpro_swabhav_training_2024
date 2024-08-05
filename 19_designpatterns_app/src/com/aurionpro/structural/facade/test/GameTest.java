package com.aurionpro.structural.facade.test;

import com.aurionpro.structural.facade.model.Game;
import com.aurionpro.structural.facade.model.GameBoard;
import com.aurionpro.structural.facade.model.GameFacade;
import com.aurionpro.structural.facade.model.IGame;
import com.aurionpro.structural.facade.model.IGameBoard;

public class GameTest {
	
	    public static void main(String[] args) {
	        IGameBoard board = new GameBoard();
	        IGame game = new Game(board);
	        GameFacade facade = new GameFacade(game);
	        facade.startGame();
	    }
	


}
