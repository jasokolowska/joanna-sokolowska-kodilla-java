package rps;

import java.util.Scanner;

public class RpsRunner {

    private static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        boolean end = false;

        Computer computer = new Computer();
        Human player = new Human();
        Game game = new Game();

        while (!end) {
            printMenu();
            String choice = SC.nextLine();

            switch(choice) {
                case "1":
                    Move stone = new Move(1);
                    Round.playRound(stone, game, player, computer);
                    end = game.isGameEnded();
                    break;
                case "2":
                    Move paper = new Move(2);
                    Round.playRound(paper, game, player, computer);
                    end = game.isGameEnded();
                    break;
                case "3":
                    Move scissors = new Move(3);
                    Round.playRound(scissors, game, player, computer);
                    end = game.isGameEnded();
                    break;
                case "x":
                    System.out.println("Czy chcesz zakończyć grę? Wpisz T(tak)/N(nie)");
                    String endChoice= SC.nextLine();
                    end = game.isGameEnded(endChoice);
                    break;
                case "n":
                    end = game.restartGame();
                    break;
                default:
                    System.out.println("Wprowadzono niepoprawny znak, proszę wybrać opcję z listy.");
                    break;
            }
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
}

