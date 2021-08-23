package rps;

import java.util.Random;

public class Round {

    private static Random random = new Random();

    public static void playRound(Move playerMove, Game game, Player player, Computer computer) {
        Move computerMove = randomMove();
        printRoundResult(playerMove.getName(), computerMove.getName());

        if (playerMove.getId() == computerMove.getId()) {
            System.out.println("Remis");
        } else if(playerMove.getId() == 1 && computerMove.getId() == 2) {
            roundWinner(game, computer);
        } else if(playerMove.getId() == 1 && computerMove.getId() == 3) {
            roundWinner(game, player);
        } else if(playerMove.getId() == 2 && computerMove.getId() == 1) {
            roundWinner(game, player);
        } else if(playerMove.getId() == 2 && computerMove.getId() == 3) {
            roundWinner(game, computer);
        } else if(playerMove.getId() == 3 && computerMove.getId() == 1) {
            roundWinner(game, computer);
        } else if(playerMove.getId() == 3 && computerMove.getId() == 2) {
            roundWinner(game, player);
        }
        game.setCurrentRounds(game.getCurrentRounds()+1);
    }

    private static void roundWinner(Game game, Player winner) {
        System.out.println("Rundę wygrywa " + winner.getName());
        game.setScore(winner);
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
