/**
 * @author Tuan Tran
 * @Date Nov 10th, 2025
 * Module 10
 * @Description: This class represents a single contact entry in a contact list.
 *  It stores basic personal information such as first name, last name,
 *  phone number, and email address. The class implements Serializable
 *  to allow contact objects to be written to and read from files.
 */


import java.io.Serializable;


public class Contact implements Serializable {
    //Contact class implement Serializable as it allows for seamless saving, loading
    // and maintaining the structure of Contact class

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    /**
     * Constructs a Contact object with the specified personal information.
     *
     * @param firstName     the contact's first name
     * @param lastName      the contact's last name
     * @param phoneNumber   the contact's phone number
     * @param emailAddress  the contact's email address
     */
    public Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * Retrieves the last name of the contact.
     * This will be the key for the TreeMap
     *
     * @return the last name of the contact
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns a string representation of the contact.
     * The format includes first name, last name, phone number, and email address.
     *
     * @return a formatted string containing contact information
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + phoneNumber + ", " + emailAddress;
    }
}
