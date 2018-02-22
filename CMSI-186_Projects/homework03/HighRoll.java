import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Scanner;

public class HighRoll {
    static DiceSet dieGame = null;
    public static int highscore = 0;

    public static void main( String args[] ){
        Scanner vReader = new Scanner(System.in);
        //String inputText = "";
        System.out.println("Start by entering # of dice");
        String diceInput = vReader.nextLine();
        System.out.println("Now enter # of sides");
        String sidesInput = vReader.nextLine();
        dieGame = new DiceSet(Integer.parseInt(diceInput), Integer.parseInt(sidesInput));
        while(true){
            System.out.println("Welcome to Dice Set!");
            System.out.println("Here are your options:");
            System.out.println("1. Roll all the dice");
            System.out.println("2. Roll a single die");
            System.out.println("3. Calculate the score for this set");
            System.out.println("4. Save this score as high score");
            System.out.println("5. Display the high score");
            System.out.println("6. Enter 'q' to quit the program\n");
            String inputLine = null;
            BufferedReader input = new BufferedReader( new InputStreamReader (System.in));
            try{
                inputLine = input.readLine();
                if( 0 == inputLine.length() ) {
                    System.out.println("enter some text!:");
                }
                else if ('1' == inputLine.charAt(0)){
                    dieGame.roll();
                    System.out.println("All Dice Rolled");
                }
                else if ('2' == inputLine.charAt(0)){
                    System.out.println("Which die would you like to roll?");
                    inputLine = input.readLine();
                    System.out.println(dieGame.rollIndividual(Integer.parseInt(inputLine)-1));
                    System.out.println("Die number " + inputLine + " rolled");

                }
                else if ('3' == inputLine.charAt(0)){
                   System.out.println(dieGame.sum());
                   System.out.println(dieGame.toString());
                }
                else if ('4' == inputLine.charAt(0)){
                    highscore = dieGame.sum();
                    System.out.println(dieGame.toString());
                }
                else if ('5' == inputLine.charAt(0)){
                    System.out.println("Your highscore is: " + highscore);

                }
                else if ('6' == inputLine.charAt(0)){
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                }
                else if ('q' == inputLine.charAt(0)){
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                }
            } catch (IOException ioe) {
                System.out.println("Caught IOException");
            }
        }
    }
}
