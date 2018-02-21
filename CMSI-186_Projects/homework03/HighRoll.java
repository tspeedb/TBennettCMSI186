

public class HighRoll {
    public static void main(String args[]){
        BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
        while('q' != inputLine.charAt(0)){
            System.out.println("Welcome to Dice Set!");
            System.out.println("Here are your options:");
            System.out.println("1. Roll all the dice");
            System.out.println("2. Roll a single die");
            System.out.println("3. Calculate the score for this set");
            System.out.println("4. Save this score as high score");
            System.out.println("5. Display the high score");
            System.out.println("Enter 'q' to quit the program\n");
            String inputLine = null;
            try {
                inputLine = input.readLine();
                if( 0 == inputLine.length() ) {
                   System.out.println("enter some text!:");
                }
                else if (1 == Integer.parseInt(inputLine)){
                    return DiceSet.roll();
                }
                else if (2 == Integer.parseInt(inputLine)){
                    System.out.println("Which die would you like to roll?");
                    int dieIndex = inputLine.readLine().toInt() - 1;
                    return DiceSet.roll(dieIndex);

                }
                else if (3 == Integer.parseInt(inputLine)){

                }
                else if (4 == Integer.parseInt(inputLine)){

                }
                else if (5 == Integer.parseInt(inputLine)){

                }
            }
        }
        System.out.println("Thanks for playing!");
    }
}
