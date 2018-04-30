//Tuple - Collection of integers or Integer arrays
//Tuple t1 = newTuple(b);
//int[] d = new int[b.length];

//[rows] [columns]
//Tuple[][] = new Tuple [denom][cols + 1]

//@param, @return, @see, @throws

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Class that determines smallest number of coins to create a given amount with a given denomination
 * @author    :  Tommy Bennett
 * Date       :  2017-04-22
 * Description:  This program provides a class that determines smallest number of coins to create a given amount with a given denomination.
 *               This class is intended to be used as part of homework 7, the coin changemaker, which is a "Dynamic Programming" algorithm.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:   Reason for change or modification
 *  -----  ----------  -------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  Tommy Bennett  Initial writing
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class DynamicChangeMaker {
    private int[] denoms = null;

    /**
     *  Constructor goes here
     */
    public static Tuple makeChangeWithDynamicProgramming(int[] denoms, int value) {
        //rows is num of denoms, cols is one plus target
        int totalDenoms = denoms.length;
        Tuple[][] chart = new Tuple[totalDenoms][value + 1];
        String denomString = "";
        for (int i = 0; i < denoms.length; i++){
            denomString += Integer.toString(denoms[i]);
        }
        // int[] denoms = new int[denomString.length()];

        for(int i = 0; i < totalDenoms; i++){
            chart[i][0] = new Tuple(totalDenoms);
        }

        for(int row = 0; row < chart.length; row++){
            for(int column = 1; column < chart[row].length; column++){
                int remainder = column - denoms[row];
                if(remainder >= 0){
                    chart[row][column] = new Tuple(totalDenoms);
                    chart[row][column].setElement(row, 1);
                    if(chart[row][remainder].isImpossible()){
                        chart[row][column] = Tuple.IMPOSSIBLE;
                    } else {
                        chart[row][column] = chart[row][column].add(chart[row][remainder]);
                    }
                } else {
                    chart[row][column] = Tuple.IMPOSSIBLE;
                }
                if (row != 0){
                    if(chart[row-1][column].isImpossible() && chart[row][column].isImpossible()){
                        chart[row][column] = Tuple.IMPOSSIBLE;
                    }
                    if((chart[row][column].isImpossible() && !chart[row-1][column].isImpossible())){
                        chart[row][column] = chart[row-1][column];
                    }
                    else if((!chart[row][column].isImpossible() && chart[row-1][column].isImpossible()) || (chart[row-1][column].total() > chart[row][column].total())){
                        chart[row][column] = chart[row][column];
                    }
                    else if(chart[row-1][column].equals(chart[row][column])){
                        chart[row][column] = chart[row][column];
                    } else {
                        chart[row][column] = chart[row-1][column];
                    }

                }
            }
        }
        return chart[totalDenoms - 1][value];

    }

    public static void validateArgs(String args[]) throws NumberFormatException {
        // String denomString = "";
        try{
           if (args.length != 2){
               System .out.println("Please enter a total amount you would like to make followed by a comma-separated list with values you would like to make of the total amount.");
               return;
           }
           int value = Integer.parseInt(args[0]);
           if (value < 0){
               System.out.println("Cannot make change from a negative amount.");
               System .out.println("Please enter a total amount you would like to make followed by a comma-separated list with values you would like to make of the total amount.");
               return;
           }
           String denomString = "";
           int[] denoms = new int[denomString.length()];
           for (int i = 0; i < denoms.length; i++){
               denomString += Integer.toString(denoms[i]);
           }
           // int[] denoms = new int[denomString.length()];

           for(int i = 0; i < args.length; i++){
               denoms[i] = Integer.parseInt(denomString.substring(i, (i+1)));
               if (denoms[i] <= 0) {
                   System.out.println("Denominations cannot be less than or equal to zero");
                   System .out.println("Please enter a total amount you would like to make followed by a comma-separated list with values you would like to make of the total amount.");

                   return;
               }
               for (int j = 0; j < i; j++){
                   if (denoms[j] == denoms[i]){
                       System.out.println("Duplicate denominations are present");
                       System .out.println("Please enter a total amount you would like to make followed by a comma-separated list with values you would like to make of the total amount.");
                       return;
                   }
               }
           }
        } catch(NumberFormatException nfe){
            System.out.println("Denominations must all be integers greater than or equal to one.");
            System .out.println("Please enter a total amount you would like to make followed by a comma-separated list with values you would like to make of the total amount.");
            return;
        }

    }
    //public static Tuple[][] = null;


    // cols = Integer.parseInt(args[1]) +1;
    // rows =
    //
    // Tuple[][] theTable = new Tuple[rows][cols];

    /**
     *  The main program starts here
     *  remember the constraints from the project description
     *  @see  http://bjohnson.lmu.build/cmsi186web/homework07.html
     *  be sure to make LOTS of tests!!
     *  remember you are trying to BREAK your code, not just prove it works!
     */
    public static void main(String [] args){
        validateArgs(args);


    }
}
