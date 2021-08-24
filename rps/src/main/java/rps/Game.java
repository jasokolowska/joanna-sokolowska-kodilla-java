package rps;

import java.util.Scanner;

public class Game {
    private static Scanner SC = new Scanner(System.in);

    private int playerScore;
    private int computerScore;
    private int numberOfRounds;
    private int currentRounds;

    public Game() {
        this.numberOfRounds = startNewGame();
        this.playerScore = 0;
        this.computerScore = 0;
    }

    private static int startNewGame() {
        System.out.println("Podaj liczbę rund: ");
        int numberOfRounds = SC.nextInt();
        SC.nextLine();
        return numberOfRounds;
    }
    public void returnResult() {
        System.out.println("*****************************");
        System.out.println("Liczba zdobytych punktów: " +
                "\n Gracz =" + playerScore +
                "\n Komputer =" + computerScore);

        if (playerScore > computerScore){
            System.out.println("Wygrywa Gracz");
        } else if (playerScore < computerScore) {
            System.out.println("Wygrywa Komputer");
        } else {
            System.out.println("Remis");
        }
        System.out.println("*****************************");
    }

    public void setScore(Player player) {
        if (player.getName().equals("Komputer")) {
            computerScore++;
        } else {
            playerScore++;
        }
    }

    public void restartGame() {
        System.out.println("Czy chcesz rozpocząć nową grę? Wpisz T(tak)/N(nie)");
        String newGameChoice= SC.nextLine();
        if (newGameChoice.equals("T")) {
            setNumberOfRounds(startNewGame());
            setCurrentRounds(0);
            //printMenu();
        } else {
            System.out.println("Do zobaczenia!");
        }

    }

    public boolean isRoundLeft() {
        if (getCurrentRounds() == getNumberOfRounds()) {
            returnResult();
            return isGameEnded();
        }
        return false;
    }

    public boolean isGameEnded() {
        System.out.println("Czy chcesz zakończyć grę? Wpisz T(tak)/N(nie)");
        String endChoice= SC.nextLine();
        if (endChoice.equals("T")) {
            System.out.println("Do zobaczenia!");
            return true;
        } else {
            restartGame();
            return false;
        }
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getCurrentRounds() {
        return currentRounds;
    }

    public void setCurrentRounds(int currentRounds) {
        this.currentRounds = currentRounds;
    }

}
