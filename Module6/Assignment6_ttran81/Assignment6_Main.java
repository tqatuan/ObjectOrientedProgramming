/**
 * @author Tuan Tran
 * @Date Oct 5th, 2025
 * Module 6
 * @Description: main class that prompt user to create an employee profile and return employee profile as an object
 */

import java.util.Scanner;
public class Assignment6_Main {
    public static void main(String[] args) {
        int empCount; // number of employee
        Employee[] employeeList;//array to hold all employee

        //Instantiate new scanner for user inputs
        Scanner input = new Scanner(System.in);

        //Prompt user for number of employees to enter
        System.out.print("How many employees do you want to enter: ");
        empCount = input.nextInt(); //Get number of employees
        input.nextLine(); //flush the scanner of \n

        // Instantiate the array to the correct number of employee
        employeeList = new Employee[empCount];

        //Loop through each employee, creating employee and contained object
        for (int i = 0; i < empCount; i++) {
            System.out.println("\n----- Employee #" + (i + 1) + " -----");

            // 1. Get ID
            System.out.print("Enter emp id: "); //output msg
            int empIdNumber = input.nextInt(); //get user input for emp id
            input.nextLine(); // flush newline
            empId idObj = new empId(empIdNumber); //create a new id object to pass to Employee class

            // 2. Get NAME
            System.out.print("Enter first name: "); //prompt user for first name
            String first = input.nextLine(); // pass firstname to first
            System.out.print("Enter last name: "); // prompt user for last name
            String last = input.nextLine();  //pass last name to lass
            empName nameObj = new empName(first, last); // create a new object of clas empName taking user input of names

            // 3. Get ADDRESS
            System.out.print("Enter street: "); // prompt user for street
            String st = input.nextLine(); //pass street to st
            System.out.print("Enter city: "); // prompt user for city
            String city = input.nextLine(); // pass user input to city
            System.out.print("Enter state: "); // prompt user for state
            String state = input.nextLine(); // pass user input to state
            System.out.print("Enter zip: "); // prompt user for zip
            String zip = input.nextLine(); // pass user input to zip
            // create a new address object of class empAdd passing parameters from user input
            empAddress addrObj = new empAddress(st, city, state, zip);

            // 4. Get HIRE DATE
            System.out.print("Enter hire month (1-12): "); // prompt user for month
            int month = input.nextInt(); // pass user input to month variable
            System.out.print("Enter hire day (1-31): "); // promt user for day
            int day = input.nextInt(); // pass user input to day variable
            System.out.print("Enter hire year (1900-2020): "); // promt user for year
            int year = input.nextInt(); // assign user input to year variable
            input.nextLine(); // flush newline
            // create a new hdObj that is of class empHireDate taking user input as parameters
            empHireDate hdObj = new empHireDate(month, day, year);

            // create a new Employee object in the array at i using Employee class and required fields
            employeeList[i] = new Employee(idObj, nameObj, addrObj, hdObj);
        }
        // ---- PRINT ALL EMPLOYEES ----
        System.out.println("\nEmployee Profiles:");
        for (int i = 0; i < empCount; i++) {
            System.out.println("----- Employee #" + (i + 1) + " -----");
            System.out.println(employeeList[i]);
            System.out.println();
        }
    }
}
