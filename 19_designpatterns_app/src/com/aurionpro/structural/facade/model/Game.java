package com.aurionpro.structural.facade.model;

public class Game implements IGame {
    private IGameBoard board;
    private char currentPlayer;

    public Game(IGameBoard board) {
        this.board = board;
        this.currentPlayer = 'X';
    }

    @Override
    public boolean makeMove(int row, int col) {
        if (board.placeMove(row, col, currentPlayer)) {
            if (board.checkWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
            if (board.isFull()) {
                System.out.println("It's a draw!");
                return true;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
        }
        return false;
    }

    @Override
    public void printBoard() {
        board.printBoard();
    }
}
