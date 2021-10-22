package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> row = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            row.add(new SudokuElement(SudokuElement.EMPTY));
        }
    }

    public void addValueInRow (int index, int number) {
        row.remove(index);
        row.add(index, new SudokuElement(number));
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
