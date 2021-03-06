/*
Author: Tommy Bennett
FileName: BrobInt.java
Date: 4/19/2018
Purpose: Do math with big numbers
*/

//Public-Private key cryptography

//Gullivers travels : Endian

/*
BrobInt b = newBrobInt("137522719453927843");
BrobInt b2 = newBrobInt("84325372317");
b.add(b2);

Need add, subtract, multiply, and divide methods

INTEGER MATH: No decimal points for integer division
trunkate for rounding

s1.compareTo(s2):
S1 < S2 returns -1
S1 > S2 returns 1
S1 == S2 returns 0
Check java library to see if there is already a string comparison

3 files: brobint.java, fibonnaci.java, brobinttester.Java

Array of places?!?!?!

Need to start at the right tho
or reverse the string and then adjust for one extra cary

calculate in bytes, pair off and handle two places at once. So handle 34 instead of 3 then 4
or in int, and then handle as 8 places

have zero carry instead of no carry at All
this handles both cases


/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  B.J. Johnson
 * Date       :  2017-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                     validateDigits, two reversers, and valueOf methods; revamped equals
 *                                     and compareTo methods to use the Java String methods; ready to
 *                                     start work on subtractByte and subtractInt methods
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;

public class BrobInt {

   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   //public static final BrobInt MAX_INT  = new BrobInt( new Integer.valueOf( Integer.MAX_VALUE ).toString() );
   //public static final BrobInt MIN_INT  = new BrobInt( new Integer.valueOf( Integer.MIN_VALUE ).toString() );
   //public static final BrobInt MAX_LONG = new BrobInt( new Long.valueOf( Long.MAX_VALUE ).toString() );
   //public static final BrobInt MIN_LONG = new BrobInt( new Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   private String internalValue = "";        // internal String representation of this BrobInt
   private byte   sign          = 0;         // "0" is positive, "1" is negative
   private String reversed      = "";        // the backwards version of the internal String representation
   private byte[] byteVersion   = null;      // byte array for storing the string values; uses the reversed string
   private int numOfBytesInArray = 0;        // number of values in the byte version[] array
  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
       internalValue = value;
      if (value.substring(0, 1).equals("-")){
          sign = 1;
          value = value.substring(1, (value.length()));
      }else if(value.substring(0, 1).equals("+")){
          sign = 0;
          value = value.substring(1, (value.length()));
      }
      else{
          sign = 0;
      }
      String reverse = new StringBuffer(value).reverse().toString();

      byteVersion = reverse.getBytes();
      for(int i = 0; i < byteVersion.length; i++){
          byteVersion[i] -= 48;
      }


   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() {
           for (int i = 0; i <= byteVersion.length; i++){
                if (byteVersion[i] < 0 || byteVersion[i] > 9){
                    throw new NumberFormatException( "Value not a number");
                }
            }
            return true;
         }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt reverser() {
       int arrayLength = numOfBytesInArray;
       for(int i = 0; i <= arrayLength; i++){
           byteVersion[i] = byteVersion[arrayLength-i];
       }
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobIntk passed as argument
   *  Note: static method
   *  @param  gint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt reverser( BrobInt gint ) {
       for (int i = gint.byteVersion.length; i >= 0; i--){
           gint.byteVersion[i] = gint.byteVersion[(gint.byteVersion.length) - i];
       }
       return gint;
      //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using byte array
   *  @param  gint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt addByte( BrobInt gint ) {
       String result = "";
       int carry = 0;
       byte[] sum = null;

       BrobInt larger;
       BrobInt smaller;

       byte compare = (byte) this.compareTo(gint);

        // BrobInt thisCopy = new BrobInt(this.toString());
        // BrobInt gintCopy = new BrobInt(gint.toString());

        // if(compare >= 0){
        //     larger = new BrobInt(this.toString());
        //     smaller = new BrobInt(gint.toString());
        // } else {
        //     larger = new BrobInt(gint.toString());
        //     smaller = new BrobInt(this.toString());
        // }


       //System.out.println(compare);



       //System.out.println(compare);
       //SIGN: 0 is positive, 1 is negative
       //COMPARETO: returns 1 if this > gint, returns -1 if gint > this

       //if (compare >= 0) {
       if (compare >= 0) {
            for (int i = 0; i < this.byteVersion.length; i++){
                if (i >= gint.byteVersion.length){
                     result = Integer.toString(this.byteVersion[i] + carry) + result;
                 }else{
                     result = Integer.toString((this.byteVersion[i] + gint.byteVersion[i] + carry) % 10) + result;
                     if ((this.byteVersion[i] + gint.byteVersion[i] + carry) >= 10){
                         carry = 1;
                     }else{
                         carry = 0;
                     }
                 }

            }
            if(carry > 0) {
                result = Integer.toString(carry) + result;
            }

            if(this.sign == 1){
                return new BrobInt("-"+result);
            }else{
                return new BrobInt(result);
            }
        }else{
            for (int i = 0; i < gint.byteVersion.length; i++){
                if (i >= this.byteVersion.length){
                     result = Integer.toString(gint.byteVersion[i] + carry) + result;
                 }else{
                     result = Integer.toString((this.byteVersion[i] + gint.byteVersion[i] + carry) % 10) + result;
                     if ((gint.byteVersion[i] + this.byteVersion[i] + carry) >= 10){
                         carry = 1;
                     }else{
                         carry = 0;
                     }
                 }
            }
            if(carry > 0) {
                result = Integer.toString(carry) + result;
            }
            if(gint.sign == 1){
                return new BrobInt("-"+result);
            }else{
                return new BrobInt(result);
            }

        }


        //result = result.replaceAll("^0+(?!$)", "");

       // if (this.sign == gint.sign){
       //      return new BrobInt(result);
       // }else{
       //      return new BrobInt("-"+result);
       // }



   }



  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using int array
   *  @param  gint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt addInt( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using bytes
   *  @param  gint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtractByte( BrobInt gint ) {
       //0 is positive, 1 is negative
       String result = "";
       byte[] sum = null;

       // BrobInt larger;
       // BrobInt smaller;

       byte compare = (byte) this.compareTo(gint);

        BrobInt thisCopy = new BrobInt(this.toString());
        BrobInt gintCopy = new BrobInt(gint.toString());
       //
       //  if(compare >= 0){
       //      larger = new BrobInt(this.toString());
       //      smaller = new BrobInt(gint.toString());
       //  } else {
       //      larger = new BrobInt(gint.toString());
       //      smaller = new BrobInt(this.toString());
       //  }
       //
       //
       //
       //  if (larger.sign == 0){
       //      larger.sign = 1;
       //  }
       //
       if (this.sign == 1 && gint.sign == 1 && this.compareTo(gint) == 1){
           thisCopy.sign = 0;
           gintCopy.sign = 0;
           result = "-" + thisCopy.subtractByte(gintCopy);
           return new BrobInt(result);
       }
       if (this.sign == 1 && gint.sign == 1 && this.compareTo(gint) == -1){
           thisCopy.sign = 0;
           gintCopy.sign = 0;
           return gintCopy.subtractByte(thisCopy);
       }


       if (gint.sign == 1){
           gintCopy.sign = 0;
           return this.addByte(gintCopy);

       }
       if (this.sign == 1 && gint.sign == 0){
           thisCopy.sign = 0;
           result = "-" + thisCopy.addByte( gintCopy);
           return new BrobInt(result);
       }


       //SIGN: 0 is positive, 1 is negative
       //COMPARETO: returns 1 if this > gint, returns -1 if gint > this
       if (compare >= 0) {
             for (int i = 0; i < this.byteVersion.length; i++){
                 if (i >= gint.byteVersion.length){
                      result = Integer.toString(this.byteVersion[i]) + result;
                  }else{
                      if ((this.byteVersion[i] - gint.byteVersion[i])  <  0){
                          this.byteVersion[i-1] -=10;
                          this.byteVersion[i]+=10;
                          result = Integer.toString((this.byteVersion[i] - gint.byteVersion[i])) + result;
                      }else{
                          result = Integer.toString((this.byteVersion[i] - gint.byteVersion[i])) + result;

                      }
                  }
             }
         }

         else {
             ;
              for (int i = 0; i < gint.byteVersion.length; i++){
                  if (i >= this.byteVersion.length){
                       result = Integer.toString(gint.byteVersion[i]) + result;
                   }else{
                       if ((gint.byteVersion[i] - this.byteVersion[i])  <  0){
                           gint.byteVersion[i-1] -=10;
                           gint.byteVersion[i]+=10;
                           result = Integer.toString((gint.byteVersion[i] - this.byteVersion[i])) + result;
                       }else{
                           result = Integer.toString((gint.byteVersion[i] - this.byteVersion[i])) + result;

                       }

                   }

              }
              result = "-" + result;
          }



        return new BrobInt(result);
      //throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using int array
   *  @param  gint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtractInt( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  gint         BrobInt to multiply by this
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt gint ) {
       String result = "";

       byte compare = (byte) this.compareTo(gint);
       // check for the signs; if not the same, the result should be negative
       // this can be done in one line with an OR of two ANDs
       if (this.sign != gint.sign){
           result += "-";
       }

       // BrobInt a;
       // BrobInt b;
       //
       //  if(compare >= 0){
       //      BrobInt a = new BrobInt(this.toString());
       //      BrobInt b = new BrobInt(gint.toString());
       //  } else {
       //      BrobInt a = new BrobInt(gint.toString());
       //      BrobInt b = new BrobInt(this.toString());
       //  }
       //
       //  if (a.compareTo(b) == 1){
       //      byte[] me = new byte[a.length];
       //      for (int i = 0; i <= a.length; i ++){
       //          me[i] = a[i];
       //      }
       //  }

// dimension the byte arrays and initialize them appropriately for their lengths;
//   'a' gets the longer string, 'b' gets the shorter one
//   IF MY string is longer than ARGUMENT's string:
//     dimension 'a' to be proper number of elements for ME
//     in a loop, convert the value of MY digit[s] and put into a's element[s]
//     dimension 'b' to be proper number of elements for ARGUMENT
//     in a loop, convert the value of ARGUMENT's digit[s] and put into b's elements[s]
//   ELSE
//     dimension 'a' to be proper number of elements for ARGUMENT
//     in a loop, convert the value of ARGUMENT digit[s] and put into a's element[s]
//     dimension 'b' to be proper number of elements for ME
//     in a loop, convert the value of ME's digit[s] and put into b's elements[s]

// dimension and zero out the result array
//   dimension 'c' to be total of a's elements plus b's elements plus one
//   in a loop, put zero in each element of 'c'

// this is the multiplication loop; we handle the addition with each iteration
//  multiply each digit in 'a' by each digit in 'b' sequentially, while also
//  handling the carry and the addition of the previous sum of digits in the column
//
// FOR each element in 'b' (shortest number) using 'i'
//   set 'k' = 'i'
//   FOR each element in 'a' (longest number) using 'j'
//      multiply a[j] times b[i] and add carry and what's already at c[k]
//      IF c[k] > 9
//         handle carry
//      ELSE
//         clear carry
//      increment 'k'
//   END FOR
//   check and handle final carry
//   clear carry
// END FOR

// create a new StringBuffer
// loop to add each element of 'c' to StringBuffer

// IF carry
//    add value of carry to StringBuffer

// IF negative
//    add negative sign to StringBuffer

// NOTE: if handling things in reverse order, reverse the string
//  calling StringBuffer's "reverse()" method

// remove leading zeros

// return a new BrobInt passing result string
 //return new BrobInt( result_s );


      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  gint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  gint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt gint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  gint  BrobInt to add to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method performs a lexicographical comparison using the java String "compareTo()" method
   *        THAT was easy.....
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( BrobInt gint ) {
       // handle the signs here
        if( 1 == sign && 0 == gint.sign ) {
           return -1;
        } else if( 0 == sign && 1 == gint.sign ) {
           return 1;
        }

       // the signs are the same at this point
       // check the length and return the appropriate value
       //   1 means this is longer than gint, hence larger
       //  -1 means gint is longer than this, hence larger
        if( internalValue.length() > gint.internalValue.length() ) {
           return 1;
        } else if( internalValue.length() < gint.internalValue.length() ) {
           return (-1);

       // otherwise, they are the same length, so compare absolute values
        } else {
           for( int i = 0; i < internalValue.length(); i++ ) {
              Character a = Character.valueOf( internalValue.charAt(i) );
              Character b = Character.valueOf( gint.internalValue.charAt(i) );
              if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
                 return 1;
              } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
                 return (-1);
              }
           }
        }
        return 0;
  }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  gint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above
   *        also using the java String "equals()" method -- THAT was easy, too..........
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt gint ) {
      return (internalValue.equals( gint.toString() ));
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value         long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt gi = null;
      try {
         //gi = new BrobInt( new Long.valueOf( value ).toString() );
      }
      catch( NumberFormatException nfe ) {
         System.out.println( "\n  Sorry, the value must be numeric of type long." );
      }
      return gi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
      String byteVersionOutput = "";
      for( int i = 0; i < byteVersion.length; i++ ) {
         byteVersionOutput = byteVersionOutput.concat( Byte.toString( byteVersion[i] ) );
      }
      byteVersionOutput = new String( new StringBuffer( byteVersionOutput ).reverse() );
      return internalValue;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( byte[] d ) {
      System.out.println( Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  note:  we don't really care about these
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );

      BrobInt b = new BrobInt(args[0]);
      BrobInt c = new BrobInt("456");

      System.out.println("Creating BrobInt b = 123");
      System.out.println(Arrays.toString(b.byteVersion));

      System.out.println("Adding b to BrobInt 456");
      b.addByte(c);
      System.out.println(Arrays.toString(b.byteVersion));

      System.exit( 0 );
   }
}
