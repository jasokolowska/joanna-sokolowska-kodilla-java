package com.kodilla.sudoku;

import com.kodilla.sudoku.model.SudokuBoard;

public class Main {
    public static void main(String[] args) {

        boolean gameFinished = false;
        while (!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }
    }
}
