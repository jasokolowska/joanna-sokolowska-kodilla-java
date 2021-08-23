package com.kodilla.rps;

public class Game {
    private int playerScore;
    private int computerScore;
    private int numberOfRounds;
    private int currentRounds;

    public Game(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        this.playerScore = 0;
        this.computerScore = 0;
    }

    public void returnResult() {
        if (playerScore > computerScore){
            System.out.println("Wygrywa Gracz");
        } else if (playerScore < computerScore) {
            System.out.println("Wygrywa Komputer");
        } else {
            System.out.println("Remis");
        }
    }

    public void setScore(Player player) {
        if (player.getName().equals("Komputer")) {
            computerScore++;
        } else {
            playerScore++;
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

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    @Override
    public String toString() {
        return "Liczba zdobytych punktów: " +
                "Gracz =" + playerScore +
                "\n Komputer =" + computerScore;
    }
}
