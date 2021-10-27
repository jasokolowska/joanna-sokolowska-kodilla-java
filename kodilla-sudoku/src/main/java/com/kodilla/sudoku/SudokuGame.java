package com.kodilla.sudoku;

import com.kodilla.sudoku.io.DataReader;
import com.kodilla.sudoku.model.SudokuBoard;
import com.kodilla.sudoku.model.SudokuElement;
import com.kodilla.sudoku.model.SudokuRow;

import java.util.List;

public class SudokuGame {
    private final SudokuBoard board;
    private final DataReader reader;

    public SudokuGame() {
        this.reader = new DataReader();
        this.board = new SudokuBoard();
        fillInSudoku();
    }

    private void fillInSudoku() {
        System.out.println(board);
        String result = reader.readInput().toUpperCase();

        while (!result.equals("SUDOKU")) {

            if (result.equals("D")) {
                prepareDemo();
                System.out.println(board);
            } else {
                String[] input = result.split(",");
                if (board.addValue(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]))) {
                    System.out.println(board);
                } else {
                    System.out.println("Try again, this numbers are not allowed");
                }
            }
            result = reader.readInput().toUpperCase();
        }
        try {
            solveSudoku();
        } catch (SudokuUnsolvableException e) {
            e.getMessage();
        }

    }

    public void solveSudoku() throws SudokuUnsolvableException {
        List<SudokuRow> sudokuRows = board.getBoard();
        int counter = 0;


        while (checkBoardFill()) {
            for (int i = 0; i < sudokuRows.size(); i++) {

                for (int j = 0; j < sudokuRows.get(i).getRow().size(); j++) {

                    SudokuElement sudokuElement = sudokuRows.get(i).getRow().get(j);

                    if (sudokuElement.getValue() == -1) {
                        List<Integer> possibleValues = getRemainingValues(j, i, sudokuElement.getPossibleValues());
                        if (possibleValues.size() == 1) {
                            sudokuElement.setValue(possibleValues.get(0));
                        } else if (possibleValues.size() > 1) {
                            for (Integer possibleValue : possibleValues) {
                                if (checkIfCanBeInDifferentField(i, j, possibleValue)) {
                                    sudokuElement.setValue(possibleValue);
                                }
                            }
                        } else {
                            throw new SudokuUnsolvableException("This sudoku can not be solved");
                        }
                    }
                }
            }
            counter++;
        }
        System.out.println(board);
    }

    private boolean checkBoardFill() {
        List<SudokuElement> emptySudokuElements = board.getBoard().stream()
                .flatMap(sudokuRow -> sudokuRow.getRow().stream())
                .filter(sudokuElement -> sudokuElement.getValue() == -1)
                .toList();

        if (emptySudokuElements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIfCanBeInDifferentField(int i, int j, Integer possibleValue) {
        List<List<Integer>> blockElements = getPossibleValuesForElements(possibleValue, board.getBlock(j, i));
        List<List<Integer>> columnElements = getPossibleValuesForElements(possibleValue, board.getColumn(j, i));
        List<List<Integer>> rowElements = getPossibleValuesForElements(possibleValue, board.getRow(j, i));

        return blockElements.size() == 0 || columnElements.size() == 0 || rowElements.size() == 0;
    }

    private List<List<Integer>> getPossibleValuesForElements(Integer possibleValue, List<SudokuElement> block) {
        return block.stream()
                .filter(sudokuElement -> sudokuElement.getValue() == -1)
                .map(sudokuElement -> getRemainingValues(sudokuElement.getCol(),
                        sudokuElement.getRow(), sudokuElement.getPossibleValues()))
                .filter(possibleValues -> possibleValues.contains(possibleValue))
                .toList();
    }

    private List<Integer> getRemainingValues(int col, int row, List<Integer> possibleValues) {
        List<Integer> block = board.getBlock(col, row).stream()
                .map(SudokuElement::getValue)
                .toList();
        List<Integer> column = board.getColumn(col, row).stream()
                .map(SudokuElement::getValue)
                .toList();
        List<Integer> currentRow = board.getRow(col, row).stream()
                .map(SudokuElement::getValue)
                .toList();

        possibleValues.removeIf(possibleValue -> block.contains(possibleValue)
                || column.contains(possibleValue)
                || currentRow.contains(possibleValue));

        return possibleValues;
    }

    public boolean resolveSudoku() {
        System.out.println("Enter Y to play next sudoku or Q to quit: ");
        String choice = reader.readString().toUpperCase();

        while (true) {
            if (choice.equals("Y")) {
                return false;
            } else if (choice.equals("Q")) {
                return true;
            } else {
                System.out.println("Enter correct option: Y to play another round or Q to quit");
            }
        }
    }

    private void prepareDemo() {
        board.addValue(2, 1, 2);
        board.addValue(4, 1, 5);
        board.addValue(6, 1, 1);
        board.addValue(8, 1, 9);
        board.addValue(1, 2, 8);
        board.addValue(4, 2, 2);
        board.addValue(6, 2, 3);
        board.addValue(9, 2, 6);
        board.addValue(2, 3, 3);
        board.addValue(5, 3, 6);
        board.addValue(8, 3, 7);
        board.addValue(3, 4, 1);
        board.addValue(7, 4, 6);
        board.addValue(1,5,5);
        board.addValue(2,5,4);
        board.addValue(8,5,1);
        board.addValue(9,5,9);
        board.addValue(3,6,2);
        board.addValue(7,6,7);
        board.addValue(2,7,9);
        board.addValue(5,7,3);
        board.addValue(8,7,8);
        board.addValue(1,8,2);
        board.addValue(4,8,8);
        board.addValue(6,8,4);
        board.addValue(9,8,7);
        board.addValue(2,9,1);
        board.addValue(4,9,9);
        board.addValue(6,9,7);
        board.addValue(8,9,6);
        board.addValue(4,4,3);
        board.addValue(5,5,2);
        board.addValue(6,6,9);
    }
}
