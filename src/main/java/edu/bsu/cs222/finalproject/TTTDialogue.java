package edu.bsu.cs222.finalproject;

import java.util.ArrayList;


public class TTTDialogue {

    public static void Instructions(){
        System.out.println("""
                  It's your turn!
                  
                              1 | 2 | 3
                             ------------
                              4 | 5 | 6
                             ------------
                              7 | 8 | 9
                  Type the number of your chosen space.
                """);

        //TTTGameBoard.showGameBoard(gameBoard);
    }

    public static void showGameBoard(ArrayList<String> board){
        System.out.println("              " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) +
                "\n             ------------\n" +
                "              " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) +
                "\n             ------------\n" +
                "              " + board.get(6) + " | " + board.get(7) + " | " + board.get(8));
    }

    public static void compTurn(){
        System.out.println("It's the Computer's turn!");
    }

    public static void improperSpace() {
        System.err.println("That space is not empty");
    }

    public static void invalidUserInput(){
        System.err.println("Invalid input (enter a number 1-9).");
    }

    public static void userWinDialogue() {
        System.out.println("You win!");
        System.exit(0);
    }

    public static void compWinDialogue() {
        System.out.println("Sorry, you lose!");
        System.exit(0);
    }

    public static void letterChoiceDialogue() {
        System.out.println("Do you want to play as Xs or Os?");
    }

    public static void invalidLetterChoice() {System.err.println("Invalid input. Do you want to play as Xs or Os?");
    }

    public static void drawOutcomeDialogue() {
        System.out.println("The game ends in a draw.");
        System.exit(0);
    }
}
