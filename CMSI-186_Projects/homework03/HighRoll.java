import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Scanner;

public class HighRoll {
    static DiceSet dieGame = null;
    static int highscore = 0;

    public static void main(String args[]){
        Scanner vReader = new Scanner(System.in);
        while('q' != vReader.nextLine().charAt(0)){
            System.out.println("Welcome to Dice Set!");
            System.out.println("Here are your options:");
            System.out.println("1. Roll all the dice");
            System.out.println("2. Roll a single die");
            System.out.println("3. Calculate the score for this set");
            System.out.println("4. Save this score as high score");
            System.out.println("5. Display the high score");
            System.out.println("6. Enter 'q' to quit the program\n");
            String inputLine = null;
            try {
                inputLine = vReader.nextLine();
                if( 0 == inputLine.length() ) {
                    System.out.println("enter some text!:");
                }
                else if (1 == Integer.parseInt(inputLine)){
                    dieGame.roll();
                }
                else if (2 == Integer.parseInt(inputLine)){
                    System.out.println("Which die would you like to roll?");
                    int dieIndex = Integer.parseInt(inputLine) - 1;
                    dieGame.rollIndividual(dieIndex);

                }
                else if (3 == Integer.parseInt(inputLine)){
                   System.out.println(dieGame.sum());
                   System.out.println(dieGame.toString());
                }
                else if (4 == Integer.parseInt(inputLine)){
                    System.out.println(dieGame.toString());
                }
                else if (5 == Integer.parseInt(inputLine)){
                    int highscore = dieGame.sum();
                    System.out.println("Your highscore is: " + highscore);

                }
                else if (6 == Integer.parseInt(inputLine)){
                    System.exit(0);
                }
            } catch (IOException ioe) {
                System.out.println("Caught IOException");
            }
        }
        System.out.println("Thanks for playing!");
    }
}
