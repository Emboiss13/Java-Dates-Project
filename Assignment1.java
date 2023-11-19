import java.util.ArrayList;
import java.util.Scanner;

public class Assignment1 {
    

    /*
     * A method to find the day-of-week for a date.
     *
     * Arguments:
     * `date` -- the SimpleDate for which the day-of-week is to be found.
     *
     * Return value:
     * A String representing the day of week. The day of week should be
     * expressed as a three-letter abbreviation; in other words, this method
     * returns one of:
     *   "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
     */
    
     
        public static String dayOfWeek( SimpleDate date ) {

            String[] WeekDay = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri"};

            int m = date.getMonth();
            int y = date.getYear();
            int d = date.getDay();
    
            if( m < 3 ){
                m += 12; 
                y -= 1; 
            
            }
    
            int C = y % 100;
            int D = y / 100; 
            int W = 13 * (m+1) / 5 ;
            int X = C / 4;
            int Y = D / 4; 
            int Z = W + X + Y + d + C - 2 * D; 
            int day = Z % 7; 
            if(day < 0){
                day += 7;
            }
            return WeekDay[day];
        }
    

    /*
     * Given a set of dates, this method will count the number of dates in the
     * set that fall on a particular day-of-week.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     * `dayOfWeek` -- a String representing the day of week ("Mon" to "Sun")
     *
     * Return value:
     * An integer giving the number of dates that fell on `dayOfWeek`.
     */
    
    public static int countDatesOnDay( SimpleDate[] dates, String weekDayList ) {

        int count = 0; 
            
        for( SimpleDate i : dates) {
            if( dayOfWeek(i) == weekDayList ){
                count ++;
            } 
        }
        return count;
    }

        

    /*
     * A method to find the most frequent day-of-week among a collection of
     * dates.
     *
     * Arguments:
     * `dates` -- an array of SimpleDate objects
     *
     * Return value:
     * If the array `dates` is empty, then this method should return the null
     * reference. Otherwise, the method should return the three-letter
     * abbreviation ("Mon", "Tue", etc.) of the day-of-week that was most
     * frequent.
     * In the case that there is a tie for the most-frequent day-of-week,
     * priority should be given to the day-of-week that comes earliest in the
     * week. (For this method, "Mon" is assumed to be the first day of the
     * week.)
     * For example, if there were a tie between Tuesday, Wednesday, and Sunday,
     * the method should return "Tue".
     */
    
     public static String mostFrequentDayOfWeek( SimpleDate[] dates ) {


        //Storing all converted elements of SimpleDate[] into dayOfWeek into an arraylist
        ArrayList<String> ConvInputDate = new ArrayList<String>();

        //Chech that "array" dates list is not empty in orther to continue
        if( dates.length == 0 ){
            return null;
        }

        for (SimpleDate date : dates) {
            ConvInputDate.add(dayOfWeek(date));
        
        }

        //Initialising variables and lists to iterate
        int Highest = 0;
        String frequent = null;
        String[] WeekDayList = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        
        
        for( String day : WeekDayList ){
            int count = countDatesOnDay(dates, day);
            if( count > Highest){
                Highest = count; 
                frequent = day;
            }
        }
        return frequent;
    }
}