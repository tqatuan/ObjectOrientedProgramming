package Module7;

import Module6.*;

public class SalariedEmployee extends Employee {

    private double annualSalary;

    // Constructor
    public SalariedEmployee(empId Id, empName name, empAddress address,
                            empHireDate hireDate, double annualSalary) {
        super(Id, name, address, hireDate); // construct parent class first
        setAnnualSalary(annualSalary);
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        if (annualSalary <= 0) {
            throw new IllegalArgumentException("Please enter valid annual salary");
        }
        this.annualSalary = annualSalary;
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Employee Type: Salaried\n" +
                "Annual Salary: $" + String.format("%.2f", annualSalary);
    }
}
