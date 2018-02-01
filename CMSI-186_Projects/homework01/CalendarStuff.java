public class CalendarStuff {

    /**
     * Returns whether the given year is a leap year.
     */
    public static boolean isLeapYear ( long year ) {
        if (year % 4 != 0){
            return false;
        } else if (year % 100 != 0){
            return true;
        } else if (year % 400 != 0){
            return false;
        } else {
        return true;
        }
    }

    /**
     * Returns the number of days in the given month in the given year.
     */
    public static long daysInMonth ( long year, long month ) {
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
        }
    }

    /**
     * Returns whether the given date is a valid date.
     */
    public static boolean isValidDate ( long month, long day, long year ) {
        if (month < 1 || month > 12) {
            return false;
        } else if (day < 1 || day > 31) {
            return false;
        } else if (year < 0) {
            return false;
        } else if (day > daysInMonth(year, month)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns the number of days between the two provided dates, regardless of
     * the order they were provided.
     */
    public static long daysBetween ( long month0, long day0, long year0,
            long month1, long day1, long year1 ) {
        int daysCompleted0 = 0;
        int daysCompleted1 = 0;
        for (int i = 1; i < month0; i++){
            daysCompleted0 += daysInMonth(year0, i);
        }
        daysCompleted0 += day0;
        for (int i = 1; i < month01; i++){
            daysCompleted1 += daysInMonth(year1, i);
        }
        daysCompleted1 += day1;
        int daysFromYears = 0;
        if (year0 < year1){
            for (int i = year0; i < year1; i++){
                if (isLeapYear(i) = true){
                    daysFromYears += 366;
                } else {
                    daysFromYears += 365;
                }
            }
            if (isLeapYear(year0) == true){
                return daysFromYears + (366-daysCompleted0) + daysCompleted1;
            } else {
                return daysFromYears + (365-daysCompleted0) + daysCompleted1;
            }

        }
        if (year1 < year0){
            for (int i = year1; i < year0; i++){
                if (isLeapYear(i) = true){
                    daysFromYears += 366;
                } else {
                    daysFromYears += 365;
                }
            }

            
        }



        return -1; // TODO: Finish this method!

        //calculate number of days that have passed
        //calculate difference in years

    /**
     * Returns the day of the week the given date occured on as a String.
     */
    public static String dayOfTheWeek ( long month, long day, long year ) {
        return ""; // TODO: Finish this method!
    }

    /**
     * Returns the long form of the given date as a String.
     */
    public static String longformDate ( long month, long day, long year ) {
        return ""; // TODO: Finish this method!
    }

    public static void main ( String[] args ) {
        // TODO: Finish this method!
    }
}
