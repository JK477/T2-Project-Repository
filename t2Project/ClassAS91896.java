/**
 * Write a description of class ClassAS91896 here.
 *
 * @author Jordan kelland
 * @version 6, 30/06/21 - 08/07/21
 */

import java.util.Scanner; //Keyboard input.

public class ClassAS91896
{
    // instance variables
    private int x;
    private int y;
    
    private double roundsToPlay = 0;
    private int roundsPlayed = 0;
    private int coopWin = 2;
    private int coopLos = 0;
    private int defectWin = 3;
    private int defectTie = 1;
    private int play1Score = 0;
    private int play2Score = 0;

    public ClassAS91896() //Constructor for objects of class ClassAS91896
    {
        // initializes instance variables
        Scanner inputboard = new Scanner(System.in);

        String play1Name; //will hold player one entered name
        String play2Name; //will hold player two name

        String p1CommandInput; //will hold player one entered command
        String p2CommandInput; //will hold player two entered command
        String coopVar = "cooperate"; //used to compare entered commands
        String defectVar = "defect"; //used to compare entered commands 
        
        //Game start
        System.out.println("Prisoner's Dilemma description");
        System.out.println("Prisoner's Dilemma Rules");
        
        System.out.println("Player one please enter your name"); //player one enters their name
        play1Name = inputboard.nextLine(); //assigns entered name to String p1Name 
        play2Name = "Computer"; //player 2 name

        double roundsToPlay = 5 + (Math.random()*20); //will make random

        System.out.print(roundsToPlay); //to test the random fuction
        
        while (roundsPlayed < roundsToPlay) {

            System.out.println(play1Name+" enter your move; Cooperate or Defect");
            p1CommandInput = inputboard.nextLine(); //player1 command input
            p2CommandInput = "defect"; //player2 command input

            //prints out out chosen player moves for current round
            System.out.println(play1Name+" your move was "+p1CommandInput);
            System.out.println(play2Name+" your move was "+p2CommandInput);

            if (p1CommandInput.equals(coopVar) && p2CommandInput.equals(coopVar)) {
                play1Score = play1Score + coopWin;
                play2Score = play2Score + coopWin;
                System.out.println(play1Name+"'s outcome is Cooperation Win");
                System.out.println(play2Name+"'s outcome is Cooperation Win");
            }else if (p1CommandInput.equals(coopVar) && !p2CommandInput.equals(coopVar)) {
                play1Score = play1Score + coopLos;
                play2Score = play2Score + defectWin;
                System.out.println(play1Name+"'s outcome is Cooperation Lose");
                System.out.println(play2Name+"'s outcome is Defect Win");
            } else if (p1CommandInput.equals(defectVar) && p2CommandInput.equals(defectVar)) {
                play1Score = play1Score + defectTie;
                play2Score = play2Score + defectTie;
                System.out.println(play1Name+"'s outcome is Defect Tie");
                System.out.println(play2Name+"'s outcome is Defect Tie");
            } else if (p1CommandInput.equals(defectVar) && !p2CommandInput.equals(defectVar)) {
                play1Score = play1Score + defectWin;
                play2Score = play2Score + coopLos;
                System.out.println(play1Name+"'s outcome is Defect Win");
                System.out.println(play2Name+"'s outcome is Cooperation Lose");
            } else {
                System.out.println("An Error has occured"); //need to work on this section
                //System.out.println(play1Name+" re enter your move; Cooperate or Defect");
                //p1CommandInput = inputboard.nextLine();
                //System.out.println(play1Name+" your move was "+p1CommandInput);
                //System.out.println(play2Name+" your move was "+p2CommandInput);
            }
            
            roundsPlayed = roundsPlayed + 1;
            
            //should also hold each players score for each round in array, will add at end 
            
        } //this is the end of the loop
            
        System.out.println(play1Name+" your score is "+play1Score);
        System.out.println(play2Name+" your score is "+play2Score);
        

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}

