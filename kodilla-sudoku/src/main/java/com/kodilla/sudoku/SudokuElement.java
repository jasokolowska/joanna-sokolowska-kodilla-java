package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;

    private int value;
    private List<Integer> possibleValues;

    public SudokuElement(int value) {
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

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public String toString() {
        if (value < 0) {
            return " ";
        }
        return "" + value;
    }
}
