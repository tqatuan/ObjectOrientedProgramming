/**
 * @author Tuan Tran
 * @Date Nov 10th, 2025
 * Module 11
 * @Description: This program implements a contact list using a TreeMap.
 *  Each contact is stored with the last name as the key and a Contact object as the value.
 *  TreeMap is ultilized since it automatically sorted and stored by key value
 *  The program allows the user to add, delete, view, and save contacts to a file.
 */

import java.io.*;
import java.util.*;
public class ContactMap {

    /**
     * The main method provides a text-based menu interface for managing contacts.
     * It handles file input/output operations and user interactions.
     *
     * @param args not used in this implementation
     */
    public static void main(String[] args) {

        //Initialize input object,TreeMap and filename to store user's input
        Scanner input = new Scanner(System.in);
        TreeMap<String, Contact> allContacts = new TreeMap<>();
        String fileName;

        //prompt the user
        //for the name of the file where the information is stored

        System.out.print("Enter the name of the file to store contacts: ");
        fileName = input.nextLine();

        /**
         * File handling and validation
         * Attempt to load existing contacts from the specified file.
         * If the file does not exist, a new one will be created upon saving.
         */
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = in.readObject();

            if (obj instanceof TreeMap) {
                @SuppressWarnings("unchecked") // This suppresses the unchecked cast warning
                TreeMap<String, Contact> loadedContacts = (TreeMap<String, Contact>) obj;
                allContacts = loadedContacts;
                System.out.println("Contacts loaded from file.");
            } else {
                System.out.println("System.out.println(\"File not found. A new one will be created.\");");
                allContacts = new TreeMap<>(); // Initialize to an empty TreeMap if file doesn't exist
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during I/O: " + e.getMessage());
        }
        // Variable to hold user's choice
        int choice;

        /**
         * Display the main menu repeatedly until the user chooses to exit.
         * Menu options include adding, deleting, displaying, and saving contacts.
         */
        do {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Save and Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                /**
                 * Option 1: Add a new contact to the TreeMap.
                 * Contacts are keyed by last name (case-insensitive).
                 */
                case 1:

                    //Collect users' input for new contact object
                    System.out.print("First Name: ");
                    String firstName = input.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = input.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = input.nextLine();
                    System.out.print("Email Address: ");
                    String email = input.nextLine();

                    //Create a new Contact object
                    Contact contact = new Contact(firstName, lastName, phoneNumber, email);

                    //Add new contact to the allContacts object which is a TreeMap
                    allContacts.put(lastName.toLowerCase(), contact);

                    //Confirm successful adding new contact
                    System.out.println("Contact added.");
                    break;

                /**
                 * Option 2: Delete a contact by last name.
                 * If the contact is not found, display an appropriate message.
                 */
                case 2:
                    System.out.print("Enter last name of contact to delete: ");
                    String deleteName = input.nextLine().toLowerCase();
                    // Check if contact exist, if TRUE then delete, else ERROR
                    if (allContacts.remove(deleteName) != null) {
                        System.out.println("Contact deleted.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                /**
                 * Option 3: Display all contacts currently in the TreeMap.
                 * The TreeMap automatically sorts entries by last name.
                 */
                case 3:
                    System.out.println("\nAll Contacts (sorted by last name):");

                    //Using entreSet() method from TreeMap to display all contacts
                    for (Map.Entry<String, Contact> entry : allContacts.entrySet()) {
                        System.out.println(entry.getValue());
                    }
                    break;

                /**
                 * Option 4: Save all contacts to the specified file.
                 * Contacts are serialized to preserve data between runs.
                 * Program exits after saving.
                 */
                case 4:

                    //initializes a FileOutputStream to write to filename
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
                        //serializes the allContacts object (which is a TreeMap<String, Contact>)
                        // and writes it to the file
                        out.writeObject(allContacts);
                        System.out.println("Contacts saved to " + fileName);
                    } catch (IOException e) { //Handling IO exception
                        System.out.println("Error saving contacts: " + e.getMessage());
                    }
                    System.out.println("Goodbye!");
                    break;

                /** Handles invalid menu selections gracefully. */
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
