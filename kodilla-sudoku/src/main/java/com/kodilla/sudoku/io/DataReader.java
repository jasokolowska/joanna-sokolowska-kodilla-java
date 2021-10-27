package com.kodilla.sudoku.io;

import com.kodilla.sudoku.model.SudokuElement;

import java.util.Scanner;

public class DataReader {
    Scanner sc = new Scanner(System.in);

    public DataReader() {
    }

    public String readInput() {
        System.out.println("Enter number from 1 to 9 and coordinates where it should be placed,\n" +
                "in format: col,row,number or enter 'SUDOKU' to solve sudoku or D to load demo Sudoku:");

        return sc.nextLine();
    }

    public String readString() {
        return sc.nextLine();
    }

    public int readInteger() {
        int integer = sc.nextInt();
        sc.nextLine();
        return integer;
    }

    public void close() {
        sc.close();
    }
}
