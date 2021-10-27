package com.kodilla.sudoku.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> row = new ArrayList<>();

    public SudokuRow(int rowNbr) {
        for (int col = 0; col < 9; col++) {
            row.add(new SudokuElement(col, rowNbr, SudokuElement.EMPTY));
        }
    }

    public void updateValueInRow(int index, int number) {
            row.get(index).setValue(number);
    }

    public List<SudokuElement> getRow() {
        return row;
    }

    @Override
    public String toString() {
        Iterator<SudokuElement> iterator = row.listIterator();
        String row = "";
        while (iterator.hasNext()) {
            row += ("  |  " + iterator.next().toString());
        }
        return row + "  |";
    }
}
