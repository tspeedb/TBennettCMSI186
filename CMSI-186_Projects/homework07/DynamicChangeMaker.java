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
    private static int[] denoms = null;
    private static int value = 0;

    /**
     *  Constructor goes here
     */
    public static Tuple makeChangeWithDynamicProgramming(int[] denoms, int value) {
        //rows is num of denoms, cols is one plus target
        // for(int i: denoms){
        //     denomString
        // }
        // String args[] = Integer.toString(denoms + value);
        //
        // validateArgs(args);

        //validateArgs(denoms)
        try {
            if (value < 0){
                System.out.println("Cannot make change from a negative amount.");
                System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
                return Tuple.IMPOSSIBLE;

            }
            for (int i = 0; i < denoms.length; i++){
                if (denoms[i] <= 0){
                    System.out.println("Cannot make change from a negative amount.");
                    System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
                    return Tuple.IMPOSSIBLE;
                }
                for (int j = 0; j < i; j++){
                    if (denoms[j] == denoms[i]){
                        System.out.println("Duplicate denominations are present");
                        System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
                        return Tuple.IMPOSSIBLE;
                    }
                }
            }
        } catch(NumberFormatException nfe){
            System.out.println("Denominations must all be integers greater than or equal to one.");
            System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
            return Tuple.IMPOSSIBLE;

        }

        //VALIDATING ARGS PRIOR TO HERE


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

    public static void validateArgs(String args[]) throws NumberFormatException, IllegalArgumentException {
        // String denomString = "";
        try{
           if (args.length != 2){
               System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
               return;
           }
           int value = Integer.parseInt(args[0]);
           if (value < 0){
               System.out.println("Cannot make change from a negative amount.");
               System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
               return;
           }
           String denomString = args[1];
           int[] denoms = new int[denomString.length()];

           int a = 0;
           for(String index: denomString.split(",")){
               denoms[a] = Integer.parseInt(index);
               a++;
           }

           if (args[1].contains("0") == true){
               System.out.println("Cannot make change with no coin value");
               throw new IllegalArgumentException("Illegal coin value");

           }

           // String denomString = args[1].split(",");
           // // for (int i = 0; i < args[1].length(); i++){
           // //     denomString += Integer.toString(denoms[i]);
           // // }
           // int[] denoms = new int[denomString.length()];

// HANDLE CONCATINATION ARGS[1]

           // if(denomString.contains())

           for(int i = 0; i < denoms.length; i++){
               // denoms[i] = Integer.parseInt(denomString.substring(i, (i+1)));
               if (denoms[i] <= 0) {
                   System.out.println("Denominations cannot be less than or equal to zero");
                   System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
                   return;
               }
               for (int j = 0; j < i; j++){
                   if (denoms[j] == denoms[i]){
                       System.out.println("Duplicate denominations are present");
                       System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
                       return;
                   }
               }
            }
        } catch(NumberFormatException nfe){
            System.out.println("Denominations must all be integers greater than or equal to one.");
            System .out.println("Please enter a a comma-separated list with values you would like to make, followed by a total amount.");
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
