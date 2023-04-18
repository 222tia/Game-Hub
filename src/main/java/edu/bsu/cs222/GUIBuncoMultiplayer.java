package edu.bsu.cs222;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GUIBuncoMultiplayer implements Initializable {

    static List<Integer> diceRollList = new ArrayList<>();
    public TextArea buncoRuleArea;
    public TextArea buncoTextArea;
    public TextArea buncoScoreArea;
    public int playerScore = 0;
    public int player2Score = 0;
    public int roundNumber = 1;
    public int turnOrder = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buncoRuleArea.setText(BuncoDialogue.GUIBuncoRules());

    }

    @FXML
    public void onBuncoDiceClick() {


        if((playerScore<21)&&(player2Score<21)) {
            buncoScoreArea.setText(BuncoDialogue.ScoreDisplay(playerScore, player2Score));
            if (turnOrder == 1) {
                buncoTextArea.setText(BuncoDialogue.Player1TurnDisplay());
            } else {
                buncoTextArea.setText(BuncoDialogue.Player2TurnDisplay());
            }
            boolean turnContinue;
            buncoTextArea.appendText(BuncoDialogue.RoundDisplay(roundNumber));

            diceRollList = BuncoDice.getDiceRolls();

            int dice1Value = diceRollList.get(0);
            int dice2Value = diceRollList.get(1);
            int dice3Value = diceRollList.get(2);
            buncoTextArea.appendText(BuncoDialogue.DiceOutput(dice1Value, dice2Value, dice3Value));

            boolean pointGain = ((dice1Value == roundNumber) || (dice2Value == roundNumber) || (dice3Value == roundNumber));
            boolean DiceTriples = (dice1Value == dice2Value) && (dice2Value == dice3Value);
            if (turnOrder == 1) {
                playerScore = BuncoDice.Scoring(playerScore, roundNumber, diceRollList);
            } else {
                player2Score = BuncoDice.Scoring(player2Score, roundNumber, diceRollList);
            }

            turnContinue = pointGain || DiceTriples;

            buncoScoreArea.setText(BuncoDialogue.playerScoreDisplays(playerScore, player2Score));
            diceRollList.clear();

            if (playerScore >= 21) {
                buncoTextArea.appendText(BuncoDialogue.Player1WinDisplay());
            }
            if (player2Score >= 21) {
                buncoTextArea.appendText(BuncoDialogue.Player2WinDisplay());
            }

            if ((turnContinue) && (turnOrder == 1) && (playerScore < 21)) {
                buncoTextArea.appendText(BuncoDialogue.Player1ContinueDisplay());
            }
            if ((turnContinue) && (turnOrder == 2) && (player2Score < 21)) {
                buncoTextArea.appendText(BuncoDialogue.Player2ContinueDisplay());
            }
            if(!turnContinue) {
                if (turnOrder == 1) {
                    turnOrder = 2;
                } else {
                    turnOrder = 1;
                    roundNumber++;
                    if (roundNumber > 6) {
                        roundNumber = 1;
                    }
                }
            }
        }
        else{
            buncoTextArea.appendText(BuncoDialogue.RestartDisplay());
        }
    }

}
