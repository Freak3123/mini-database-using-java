package Ashreeta_2241016258;
import java.util.Calendar;

class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getter and setter methods for day, month, and year

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getTime() {
        // Create a Calendar instance and set the date components
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Month in Calendar is 0-based, so subtract 1
    
        // Return the time in milliseconds since the epoch (January 1, 1970)
        return calendar.getTimeInMillis();
    }
}
