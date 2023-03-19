package edu.bsu.cs222.finalproject;

import java.util.Scanner;

public class PlayDesktopArcade {
    public static void main(String[] args){
        Scanner userChoice = new Scanner(System.in);

        DesktopArcadeDialogue.startUpDialogue();

        if (userChoice.nextLine().equals("1")){
            DesktopArcadeDialogue.RPSRules();
        }if (userChoice.nextLine().equals("2")){
            DesktopArcadeDialogue.BuncoRules();
        }else{
            DesktopArcadeDialogue.incorrectInput();
        }
    }
}
