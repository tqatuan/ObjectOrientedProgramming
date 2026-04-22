package Module7;

import Module6.*;

public class HourlyEmployee extends Employee {

    //Declare required variables for the class
    private double hourlyRate;
    private double hoursWorked;
    private double totalEarnings;

    //Build constructor
    public HourlyEmployee(empId Id, empName name, empAddress address,
                          empHireDate hireDate, double hourlyPayRate, double hoursWorked) {
        super(Id, name, address, hireDate);
        setHourlyRate(hourlyPayRate);
        setHoursWorked(hoursWorked);
        getTotalEarnings();
    }

    //Getters for all 3 attributes
    public double getHourlyRate() {return hourlyRate;}
    public double getHoursWorked() {return hoursWorked;}

    //Setter for all 3 attributes
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Please enter valid hourly rate");
        }
        this.hourlyRate = hourlyRate;
        getTotalEarnings(); // Recalculate earnings when pay rate changes
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked <= 0) {
            throw new IllegalArgumentException("Please enter valid total hours");
        }
        this.hoursWorked = hoursWorked;
        getTotalEarnings(); // Recalculate earnings when hours change
    }

    //Getter for total earnings, over time is 1.5x hourly rate
    public double getTotalEarnings() {
        if (hoursWorked <= 40) {
            return hourlyRate * hoursWorked;
        } else {
            double overtimeHours = hoursWorked - 40;
            return (40 * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
        }
    }

    // Override toString method
    public String toString() {
        return super.toString() + "\n" +
                "Employee Type: Hourly\n" +
                "Hourly Pay Rate: $" + String.format("%.2f", hourlyRate) + "\n" +
                "Hours Worked: " + hoursWorked + "\n" +
                "Earnings: $" + String.format("%.2f", totalEarnings);
    }
}

