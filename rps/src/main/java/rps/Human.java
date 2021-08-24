package rps;

import java.util.Scanner;

public class Human implements Player {
    private static Scanner SC = new Scanner(System.in);

    private String name;
    private int roundsWon;

    public Human() {
        this.name = createNewPlayer();
    }

    public String getName() {
        return name;
    }

    public String createNewPlayer() {
        System.out.println("Podaj imię: ");
        return SC.nextLine();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }
}
