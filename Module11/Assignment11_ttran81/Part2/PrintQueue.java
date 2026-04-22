/**
 * @author Tuan Tran
 * @Date Nov 10th, 2025
 * Module 11
 * @Description: This program implements a printing job queue using LinkedList
 * This program manage a print job queue, facilitating user interaction
 * to add jobs and display them in a logical order upon exiting.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;

public class PrintQueue {

    public static void main(String[] args) {

        // A LinkedList to hold the print jobs in a FIFO manner.
        LinkedList<Job> jobQueue = new LinkedList<>();

        //A Random object initialized with a seed for generating consistent random numbers.
        Random rnGenerator = new Random(100);

        //Used to track and assign unique IDs to each job.
        int jobNumber = 1;

        // Craete a variable choice to hold user's choice
        String choice;

        //Read user input in a loop until the user chooses to quit the program
        //Always on menu options for user to choose from
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            do {

                //Displays the options for the user and save their choices input
                System.out.println("\n===== PRINT QUEUE MENU =====");
                System.out.println("1. Add a new print job");
                System.out.println("0. Quit and display queue");
                System.out.print("Enter your choice: ");

                //Save user options
                choice = in.readLine();


                if (choice.equals("1")) {
                    //1: a random print time between 10 and 1000 seconds is generated.
                    int randomTime = rnGenerator.nextInt(991) + 10; // instructed from assignment

                    //Create a new Job object using jobNumber and randomTime
                    Job newJob = new Job(jobNumber, randomTime);

                    //add newJob to jobQueue which is a LinkedList
                    jobQueue.add(newJob);

                    // Confirm the job added
                    System.out.println("Added " + newJob);

                    //Increment jobNumber by 1 as user add more job
                    jobNumber++;
                } else if (choice.equals("0")) {
                    // 0: iterates over the jobQueue using an enhanced for loop to print all job
                    System.out.println("\nPrinting all jobs in queue:");
                    for (Job job : jobQueue) {
                        System.out.println(job);
                    }

                    // End of the program
                    System.out.println("End of queue.");
                    return;
                } else {
                    //Prompt user for correct input
                    System.out.println("Invalid choice. Please enter 1 or 0.");
                }
            } while (true);
        } catch (IOException e) { //IO Exception Handling
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
