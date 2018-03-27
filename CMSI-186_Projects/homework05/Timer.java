import java.text.DecimalFormat;


public class Timer{

    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 1.0;
    private static double totalSeconds = 0;

    private static double timeSlice = 0.0;

    private double hours = 0;
    private double minutes = 0;
    private double seconds = 0;

    public Timer(){
        super();
    }

    public Timer(double t){
        this.timeSlice = t;
    }

    public double tick() {
       totalSeconds += this.timeSlice;
       return totalSeconds;
    }

    public double validateAngleArg( String argVal ) throws NumberFormatException, IllegalArgumentException {
       double returnVal = 0.0;
       try {
           returnVal = Double.parseDouble(argVal);
       }
       catch(NumberFormatException nfe) {
           throw new NumberFormatException("Time slice failed");
       }
       if ((0.0 >= returnVal) || (1800.0 < returnVal)){
           throw new IllegalArgumentException("Time slice out of range");
       }
       return returnVal;
    }

    public double getTotalSeconds() {
        return totalSeconds;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.000");
        DecimalFormat df2 = new DecimalFormat("#0");

        hours = Math.floor(totalSeconds/3600);
        minutes = Math.floor((totalSeconds % 3600) / 60);
        seconds = totalSeconds - ((hours * 3600) + (minutes * 60));
        return (df2.format(hours) + ":" + df2.format(minutes) + ":" + df.format(seconds));
    }





}
