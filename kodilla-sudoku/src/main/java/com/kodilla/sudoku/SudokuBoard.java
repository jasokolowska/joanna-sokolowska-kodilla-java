package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> board = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            board.add(new SudokuRow());
        }
    }

    public void addValue(int column, int row, int number) {
        board.get(row).addValueInRow(column, number);
    }

    @Override
    public String toString() {
        Iterator<SudokuRow> iterator = board.listIterator();
        StringBuilder board = new StringBuilder();
        String midLinePattern = "\n  |-----|-----|-----|-----|-----|-----|-----|-----|-----|\n";
        while (iterator.hasNext()) {
            board.append(iterator.next().toString()).append(midLinePattern);
        }
        return midLinePattern + board;
    }
}
