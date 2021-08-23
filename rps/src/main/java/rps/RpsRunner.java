package rps;

import java.util.Scanner;

public class RpsRunner {

    private static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        boolean end = false;

        Computer computer = new Computer();
        Human player = createNewPlayer();
        Game game = new Game(startNewGame());

        while (!end) {
            printMenu();
            String choice = SC.nextLine();

            switch(choice) {
                case "1":
                    Move stone = new Move(1);
                    Round.playRound(stone, game, player, computer);
                    end = isRoundLeft(game);
                    break;
                case "2":
                    Move paper = new Move(2);
                    Round.playRound(paper, game, player, computer);
                    end = isRoundLeft(game);
                    break;
                case "3":
                    Move scissors = new Move(3);
                    Round.playRound(scissors, game, player, computer);
                    end = isRoundLeft(game);
                    break;
                case "x":
                    end = isGameEnded();
                    break;
                case "n":
                    restartGame();
                    break;
                default:
                    System.out.println("Wprowadzono niepoprawny znak, proszę wybrać opcję z listy.");
                    printMenu();
                    break;
            }
        }
    }

    private static int startNewGame() {
        System.out.println("Podaj liczbę rund: ");
        int numberOfRounds = SC.nextInt();
        SC.nextLine();

        return numberOfRounds;
    }

    private static void restartGame() {
        System.out.println("Czy chcesz rozpocząć nową grę? Wpisz T(tak)/N(nie)");
        String newGameChoice= SC.nextLine();
        if (newGameChoice.equals("T")) {
            startNewGame();
            printMenu();
        } else {
            System.out.println("Do zobaczenia!");
        }

    }

    private static boolean isRoundLeft(Game game) {
        if (game.getCurrentRounds() == game.getNumberOfRounds()) {
            game.returnResult();
            isGameEnded();
        }
        return false;
    }

    private static boolean isGameEnded() {
        System.out.println("Czy chcesz zakończyć grę? Wpisz T(tak)/N(nie)");
        String endChoice= SC.nextLine();
        if (endChoice.equals("T")) {
            System.out.println("Do zobaczenia!");
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
}

