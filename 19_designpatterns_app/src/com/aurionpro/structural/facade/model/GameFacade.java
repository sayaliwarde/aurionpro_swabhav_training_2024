package com.aurionpro.structural.facade.model;

import java.util.Scanner;

public class GameFacade {
    private IGame game;

    public GameFacade(IGame game) {
        this.game = game;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        while (!gameEnded) {
            game.printBoard();
            System.out.println("Enter row and column for the move:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            gameEnded = game.makeMove(row, col);
        }
        scanner.close();
    }

//    public static void main(String[] args) {
//        IGameBoard board = new GameBoard();
//        IGame game = new Game(board);
//        GameFacade facade = new GameFacade(game);
//        facade.startGame();
//    }
}
