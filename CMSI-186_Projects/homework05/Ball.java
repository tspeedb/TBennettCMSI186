/*
Author: Tommy Bennett
Title: Ball.java
Date: 3/28/2018
Purpose: Soccer ball class as part of soccer simulation
*/

/*
Author: Tommy Bennett
Title: Ball.java
Date: 3/28/2018
Purpose: Soccer ball class as part of soccer simulation
*/

import java.text.DecimalFormat;

public class Ball {

    private static final double BALL_RADIUS_IN_FEET = 0.3708333;
    private static final double FRICTION_PERCENTAGE = .99;
    private double ballVelocityX = 0;
    private double ballVelocityY = 0;

    private double ballPositionX = 0;
    private double ballPositionY = 0;

    private double timeSlice = 0;


    public Ball(String [] args) {
        ballPositionX = Double.parseDouble(args[0]);
        ballPositionY = Double.parseDouble(args[1]);
        ballVelocityX = Double.parseDouble(args[2]);
        ballVelocityY = Double.parseDouble(args[3]);

        timeSlice = Double.parseDouble(args[4]);
        }

    public Ball(double xPos, double yPos, double xMove, double yMove, double time) {
        ballPositionX = xPos;
        ballPositionY = yPos;
        ballVelocityX = xMove;
        ballVelocityY = yMove;

        timeSlice = time;
        }

    public Ball() {
        super();
    }

    public void frictionCalc() {
        this.ballVelocityX *= Math.pow(FRICTION_PERCENTAGE, timeSlice);
        this.ballVelocityY *= Math.pow(FRICTION_PERCENTAGE, timeSlice);
    }

    public void Move(){
        ballPositionX +=  ballVelocityX;
        ballPositionY +=  ballVelocityY;
        this.frictionCalc();
    }

    public double getxVelocity(){
        if (ballVelocityX < (1/12)){
            return 0;
        } else {
            return ballVelocityX;
        }
    }

    public double getyVelocity(){
        if (ballVelocityY < (1/12)){
            return 0;
        } else {
            return ballVelocityY;
        }
    }

    public boolean isMoving(){
        if (Math.max(this.getxVelocity(), this.getyVelocity()) == 0){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean onField(){
        if((Math.abs(this.ballPositionX) <= (500)) && (Math.abs(this.ballPositionY) <= (500))) {
            return true;
        } else {
            return false;
        }
    }

    public double getxPosition(){
        return ballVelocityX;
    }

    public double getyPosition(){
        return ballVelocityX;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("#0.000");
        String toString = ("Position:("+df.format(this.getxPosition())+", "+df.format(this.getyPosition())+")\tVelocity:(" + df.format(this.getxVelocity()) + ", " + df.format(this.getyVelocity()) + ")");
        return toString;

    }

    public static void main( String[] args ) {
        Ball b = null;
        System.out.println("Creating a new static ball at origin of default time slice...");
        b = new Ball(1, 1, 1, 1, 1);
        System.out.println("Testing Move() ... ");
        b.Move();
        System.out.println("New xPosition: " + b.getxPosition() + " and new xVelocity: " + b.getxVelocity());
        System.out.println("New yPosition: " + b.getyPosition() + " and new yVelocity: " + b.getyVelocity());
        System.out.println("Creating new ball 5 5 5 5 1");
        Ball c = null;
        c = new Ball(5, 5, 5, 5, 1);
        System.out.println("Testing Move() ... ");
        c.Move();
        System.out.println("New xPosition: " + c.getxPosition() + " and new xVelocity: " + c.getxVelocity());
        System.out.println("New yPosition: " + c.getyPosition() + " and new yVelocity: " + c.getyVelocity());

        System.out.println("Ticking 5 times");
        for (int i = 1; i < 5; i++){
            c.Move();
            System.out.println(c.toString());
        }
        System.out.println("New xPosition: " + c.getxPosition() + " and new xVelocity: " + c.getxVelocity());
        System.out.println("New yPosition: " + c.getyPosition() + " and new yVelocity: " + c.getyVelocity());


    }

 }
