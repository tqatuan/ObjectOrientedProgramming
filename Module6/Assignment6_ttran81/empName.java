/**
 * @author Tuan Tran
 * @Date Oct 5th, 2025
 * Module 6
 * @Description: design class empName that return Employee's First Name and Last Name
 */

public class empName {
    private String firstName;
    private String lastName;

    //Constructor. Name include First and Last name
    public empName(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
    // getter and setter for First Name
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty())
            throw new IllegalArgumentException("First name cannot be blank.");
        this.firstName = firstName.trim();
    }
    //getter and setter for Last name
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("Last name cannot be blank.");
        this.lastName = lastName.trim();
    }

    public String toString() {
        return firstName + " " + lastName;
    }
}
