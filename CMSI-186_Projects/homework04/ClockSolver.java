/*
Author: Tommy Bennett
Title: ClockSolver.java
Date: 3/13/2018
Purpose: Prove clock works
*/

import java.text.DecimalFormat;

public class ClockSolver{
    public static void main(String[]args){

        System.out.println("Welcome to your clock");
        String angleString = args[0];
        String timeString = args[1];
        Clock c = new Clock(args);

        System.out.println("Searching for angle: " + c.getTargetAngle());
        System.out.println("Searching for time slice: " + c.getTimeSlice());

        //String args[] = new String[angleString, timeString];

        //Validate args
        c.validateAngleArg(args[0]);
        c.validateTimeSliceArg(Double.toString(c.getTimeSlice()));

        //loop
        while (c.getTotalSeconds() < 43200){
            c.tick();

            if (c.getTargetAngle() < (c.getHandAngle() + .1) && c.getTargetAngle() > (c.getHandAngle() - .1)){
                System.out.println("Found angle of: " + c.getTargetAngle() + " at " + c.toString());
            }
        }


    }
}

//Validate args : call clock.validateangle AND call clock.validatetimeclice
//Then set the valid values in clock solver
//then create Clock
//then loop
//then call clock.tick
//then c.gethandhangle
//if(target == handangle){
//TOSTRING
//}
