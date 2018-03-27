/*
Author: Tommy Bennett
Title: SoccerSim.java
Date: 3/28/2018
Purpose: Simulate Soccer Ball Movement and predict collisions
*/

//Simulation ends when two things hit one another. Can include static pole
//Change ball radius to feet
//MAKE ALL VARIABLES SAME degree (all feet, or meters or sec)
//DOnt check to see if xs and ys are equal, use pythagorean and check that distance is less than radius
//IF Its radius you need to double mf!!!
//location should be on Ball
//while(collision not occured)











/*
Author: Tommy Bennett
Title: SoccerSim.java
Date: 3/28/2018
Purpose: Simulate Soccer Ball Movement and predict collisions
*/

//distance method that determines

//Simulation ends when two things hit one another. Can include static pole
//Change ball radius to feet
//MAKE ALL VARIABLES SAME degree (all feet, or meters or sec)
//DOnt check to see if xs and ys are equal, use pythagorean and check that distance is less than radius
//IF Its radius you need to double mf!!!
//location should be on Ball
//while(collision not occured)

//

//call super

// (i = 0; i< args.length%4; i+=4){
//Ball(args[i] args[i+1] args[i+2] args[i+3])
//timeslice = args.length

//MAth.max is <= 1.0 ball is at  rest
/*
public double tick(){
    this.ballVelocityX = this.xRate (FRICTION_PERCENTAGE * timeSlice);
    this.ballVelocityY = this.xRate (FRICTION_PERCENTAGE * timeSlice);
}

BALL IS CONSIDERED AT REST WHEN MOVING LESS THAN 1 IN PER SECOND

*/

import java.text.DecimalFormat;


public class SoccerSim {


    public static void main(String[] args){

        System.out.println("WELCOME TO SOCCER SIMMULATOR!\n\n");

        Ball[] balls = null;
        balls = new Ball[(int) (Math.floor(args.length/4))];

try {
        if(0 == args.length){
            System.out.println("No args entered\nTry: java SoccerSim <X Location> <Y Location> <X Velocity> <Y Velocity> <Time Slice> ");
            System.exit(1);
        }

        if (args.length % 4 == 1) {
            int j = 0;
            for (int i = 0; i < args.length-1; i+=4){
                Double xpos = Double.parseDouble(args[i+0]);
                Double ypos = Double.parseDouble(args[i+1]);
                Double xvel = Double.parseDouble(args[i+2]);
                Double yvel = Double.parseDouble(args[i+3]);
                Double time = Double.parseDouble(args[args.length-1]);
                balls[j] = new Ball(xpos, ypos, xvel, yvel, time);

                j++;

            }
        } else if (args.length % 4 == 0) {
            int j = 0;
            for (int i = 0; i <= args.length; i+=4){
                Double xpos = Double.parseDouble(args[i+0]);
                Double ypos = Double.parseDouble(args[i+1]);
                Double xvel = Double.parseDouble(args[i+2]);
                Double yvel = Double.parseDouble(args[i+3]);
                Double time = 1.0;
                balls[j] = new Ball(xpos, ypos, xvel, yvel, time);

                j++;

            }
        }else {
            System.out.println(args.length);
            throw new IllegalArgumentException("Invalid number of arguments. Please try again!");
        }
} catch (NumberFormatException nfe){
    System.out.println(nfe);

}
        //if args.length ==1, you have time timeSlice
        //if args.length == 0, you need to set default timeSlice (1 second)
        //else try again throw illegelargs Exception

        //math.floor args.length = number of balls
        //



        //Random ball placed at
        System.out.println("INITIAL at: "  /*Insert Timer*/);
        for (int i = 0; i < balls.length; i++){
            System.out.println(i+":\t"+balls[i].toString());

        }
        System.out.println("Pole is located at: (20, 20)");




        while(true){
            boolean onField = true;
            for (int i = 0; i < balls.length - 1; i++){
                if (balls[i].onField() == true) {
                    onField = true;
                } else {
                    onField = false;
                    break;
                }
                break;
            }

            boolean isMoving = true;
            for (int i = 0; i < balls.length - 1; i++){
                if (balls[i].isMoving() == true) {
                    isMoving = true;
                } else {
                    isMoving = false;
                    break;
                }
                break;
            }

            Timer t = new Timer(Integer.parseInt(args[args.length-1]));
            System.out.println("RECURRING at: " + t.toString());
            for (int i = 0; i < balls.length; i++){
                System.out.println(i+":\t"+balls[i].toString());

            }
        }







    }
}
