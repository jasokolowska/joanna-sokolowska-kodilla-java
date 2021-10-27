package com.kodilla.sudoku.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> board = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            board.add(new SudokuRow(i));
        }
    }

    public boolean addValue(int column, int row, int number) {
        if (column > 0 && column < 10 && row > 0 && row < 10 && number > 0 && number < 10) {
            board.get(row-1).updateValueInRow(column-1, number);
            return true;
        }
        return false;
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public List<SudokuElement> getRow(int colIndex, int rowIndex) {
        List<SudokuElement> row = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {
            if (i != colIndex) {
                row.add(board.get(rowIndex).getRow().get(i));
            }
        }
        return row;
    }

    public List<SudokuElement> getColumn(int col, int row) {
        List<SudokuElement> column = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            if (i != row) {
                column.add(board.get(i).getRow().get(col));
            }
        }
        return column;
    }

    public List<SudokuElement> getBlock(int col, int row) {
        List<SudokuElement> block = new ArrayList<>();

        List<Integer> columnIndexes = getBlockIndexes(col);
        List<Integer> rowIndexes = getBlockIndexes(row);

        for (Integer rowIndex : rowIndexes) {
            for (Integer columnIndex : columnIndexes) {
                if (rowIndex != row || columnIndex != col){
                    block.add(getBoard().get(rowIndex).getRow().get(columnIndex));
                }

            }
        }
        return block;
    }

    private List<Integer> getBlockIndexes(int col) {
        List<Integer> indexes = new ArrayList<>();

        if (col /3 == 2) {
            indexes.addAll(List.of(6,7,8));
        } else if (col /3 == 1) {
            indexes.addAll(List.of(3,4,5));
        } else {
            indexes.addAll(List.of(0,1,2));
        }
        return indexes;
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
