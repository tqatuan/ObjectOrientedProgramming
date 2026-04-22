/**
 * @author Tuan Tran
 * @Date Oct 5th, 2025
 * Module 6
 * @Description: design class empHireDate that return Employee's hire date
 */

public class empHireDate {
    private int month;
    private int day;
    private int year;

    public empHireDate(int month, int day, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    // Getters and Setters with Validation
    public int getMonth() { return month; }
    public void setMonth(int month) {
        if (month < 1 || month > 12) // if month is not 1-12 then throw exception
            throw new IllegalArgumentException("Month must be 1-12.");
        this.month = month;
    }

    public int getDay() { return day; }
    public void setDay(int day) {
        if (day < 1 || day > 31) // if day is not 1-31 then throw exception
            throw new IllegalArgumentException("Day must be 1-31.");
        this.day = day;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year <= 1900 || year >= 2020) // year is 1900 to 2020 only
            throw new IllegalArgumentException("Year must be >= 1900 and <= 2020.");
        this.year = year;
    }

    // output
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }
}
