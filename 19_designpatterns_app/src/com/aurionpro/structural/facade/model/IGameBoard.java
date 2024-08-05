package com.aurionpro.structural.facade.model;

public interface IGameBoard {
    boolean placeMove(int row, int col, char symbol);
    boolean checkWin(char symbol);
    boolean isFull();
    void printBoard();
}
