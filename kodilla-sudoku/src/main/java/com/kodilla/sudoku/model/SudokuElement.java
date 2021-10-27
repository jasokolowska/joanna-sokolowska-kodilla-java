package com.kodilla.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;

    private int col;
    private int row;
    private int value;
    private List<Integer> possibleValues;

    public SudokuElement(int col, int row, int value) {
        this.col = col;
        this.row = row;
        this.value = value;
        this.possibleValues = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            if (i != value) {
                possibleValues.add(i);
            }
        }
    }

    public void removeValue(Integer number) {
        possibleValues.remove(number);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        if (value < 0) {
            return " ";
        }
        return "" + value;
    }
}
