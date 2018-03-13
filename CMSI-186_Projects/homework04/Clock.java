/*
Author:Tommy Bennett
Title:Clock.java
Date: 3/13/2018
Purpose: Determine the times in which the hands of a clock are at a specific degree
*/

//DECIMAL FORMAT CLASS
import java.text.DecimalFormat;

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private double timeSlice = 0;
   private double targetAngle = 0;
   private double totalSeconds = 0;
   public static final DecimalFormat df = new DecimalFormat( "##.##" );
  /**
   *  Constructor goes here
   */
   public Clock(String [] args) {

       if (args.length == 1){
           targetAngle = Double.parseDouble(args[0]);
           timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
       }
       else if (args.length == 2){
           targetAngle = Double.parseDouble(args[0]);
           timeSlice = Double.parseDouble(args[1]);
       } else {
           System.out.println("Invalid input values");
       }

   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
      totalSeconds += timeSlice;

      return totalSeconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {
      double var = Double.parseDouble(argValue);
      if (var >= 0 && var < 360){
          return var;
      }
      else  if (var >= 360){
          return var % 360;
      }
      else if (var < 0) {
          return Math.abs(var) % 360;
      }
      else {
          throw new NumberFormatException("Invalid angle value!");
     }
   }


  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
      if (argValue == null || argValue == "") {
          timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
          return timeSlice;
      } else {
          timeSlice = Double.parseDouble(argValue);
          return timeSlice;
      }
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      return ((this.getTotalSeconds() % 43200) * HOUR_HAND_DEGREES_PER_SECOND);
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      return ((this.getTotalSeconds() % 3600) * MINUTE_HAND_DEGREES_PER_SECOND);
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
      if (targetAngle <= 180){
          return Math.abs((getMinuteHandAngle())-(getHourHandAngle()));
      }
      else if (targetAngle > 180){
          return 180 - Math.abs((getMinuteHandAngle())-(getHourHandAngle()));
      } else {
          return -1;
      }
      //if degrees > 180, 180-gethand angle
      //if degrees < 180, gethand angle which is the absolute value of minute hand - hour hand
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

   public double getTimeSlice() {
      return timeSlice;
   }

   public double getTargetAngle() {
      return targetAngle;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
      double hours = (double)((int)(this.getTotalSeconds() / 3600));
      double minutes = (double)(((int)(this.getTotalSeconds() / 60)) - (hours * 60));
      double seconds = this.getTotalSeconds() - ((hours * 3600) + (minutes * 60));
      return df.format(hours) + ":" + df.format(minutes) + ":" + df.format(seconds);


             //Should only have 00:00:00 H:M:S using Decimal Format (import java.util.decimalformat)
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "Creating a new clock: " );
      Clock clock = new Clock(args);
      System.out.println( "Created clock: " + clock.toString() );
      System.out.println( "Testing validateAngleArg()....");
      System.out.print( "sending '0 degrees', expecting double value 0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " failed to validate" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println("Setting clock timeSlice to 1 second");
      clock.timeSlice = 1;
      System.out.println( "Ticking for 1000 seconds");
      for(int i = 0; i<1000; i++){
          clock.tick();
      }
      System.out.println("toString of clock after ticking: ");
      System.out.println(clock.toString());
      System.out.println("Hour hand angle of clock after ticking: ");
      System.out.println(clock.getHourHandAngle());
      System.out.println("Minute hand angle of clock after ticking: ");
      System.out.println(clock.getMinuteHandAngle());
      System.out.println("Hand angle of clock after ticking: ");
      System.out.println(clock.getHandAngle());
      System.out.println("Total seconds elapsed after ticking: ");
      System.out.println(clock.getTotalSeconds());
   }
}
