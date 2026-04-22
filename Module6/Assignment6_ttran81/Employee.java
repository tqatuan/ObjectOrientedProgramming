/**
 * @author Tuan Tran
 * @Date Oct 5th, 2025
 * Module 6
 * @Description: create a class object Employee, taking object from other class including
 * Id (class empID), name (class empName), address(class empAddress), hireDate( class empHireDate)
 * to create a new object
 */


public class Employee {
    // Employee class contained smaller class of objects listed below
    private empId Id;
    private empName name;
    private empAddress address;
    private empHireDate hireDate;

    //Constructor: object Employee required Id, name, address and hireDate
    public Employee(empId Id , empName name, empAddress address, empHireDate hireDate) {
        //Using setter to assign values to all parameters
        setId(Id);
        setName(name);
        setAddress(address);
        setHireDate(hireDate);
    }

    // Define setter and getter for ID of class Employee
    public empId getId() { return Id; }
    public void setId(empId Id) {
        if (Id == null)
            throw new IllegalArgumentException("Id cannot be null.");
        this.Id = Id;
    }

    // Define setter and getter for name of class Employee
    public empName getName() { return name; }
    public void setName(empName name) {
        if (name == null)
            throw new IllegalArgumentException("Name cannot be null.");
        this.name = name;
    }

    // Define setter and getter for address of class Employee
    public empAddress getAddress() { return address; }
    public void setAddress(empAddress address) {
        if (address == null)
            throw new IllegalArgumentException("Address cannot be null.");
        this.address = address;
    }
    // Define setter and getter for hireDate of class Employee
    public empHireDate getHireDate() { return hireDate; }
    public void setHireDate(empHireDate hireDate) {
        if (hireDate == null)
            throw new IllegalArgumentException("Hire date cannot be null.");
        this.hireDate = hireDate;
    }

    //Output - this will be the format of the output of class Employee, presnet on interface
    public String toString() {
        return "Employee Number: " + Id + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Hire Date: " + hireDate;
    }
}