package rps;

import java.util.Random;

public class Round {

    private static Random random = new Random();

    public Player playRound(Move playerMove, Player human, Player computer) {
        Move computerMove = randomMove();
        printRoundResult(playerMove.getName(), computerMove.getName());

        if (playerMove.getId() == computerMove.getId()) {
            System.out.println("Remis");
        } else if(playerMove.getId() == 1 && computerMove.getId() == 2) {
            return computer;
        } else if(playerMove.getId() == 1 && computerMove.getId() == 3) {
            return human;
        } else if(playerMove.getId() == 2 && computerMove.getId() == 1) {
            return human;
        } else if(playerMove.getId() == 2 && computerMove.getId() == 3) {
            return computer;
        } else if(playerMove.getId() == 3 && computerMove.getId() == 1) {
            return computer;
        } else if(playerMove.getId() == 3 && computerMove.getId() == 2) {
            return human;
        }
        return null;
    }


    private static void printRoundResult(String playerMove, String computerMove) {
        System.out.println("Ruch gracza: " + "'" + playerMove + "'" +
                "\nRuch komputera: " + "'" + computerMove + "'");
    }

    private static Move randomMove() {
        Move randomMove = new Move(random.nextInt(3)+1);
        return randomMove;
    }
}
