package TicTacToe;

import java.util.ArrayList;

public class TTTPlay {
    public static void TTTRun(){
        ArrayList<String> Board =TTTGameBoard.gameBoard();
        TTTDialogue.Instructions();
        boolean openSpace;
        do {
            int play = TTTTurnMove.getUserPlay();
            openSpace = TTTGameBoard.emptySpaceCheck(Board, play);
            if (!openSpace) {
                TTTDialogue.inproperSpace();
            }
        }while (!openSpace);
    }
}
