/**
 * Write a description of class prisonerDilemmaPlay here.
 *
 * @author Jordan Kelland
 * @version 9, 24/08/2021
 */

import java.util.Scanner; //Keyboard input.

public class prisonerDilemmaPlay
{
    // instance variables.
    private int roundPlayed = 0;
    private double roundPlaying = 0;
    private int roundCounter = 1;

    //this is used to hold players entered commands.
    final int MAXROUNDS = 20;
    String[] p1MoveInput = new String [MAXROUNDS];
    String[] p2MoveInput = new String [MAXROUNDS];

    //used to compare with player 1 & 2 commands.
    String coopVar = "cooperate"; 
    String defectVar = "defect";

    //this is the pointing system used to give players points.
    private int coopWin = 2; //cooperation win adds 2 points to player.
    private int coopLos = 0; //cooperation loss adds 0 points to player.
    private int defectWin = 3; //defect win adds 3 points to player.
    private int defectTie = 1; //defect tie adds 1 point to player.

    //these variables hold each player 1 & 2 total points from rounds played.
    private int p1Score = 0; //player 1 score
    private int p2Score = 0; //player 2 score

    String getCommand1(){ // initializes instance variables, player 1 command.
        Scanner inputboard = new Scanner(System.in);
        String userInput = "";
        boolean invalidInput = true;
        while(invalidInput){ //until command is valid the can player can re enter their command again.
            userInput = inputboard.nextLine();
            if (userInput.equals(coopVar) || userInput.equals(defectVar)) { 
                invalidInput = false; 
            } else {
                System.out.println("An error has occured, please re enter your command.");
            }
        }
        return userInput; //returns userInput so that it can be entered for the next round.
    }

    String getCommand2(){ // initializes instance variables, player 2 command strategy - tit for tat strategy.
        if(roundPlayed == 0) {
            return "cooperate"; //player 2 always chooses cooperate as their first move.
        } else {
            return p1MoveInput[roundPlayed - 1]; //player 2 copycats the move player 1 chose from the last round.
        }
    }

    public prisonerDilemmaPlay(){ //Constructor for objects of class ClassAS91896
        // initializes instance variables
        Scanner inputboard = new Scanner(System.in);

        String p1Name; //will hold player 1 entered name.
        String p2Name; //will hold player 2 given name.
        String p1CommandInput; //will hold player 1 entered command.
        String p2CommandInput; //will hold player 2 entered command.

        //Game start
        System.out.println("Prisoner's Dilemma Description:");
        System.out.println("You are a member of a criminal organisation & have commited many crimes.\nYou are arrested & imprisoned on one of the lesser crimes you commited along with another member of your criminal organisation.\nThe prosecutor of the criminal case can convict you on your lesser crime,\n but lacks sufficient evidence to convict either of you on one of your more serious crimes.\nBecause of the prosecuter having a lack in sufficient evidence he simultaneousily offers both of you a deal.\nBoth you & the other prisoner have the opportunity to either betray the other by testifying to the crime comitted by the other prisoner,\n or to cooperate with the other prisoner & remain sileant.\n");
        System.out.println("Prisoner's Dilemma Rules:");
        System.out.println("There are between 5 & 20 rounds per game. The player with the highest score wins.\nIn this game you must either “cooperate” or “defect” the possible outcomes are:\nPlayer 1 & 2 both defect against each other. Results in 1 point for player 1 & 2.\nPlayer 1 & 2 both cooperate with each other. Results in 2 points for player 1 & 2.\nPlayer 1 defects but player 2 cooperates. Results in 3 points for player 1 & 0 points for player 2.\nPlayer 1 cooperates but player 2 defects. Results in 0 points for player 1 & 3 points for player 2.\n");

        System.out.println("Player one please enter your name:"); //player one enters their name.
        p1Name = inputboard.nextLine(); //assigns entered name to player 1.
        p2Name = "Computer"; //assigns player 2 name.

        roundPlaying = 5 + (Math.random()*20); //will make round count random between 5 & 20.

        while (roundPlaying > roundPlayed) { //round engine.
            System.out.println("\nround " + roundCounter);
            System.out.println(p1Name + " enter your move; cooperate or defect");
            p1CommandInput = getCommand1(); //player1 valid command input.
            p2CommandInput = getCommand2(); //player2 valid command input.

            p1MoveInput[roundPlayed] = p1CommandInput; //remembers player 1 command from previous turns.
            p2MoveInput[roundPlayed] = p2CommandInput; //remembers player 2 command from previous turns.

            //prints out out chosen player moves for current round.
            System.out.println(p1Name + " your move was " + p1CommandInput);
            System.out.println(p2Name + " your move was " + p2CommandInput);

            //this if statement compares both of the players commands with possibly chosen commands to determine an the round outcome.
            if (p1CommandInput.equals(coopVar) && p2CommandInput.equals(coopVar)) { //this outcome results in player 1 & 2 cooperation win.
                p1Score = p1Score + coopWin; //adds the point value of a cooperation win to player 1.
                p2Score = p2Score + coopWin; //adds the point value of a cooperation win to player 2.
                System.out.println(p1Name + " outcome is Cooperation Win.");
                System.out.println(p2Name + " outcome is Cooperation Win.");
            } else if (p1CommandInput.equals(coopVar) && !p2CommandInput.equals(coopVar)) { //this outcome results in player 1 cooperation loss & player 2 defect win.
                p1Score = p1Score + coopLos; //adds the point value of a cooperation loss to player 1.
                p2Score = p2Score + defectWin; //adds the point value of a defect win to player 2.
                System.out.println(p1Name + " outcome is Cooperation Lose.");
                System.out.println(p2Name + " outcome is Defect Win.");
            } else if (p1CommandInput.equals(defectVar) && p2CommandInput.equals(defectVar)) { //this outcome results in player 1 & 2 defect tie.
                p1Score = p1Score + defectTie; //adds the point value of a defect tie to player 1.
                p2Score = p2Score + defectTie; //adds the point value of a defect tie to player 2.
                System.out.println(p1Name + " outcome is Defect Tie.");
                System.out.println(p2Name + " outcome is Defect Tie.");
            } else if (p1CommandInput.equals(defectVar) && !p2CommandInput.equals(defectVar)) { //this outcome results in player 1 defect win & player 2 cooperation loss.
                p1Score = p1Score + defectWin; //adds the point value of a defect win to player 1.
                p2Score = p2Score + coopLos; //adds the point value of a cooperation loss to player 2.
                System.out.println(p1Name + " outcome is Defect Win.");
                System.out.println(p2Name + " outcome is Cooperation Lose.");
            }

            roundPlayed = roundPlayed + 1; //this updates the rounds played by 1 for each round played.
            roundCounter = roundCounter + 1; //this updates the round count by 1 for each round played.
        } //end of round engine
        
        System.out.println("\nGame Results"); //game results
        
        if(p1Score == p2Score) { //this prints out the player positions of the played game, along with their total score.
            System.out.println("Both players tied");
            System.out.println(p1Name + " score is " + p1Score);
            System.out.println(p2Name + " score is " + p2Score);
        } else if (p1Score > p2Score) {
            System.out.println(p1Name + " is the winner with " + p1Score);
            System.out.println(p2Name + " score is " + p2Score);
        } else {
            System.out.println(p2Name + " is the winner with " + p2Score);
            System.out.println(p1Name + " score is " + p1Score);
        } 

        System.out.println("\nGame Over"); //the end of the program
    }
}