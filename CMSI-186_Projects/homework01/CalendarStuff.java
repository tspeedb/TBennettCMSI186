/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  Tommy Bennett
 *  Date          :  2018-02-06
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2017-12-25  B.J. Johnson  Updated for Spring 2018
 */
public class CalendarStuff {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY = 0;
   private static final int MONDAY = SUNDAY + 1;
   private static final int TUESDAY = SUNDAY + 2;
   private static final int WEDNESDAY = SUNDAY + 3;
   private static final int THURSDAY = SUNDAY + 4;
   private static final int FRIDAY = SUNDAY + 5;
   private static final int SATURDAY = SUNDAY + 6;

  // you can finish the rest on your own

  /**
   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
   */
   private static final int JANUARY = 0;
   private static final int FEBRUARY = JANUARY + 1;
   private static final int MARCH = JANUARY + 2;
   private static final int APRIL = JANUARY + 3;
   private static final int MAY = JANUARY + 4;
   private static final int JUNE = JANUARY + 5;
   private static final int JULY = JANUARY + 6;
   private static final int AUGUST = JANUARY + 7;
   private static final int SEPTEMBER = JANUARY + 8;
   private static final int OCTOBER = JANUARY + 9;
   private static final int NOVEMBER = JANUARY + 10;
   private static final int DECEMBER = JANUARY + 11;
  // you can finish these on your own, too

  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   *  NOTE: this is optional, but suggested
   */
   private static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class


   public CalendarStuffEmpty() {
      System.out.println( "Constructor called..." );  // replace this with the actual code
   }
  */
  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear( long year ) {
       if (year % 4 != 0){
           return false;
       } else if (year % 100 != 0){
           return true;
       } else if (year % 400 != 0){
           return false;
       } else {
       return true;
       }  // replace this with the actual code
   }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ) {
       if (month == 4 || month == 6 || month == 9 || month == 11) {
           return 30;
       } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
           return 31;
       } else if (isLeapYear(year) == true && month == 2){
           return 29;
       } else if (isLeapYear(year) == false && month == 2){
           return 28;
       } else {
           return -1;
       }  // replace this with the actual code
   }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
      if (month1 == month2 && day1 == day2 && year1 == year2){
          return true;
      } else {
      return false;  // replace this with the actual code
      }
   }

  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
       if( year1 < year2 ) {
           return -1;
       } else if( year1 == year2 ) {
           if( month1 < month2 ) {
               return -1;
           } else if( month1 == month2 ) {
               if( day1 < day2 ) {
                   return -1;
               } else if (day1 == day2) {
                   return 0;
               }
           }
       }
       return 1;

   }

  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isValidDate( long month, long day, long year ) {
       if( year < 1 ) {
           return false;
       } else if( (0 > (month - 1)) || ((month - 1) > 11) ) {
           return false;
       } else if( (1 > day) || (day > daysInMonth( month, year )) ) {
           return false;
       }
       return true;

   }
   // replace this with the actual code

  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( int month ) {
      switch( month - 1 ) {
          case JANUARY:   return "January";
          case FEBRUARY:  return "February";
          case MARCH:     return "March";
          case APRIL:     return "April";
          case MAY:       return "May";
          case JUNE:      return "June";
          case JULY:      return "July";
          case AUGUST:    return "August";
          case SEPTEMBER: return "September";
          case OCTOBER:   return "October";
          case NOVEMBER:  return "November";
          case DECEMBER:  return "December";
          default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
      }
   }

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
   public static String toDayOfWeekString( int day ) {
      switch( day - 1 ) {
          case SUNDAY   : return "Sunday";
          case MONDAY   : return "Monday";
          case TUESDAY  : return "Tuesday";
          case WEDNESDAY: return "Wednesday";
          case THURSDAY : return "Thursday";
          case FRIDAY   : return "Friday";
          case SATURDAY : return "Saturday";
          default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
      }
   }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
       if (isValidDate(month1, day1, year1) == false || isValidDate(month2, day2, year2) == false) {
           throw new IllegalArgumentException("Illegal date entered." );
       } else if (compareDate(month1, day1, year1, month2, day2, year2) == 1) {
           throw new IllegalArgumentException("Dates entered are equal, or are in incorrect order.");
       }

      long dayCount = 0;
      while (dateEquals(month1, day1, year1, month2, day2, year2) == false) {
          dayCount++;
          if (day1 < daysInMonth(month1, year1)){
              day1++;
          } else {
              day1 = 1;
              if (month1 < 12) {
                  month1++;
              } else {
                  month1 = 1;
                  year1++;
              }
          }
      }
      return dayCount;
   }

}
