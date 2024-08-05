package com.aurionpro.structural.facade.model;

public class GameBoard implements IGameBoard {
    private static final int size = 3;
    private char[][] board;

    public GameBoard() {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean placeMove(int row, int col, char symbol) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkWin(char symbol) {
        
        for (int i = 0; i < size; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) 
            	return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) 
            	return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) 
        	return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) 
        	return true;
        
        return false;
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]); 	//current state of the board
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) System.out.println("-----");
        }
    }
}
