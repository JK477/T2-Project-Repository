/**
 * Write a description of class ClassAS91896 here.
 *
 * @author Jordan kelland
 * @version 5, 25/06/21
 */

import java.util.Scanner; //Keyboard input.

public class ClassAS91896
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int roundToPlay;
    private int roundsPlayed;
    private int coopWin = 2;
    private int coopLos = 0;
    private int defectWin = 3;
    private int defectTie = 1;
    private int play1Score;
    private int play2Score;

    //Constructor for objects of class ClassAS91896
    public ClassAS91896()
    {
        // initialise instance variables
        Scanner inputboard = new Scanner(System.in);

        String play1Name; //will hold player one entered name
        String play2Name; //will hold player two entered name
        
        boolean playingGame = true;

        String p1CommandInput; //will hold player one entered command
        String p2CommandInput; //will hold player two entered command
        String coopVar = "cooperate"; //used to compare entered commands
        String defectVar = "defect"; //used to compare entered commands 
        
        System.out.println("Prisoner's Dilemma description");
        System.out.println("Prisoner's Dilemma Rules");
        
        System.out.println("Player one please enter your name"); //player one enters their name
        play1Name = inputboard.nextLine(); //assigns entered name to String p1Name 
        play2Name = "Computer"; //player 2 name

        roundToPlay = 5; //will make random

        while (playingGame) {

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
                System.out.println("An Error has occured");
                //System.out.println(play1Name+" re enter your move; Cooperate or Defect");
                //p1CommandInput = inputboard.nextLine();
                //System.out.println(play1Name+" your move was "+p1CommandInput);
                //System.out.println(play2Name+" your move was "+p2CommandInput);
            }
        }
            
        System.out.println(play1Name+" your score is "+play1Score);
        System.out.println(play2Name+" your score is "+play2Score);
        
        //boolean play1Win = false;
        //boolean play2Win = false;
        //boolean play1Los = false;
        //boolean play2Los = false;
        //System.out.println(play1Win);
        //System.out.println(play2Win);
        //System.out.println(play1Los);
        //System.out.println(play2Los);
        
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

