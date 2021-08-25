package rps;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    private static Scanner SC = new Scanner(System.in);

    private int playerScore;
    private int computerScore;
    private int numberOfRounds;
    private int currentRounds;
    private Computer computer;
    private Human player;

    public Game() {
        this.computer = new Computer();
        this.player = new Human();
        this.numberOfRounds = startNewGame();
        this.playerScore = 0;
        this.computerScore = 0;

    }

    private int startNewGame() {
        System.out.println("Podaj liczbę rund: ");
        int numberOfRounds = SC.nextInt();
        SC.nextLine();
        return numberOfRounds;
    }

    public void playRound(Move playerMove) {
        Round round = new Round();
        Player winner = round.playRound(playerMove, player, computer);
        System.out.println("Rundę wygrywa " + winner.getName());
        setScore(winner);
        this.setCurrentRounds(this.getCurrentRounds() + 1);
    }

    public void returnResult() {
        System.out.println("*****************************");
        System.out.println("Liczba zdobytych punktów: " +
                "\n Gracz =" + playerScore +
                "\n Komputer =" + computerScore);

        if (playerScore > computerScore) {
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

    public boolean restartGame() {
        System.out.println("Czy chcesz rozpocząć nową grę? Wpisz T(tak)/N(nie)");
        String newGameChoice = SC.nextLine();
        if (newGameChoice.toUpperCase().equals("T")) {
            setNumberOfRounds(startNewGame());
            setCurrentRounds(0);
            return false;
        } else {
            System.out.println("Do zobaczenia!");
            return true;
        }
    }

    private boolean isRoundLeft() {
        if (getCurrentRounds() == getNumberOfRounds()) {
            return false;
        }
        return true;
    }

    public boolean isGameEnded() {
        if (isRoundLeft()) {
            return false;
        } else {
            returnResult();
            return restartGame();
        }
    }

    public boolean isGameEnded(String endChoice) {
        if (endChoice.toUpperCase().equals("T")) {
            System.out.println("Do zobaczenia!");
            return true;
        } else {
            return restartGame();
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
