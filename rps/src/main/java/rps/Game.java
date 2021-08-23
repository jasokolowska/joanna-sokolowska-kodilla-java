package rps;

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
        System.out.println("*****************************");
        System.out.println("Liczba zdobytych punktów: " +
                "\n Gracz =" + playerScore +
                "\n Komputer =" + computerScore);
        System.out.println("*****************************");
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

}
