/**
 * @author Tuan Tran
 * @Date Sep 21, 2025
 * Module 4 - Problem 1
 * @Description: Write a program that prompts the user to enter a year
 * and display the entire calendar of that year and reusing methods from previous application
 */
package Module4;
import java.util.Scanner;

public class CalendarApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year;
        // Prompt user for year
        System.out.print("Enter year: ");
        year = input.nextInt();

        printCalendarYear(year);
    }

    /**
     * Prints the calendar for an entire year.
     */
    public static void printCalendarYear(int year) {
        for (int month = 1; month <= 12; month++) {
            //Calling for previous method from DisplayCalendar application
            boolean checkLeapYear = DisplayCalendar.isLeapYear(year);
            int  NumDaysInMonth = DisplayCalendar.getNumDaysInMonth(month,year);
            int  startDay = DisplayCalendar.getStartDay(month, 1, year);
            String monthName = DisplayCalendar.getMonthName(month);
            DisplayCalendar.printMonthHeader(month, year);
            DisplayCalendar.printMonthBody(startDay, NumDaysInMonth);
            System.out.println(); // blank line between months
        }
    }
}
