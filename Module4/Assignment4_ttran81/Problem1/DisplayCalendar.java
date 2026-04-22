/**
 * @author Tuan Tran
 * @Date Sep 21, 2025
 * Module 4 - Problem 1
 * @Description: Write a program that prompts the user to enter a month (1-12)
 * and a year (e.g., 2012), and then displays a calendar for that month
 * and year.
 */
package Module4;

import java.util.Scanner;

public class DisplayCalendar {

    /**
     * Main method
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year;
        int month;
        int day = 1;

        // Prompt user for year
        System.out.print("Enter year: ");
        year = input.nextInt();

        // Prompt user for month
        System.out.print("Enter month: ");
        month = input.nextInt();

        // First day of the month
        int startDay = getStartDay(month, day, year);
        int daysInMonth = getNumDaysInMonth(month, year);

        // Print output
        System.out.println();
        printMonthHeader(month, year);
        printMonthBody(startDay, daysInMonth);
    }

    /**
     * The method printMonthBody() prints the calendar using the startDay as the
     * first day of the week the 1st of that month begins. daysInMonth
     * represents the number of days within that month and year (30, 31, 28 or
     * 29). Since the first of the month doesn't have to start on Sunday (where
     * startDay = 0), we need to account for this scenario by printing the
     * spaces required and print days of the month starting from startDay. The
     * rest of the calendar can print exactly 7 times (7 days in a week) while
     * daysInMonth is controlled.
     *
     * Pre-Conditions: startDay, and daysInMonth
     * Post-Conditions: calendar body. We must account for 1-digit and 2-digit
     * numbers. Since each day takes 4 spaces to display:
     * - If a day is < 10, we print 2 spaces as prefix and 1 space as suffix.
     * - If a day is >=10, we print 1 space as prefix and 1 space as suffix.
     */
    public static void printMonthBody(int startDay, int daysInMonth) {
        int dayOfMonth = 1;

        // Print the first week
        for (int i = 0; i < 7; i++) {
            if (i < startDay) {
                // Print 4 spaces for alignment until reaching startDay
                System.out.print("    ");
            } else if (dayOfMonth <= daysInMonth) {
                if (dayOfMonth < 10) {
                    System.out.print("  " + dayOfMonth + " ");
                } else {
                    System.out.print(" " + dayOfMonth + " ");
                }
                dayOfMonth++;
            }
        }
        System.out.println();

        // Print the remaining weeks
        while (dayOfMonth <= daysInMonth) {
            for (int i = 0; i < 7 && dayOfMonth <= daysInMonth; i++) {
                if (dayOfMonth < 10) {
                    System.out.print("  " + dayOfMonth + " ");
                } else {
                    System.out.print(" " + dayOfMonth + " ");
                }
                dayOfMonth++;
            }
            System.out.println();
        }
    }

    /**
     * The method printMonthHeader() prints the first header of the calendar
     * including the month, year and the 7 days in a week. Each day of the week
     * is abbreviated to the first 3 characters.
     *
     * Pre-Conditions: The month value, m, is 1-12 and the year
     * Post-Conditions: A header of the calendar is printed followed by a line
     * of 27 dashes
     */
    public static void printMonthHeader(int m, int y) {
        String monthName = getMonthName(m);
        System.out.println("        " + monthName + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        System.out.println("---------------------------");
    }

    /**
     * The method getMonthName() returns the month name for display depending
     * on the integer number representing the month.
     *
     * Pre-Conditions: The month value, m, is 1-12
     * Post-Conditions: A string value is returned, representing the month name
     * (1 = January, ..., 12 = December)
     */
    public static String getMonthName(int m) {
        return switch (m) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid";
        };
    }

    /**
     * The method getStartDay() implements Zeller's Algorithm for determining
     * the day of the week the first day of a month is. The method adjusts
     * Zeller's numbering scheme for day of week (0=Saturday, ..., 6=Friday) to
     * conform to a day of week number that corresponds to ISO conventions
     * (i.e., 1=Monday, ..., 7=Sunday).
     *
     * Pre-Conditions: The month value, m, is 1-12. The day value, d, is 1-31,
     * or 1-28/29 for February. The year value, y, is the full year (e.g.,
     * 2012).
     *
     * Post-Conditions: A value of 1-7 is returned, representing the first day
     * of the month (1=Monday, ..., 7=Sunday).
     */
    public static int getStartDay(int m, int d, int y) {
        if (m < 3) {
            m = m + 12;
            y = y - 1;
        }

        int k = y % 100;  // Year within century
        int j = y / 100;  // Century
        int h = (d + (13 * (m + 1) / 5) + k + (k / 4)
                + (j / 4) + (5 * j)) % 7;

        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun)
        int dayNum = ((h + 5) % 7) + 1;
        return dayNum;
    }

    /**
     * The method getNumDaysInMonth() returns the number of days within a month
     * of a year. Leap years are accounted for.
     *
     * Pre-Conditions: The month value, m, is 1-12 and the year value, y
     * Post-Conditions: Returns 31 for months with 31 days, 30 for months with
     * 30 days, 29 for February in leap years, otherwise 28.
     */
    public static int getNumDaysInMonth(int m, int y) {
        boolean checkLeapYear = isLeapYear(y);
        return switch (m) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> checkLeapYear ? 29 : 28;
            default -> 0;
        };
    }

    /**
     * The method isLeapYear() checks if a year is a leap year. A year is a
     * leap year if it is divisible by 4 and not divisible by 100, or divisible
     * by 400.
     *
     * Pre-Conditions: The year value
     * Post-Conditions: Returns true if the year is a leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        boolean leap = ((year % 4 == 0) && (year % 100 != 0))
                || (year % 400 == 0);
        return leap;
    }
}
