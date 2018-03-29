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
    public static boolean initial;
    public static boolean moving;

    public static double totalSeconds;
    public static double timeSlice;
    private static int ballQuantity;

    private static Timer timer = null;
    private static Ball[] balls = null;


    public SoccerSim() {
        timer = new Timer();
    }

    public void handleArgs(String args[]){
        if(0 == args.length){
            System.out.println("No args entered\nTry: java SoccerSim <X Location> <Y Location> <X Velocity> <Y Velocity> <Time Slice> ");
            System.exit(0);
        }

        if (args.length % 4 == 1) {
            int j = 0;
            for (int i = 0; i < args.length-1; i+=4){
                Double xPos = Double.parseDouble(args[i+0]);
                Double yPos = Double.parseDouble(args[i+1]);
                Double xVel = Double.parseDouble(args[i+2]);
                Double yVel = Double.parseDouble(args[i+3]);
                Double timeSlice = Double.parseDouble(args[args.length-1]);
                balls[j] = new Ball(xPos, yPos, xVel, yVel, timeSlice);

                j++;
                ballQuantity = j;

            }

        }

        if (args.length % 4 == 0) {
            int j = 0;
            for (int i = 0; i < args.length; i+=4){
                Double xPos = Double.parseDouble(args[i+0]);
                Double yPos = Double.parseDouble(args[i+1]);
                Double xVel = Double.parseDouble(args[i+2]);
                Double yVel = Double.parseDouble(args[i+3]);
                Double timeSlice = 1.0;
                balls[j] = new Ball(xPos, yPos, xVel, yVel, timeSlice);

                j++;
                ballQuantity = j;

            }
        }
    }

    public void validateArgs(String[] args) throws IllegalArgumentException,
                                                    NumberFormatException {
        try {
            this.handleArgs(args);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe.toString());
        }
        if (timeSlice > 1800) {
            throw new IllegalArgumentException("Invalid timeSlice");
        }
        for (int i = 0; i < balls.length; i++){
            if ((Math.abs(balls[i].getxPosition()) > 500) || (Math.abs(balls[i].getxPosition()) > 500) ) {
                throw new IllegalArgumentException("Location out of range");
                }
            }
//find number of balls in
        if ((args.length % 4) == 1) {
            ballQuantity = (int) Math.floor((args.length - 1) / 4);
            }
        if ((args.length % 4) == 0) {
            ballQuantity = args.length / 4;
        } else {
            throw new IllegalArgumentException("Invalid number of arguments");
        }


    }
            /*try {

                    }
                    else {
                        System.out.println(args.length);
                        throw new IllegalArgumentException("Invalid number of arguments. Please try again!");
                    }

                    for (int i = 0; i < balls.length; i++){
                        if ( this.timeSlice > 1800){
                            throw new IllegalArgumentException("Not a valid time slice");
                        }
                        if ((Math.abs(balls[i].getxPosition()) > 500) || (Math.abs(balls[i].getyPosition()) > 500)) {
                            throw new IllegalArgumentException("Ball position not on field");
                        }
                    }

                } catch (NumberFormatException nfe){
                System.out.println(nfe);

                }
*/


        public boolean isMoving() {
            for (int i = 0 ; i < balls.length; i++) {
                if (!(balls[i].getxVelocity() == 0 && balls[i].getyVelocity() == 0)) {
                    return true;
                }
            }
            return false;
        }

        public boolean onField() {
            for (int i =0 ; i < balls.length; i++) {
                if (balls[i].getxPosition() < (500) || balls[i].getyPosition() < (500)) {
                    return true;
                }
            }
            return false;
        }

        public int[] collision(){
            int[] collided = new int[2];
            for( int i = 0; i < balls.length - 1; i++ ) {
                for( int j = i + 1; j < balls.length; j++ ) {
                    double distance = Math.sqrt( (Math.pow((balls[i].getxPosition() - balls[j].getxPosition()), 2)) + (Math.pow((balls[i].getyPosition() - balls[j].getyPosition()), 2)));
                    if (distance <= (8.9/12.0)){
                        collided[0] = i;
                        collided[1] = j;
                        return collided;
                    }
                }
            }
        for( int i = 0; i < balls.length; i++ ) {
            double distance = Math.sqrt( (Math.pow((balls[i].getxPosition() - 20), 2)) + (Math.pow((balls[i].getyPosition() - 20), 2)));
            if( (distance * 12.0) <= 8.9 ) {
                collided[0] = i;
                collided[1] = -1;
                return collided;
                }
            }
            return collided;

        }


        public static void main(String[] args){

            System.out.println("WELCOME TO SOCCER SIMMULATOR!\n\n");


            Ball[] balls = null;
            balls = new Ball[(int) (Math.floor(args.length/4))];
            SoccerSim sim = new SoccerSim();

        //if args.length ==1, you have time timeSlice
        //if args.length == 0, you need to set default timeSlice (1 second)
        //else try again throw illegelargs Exception

        //math.floor args.length = number of balls
        //
            try {
                sim.validateArgs(args);
                sim.handleArgs(args);
            }
            catch( IllegalArgumentException iae) {
                System.out.println(iae.toString());
                System.exit(-1);
            }

        //Random ball placed at
            System.out.println("INITIAL at: "  /*Insert Timer*/);
            for (int i = 0; i < balls.length; i++){
                System.out.println(i+":\t"+balls[i].toString());
            }

            System.out.println("Pole is located at: (20, 20)");




            while(sim.isMoving() == true && sim.onField() == true){
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
                    t.tick();
                    balls[i].toString();
                    System.out.println(i+":\t"+balls[i].toString());

                    }
            }
            sim.collision();



        }
}
