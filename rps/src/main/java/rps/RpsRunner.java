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
                    end = game.isRoundLeft();
                    break;
                case "2":
                    Move paper = new Move(2);
                    Round.playRound(paper, game, player, computer);
                    end = game.isRoundLeft();
                    break;
                case "3":
                    Move scissors = new Move(3);
                    Round.playRound(scissors, game, player, computer);
                    end = game.isRoundLeft();
                    break;
                case "x":
                    end = game.isGameEnded();
                    break;
                case "n":
                    game.restartGame();
                    break;
                default:
                    System.out.println("Wprowadzono niepoprawny znak, proszę wybrać opcję z listy.");
                    printMenu();
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

