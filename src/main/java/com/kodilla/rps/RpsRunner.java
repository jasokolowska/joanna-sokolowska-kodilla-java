package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

    private static Scanner SC = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

        boolean end = false;
        Computer computer = new Computer();
        Human player = createNewPlayer();
        System.out.println("Podaj liczbę rund: ");
        int numberOfRounds = SC.nextInt();
        SC.nextLine();
        Game game = new Game(numberOfRounds);

        while (!end) {
            printMenu();
            String choice = SC.nextLine();

            switch(choice) {
                case "1":
                    Move stone = new Move(1);
                    playRound(stone, game, player, computer);
                    end = isEndOfGame(game);
                    break;
                case "2":
                    Move paper = new Move(2);
                    playRound(paper, game, player, computer);
                    end = isEndOfGame(game);
                    break;
                case "3":
                    Move scissors = new Move(3);
                    playRound(scissors, game, player, computer);
                    end = isEndOfGame(game);
                    break;
                case "x":
                    end = isGameEnded();
                    break;
                case "n":
                    System.out.println("Czy chcesz rozpocząć nową grę? ");
                    String newGameChoice= SC.nextLine();
                    game.setComputerScore(0);
                    game.setPlayerScore(0);
                    break;
                default:
                    System.out.println("Wprowadzono niepoprawny znak, proszę wybrać opcję z listy.");
                    printMenu();
                    break;
            }
        }
    }

    private static boolean isEndOfGame(Game game) {
        if (game.getCurrentRounds() == game.getNumberOfRounds()) {
            System.out.println(game);
            game.returnResult();
            isGameEnded();
        }
        return false;
    }

    private static boolean isGameEnded() {
        System.out.println("Czy chcesz zakończyć grę? Wpisz T(tak)/N(nie)");
        String endChoice= SC.nextLine();
        if (endChoice.equals("T")) {
            return true;
        } else {
            return false;
        }
    }

    private static void printMenu() {
        System.out.println("Wybierz opcję: " +
                "\n1 - zagranie 'kamień'" +
                "\n2 - zagranie 'papier'" +
                "\n3 - zagranie 'nożyce'" +
                "\nx - zakończenie gry" +
                "\nn - nowa gra");
    }

    private static Human createNewPlayer() {
        System.out.println("Podaj imię: ");
        Human newPlayer = new Human(SC.nextLine());
        return newPlayer;
    }

    private static void playRound(Move playerMove, Game game, Player player, Computer computer) {
        Move computerMove = randomMove();
        printRoundResult(playerMove.getName(), computerMove.getName());

        if (playerMove.getId() == computerMove.getId()) {
            System.out.println("Remis");
        } else if(playerMove.getId() == 1 && computerMove.getId() == 2) {
            roundWinner(game, computer);
        } else if(playerMove.getId() == 1 && computerMove.getId() == 3) {
            roundWinner(game, player);
        } else if(playerMove.getId() == 2 && computerMove.getId() == 1) {
            roundWinner(game, computer);
        } else if(playerMove.getId() == 2 && computerMove.getId() == 3) {
            roundWinner(game, computer);
        } else if(playerMove.getId() == 3 && computerMove.getId() == 1) {
            roundWinner(game, player);
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
        Move randomMove = new Move(random.nextInt(2)+1);
        return randomMove;
    }
}

