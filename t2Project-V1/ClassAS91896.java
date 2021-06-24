/**
 * Write a description of class ClassAS91896 here.
 *
 * @author Jordan kelland
 * @version 1, 17/06/21 - 24/06/21
 */

import java.util.Scanner; //Keyboard input.

public class ClassAS91896
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int roundNumber = 0;
    private int play1Score = 0;
    private int play2Score = 0;
    
    //Constructor for objects of class ClassAS91896
    public ClassAS91896()
    {
        // initialise instance variables
        Scanner inputboard = new Scanner(System.in);
        
        //Points system
        int coopWin = 2; //the player will receive 2 points if the outcome is a coop win
        int coopLos = 0; //the player will receive 0 points if the outcome is a coop lose
        int defectWin = 3; //the player will receive 3 points if the outcome is a defect win
        int defectTie = 1; //the player will receive 1 points if the outcome is a defect tie
        
        //will hold players entered names
        String p1Name;
        String p2Name;
        
        //round number string
        String roundCont;
        
        //will hold input from players
        String p1CommandInput;
        String p2CommandInput;
        
        //Comparable variables
        String coopVar = "cooperate";
        String defectVar = "defect";
        
        //Prisoners Dilemma description & rules
        System.out.println("Prisoner's Dilemma description");
        System.out.println("Prisoner's Dilemma Rules");
        
        //players enter there names
        System.out.println("Player one please enter your name");
        p1Name = inputboard.nextLine();
        System.out.println("Player two please enter your name");
        p2Name = inputboard.nextLine();
        
        System.out.println("Enter number of rounds");
        roundCont = inputboard.nextLine();
        
        //player1 command input
        System.out.println(p1Name+" enter your move; Cooperate or Defect");
        p1CommandInput = inputboard.nextLine();
        //player2 command input
        System.out.println(p2Name+" enter your move; Cooperate or Defect");
        p2CommandInput = inputboard.nextLine();
        //prints out out chosen player moves for current round
        System.out.println(p1Name+" your move was "+p1CommandInput);
        System.out.println(p2Name+" your move was "+p2CommandInput);
        
        //checks if players chose to cooperate
        if (p1CommandInput.equals(coopVar) && p2CommandInput.equals(coopVar) ) {
            play1Score = play1Score + coopWin;
            play2Score = play2Score + coopWin;
            System.out.println(p1Name+"'s outcome is Cooperation Win");
            System.out.println(p2Name+"'s outcome is Cooperation Win");
        } else if (!p1CommandInput.equals(coopVar) && p2CommandInput.equals(coopVar) ) {
            play1Score = play1Score + defectWin;
            play2Score = play2Score + coopLos;
            System.out.println(p1Name+"'s outcome is Defect Win");
            System.out.println(p2Name+"'s outcome is Cooperation Lose");
        } else if (p1CommandInput.equals(coopVar) && !p2CommandInput.equals(coopVar) ) {
            play1Score = play1Score + coopLos;
            play2Score = play2Score + defectWin;
            System.out.println(p1Name+"'s outcome is Cooperation Lose");
            System.out.println(p2Name+"'s outcome is Defect Win");
        } else if (p1CommandInput.equals(defectVar) && p2CommandInput.equals(defectVar) ) {
            play1Score = play1Score + defectTie;
            play2Score = play2Score + defectTie;
            System.out.println(p1Name+"'s outcome is Defect Tie");
            System.out.println(p2Name+"'s outcome is Defect Tie");
        } else if (!p1CommandInput.equals(defectVar) && p2CommandInput.equals(defectVar) ) {
            play1Score = play1Score + coopLos;
            play2Score = play2Score + defectWin;
            System.out.println(p1Name+"'s outcome is Cooperation Lose");
            System.out.println(p2Name+"'s outcome is Defect Win");
        } else if (p1CommandInput.equals(defectVar) && !p2CommandInput.equals(defectVar) ) {
            play1Score = play1Score + defectWin;
            play2Score = play2Score + coopLos;
            System.out.println(p1Name+"'s outcome is Defect Win");
            System.out.println(p2Name+"'s outcome is Cooperation Lose");
        } 
        
        //else {
            //System.out.println("An Error has occured");
            //System.out.println(p1Name+" re enter your move; Cooperate or Defect");
            //p1CommandInput = inputboard.nextLine();
            //System.out.println(p2Name+" re enter your move; Cooperate or Defect");
            //p2CommandInput = inputboard.nextLine();
            //System.out.println(p1Name+" your move was "+p1CommandInput);
            //System.out.println(p2Name+" your move was "+p2CommandInput);
        //}
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


