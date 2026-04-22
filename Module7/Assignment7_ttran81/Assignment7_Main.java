/**
 * @author Tuan Tran
 * @Date Oct 13th, 2025
 * Module 7
 * @Description: test program that creates a salaried
 * employee and two hourly employees
 */

package Module7;

import Module6.*;

public class Assignment7_Main {
    public static void main(String[] args) {
        // Create employee IDs
        empId id1 = new empId(001);
        empId id2 = new empId(002);
        empId id3 = new empId(003);

        // Create employee names
        empName name1 = new empName("Bob", "Henderson");
        empName name2 = new empName("Janet", "Lawrence");
        empName name3 = new empName("Tim", "Johnson");

        // Create employee addresses
        empAddress address1 = new empAddress("123 Main St", "New York", "NY", "10001");
        empAddress address2 = new empAddress("456 Oak Ave", "Los Angeles", "CA", "90001");
        empAddress address3 = new empAddress("789 Pine Rd", "Chicago", "IL", "60601");

        // Create hire dates
        empHireDate hireDate1 = new empHireDate(1, 15, 2001);
        empHireDate hireDate2 = new empHireDate(3, 20, 2002);
        empHireDate hireDate3 = new empHireDate(6, 10, 2003);

        // Create one salaried employee
        SalariedEmployee salariedEmp = new SalariedEmployee(id1, name1, address1,
                hireDate1, 75000.00);

        // Create hourly employee with less than 40 hours
        HourlyEmployee hourlyEmp1 = new HourlyEmployee(id2, name2, address2,
                hireDate2, 25.00, 35.0);

        // Create hourly employee with more than 40 hours
        HourlyEmployee hourlyEmp2 = new HourlyEmployee(id3, name3, address3,
                hireDate3, 30.00, 45.0);

        // Display all employees
        System.out.println("=== EMPLOYEE INFORMATION ===\n");

        System.out.println("--- Salaried Employee ---");
        System.out.println(salariedEmp);
        System.out.println("\n" + "-".repeat(30) + "\n");

        System.out.println("--- Hourly Employee 1 (Under 40 hours) ---");
        System.out.println(hourlyEmp1);
        System.out.println("\n" + "-".repeat(30) + "\n");

        System.out.println("--- Hourly Employee 2 (Over 40 hours) ---");
        System.out.println(hourlyEmp2);
        System.out.println("\n" + "-".repeat(30) + "\n");
    }
}