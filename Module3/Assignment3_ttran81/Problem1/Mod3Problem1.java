/**
 * @author Tuan Tran
 * @Date Sep 14, 2025
 * Module 3 - Problem 1
 * @Description: Develop a program that product pine or tornado shape using aesterisk
 */

import java.util.Scanner;

public class Mod3Problem1 {
    public static void main(String[] args) {
        // Create a Scanner object that reads what the user types from the keyboard
        Scanner input = new Scanner(System.in);

        // Prompt the user for maximum number of asterisks
        System.out.print("Enter maximum number of asterisks: ");
        int astInput = input.nextInt();

        // Prompt user for pattern choice, condition the output to be 1 or 2 only
        int pattern;
        do {
            System.out.print("Enter your preferred pattern, 1 = pine tree or 2 = tornado: ");
            pattern = input.nextInt();

            if (pattern != 1 && pattern != 2) {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        } while (pattern != 1 && pattern != 2);

        // output
        if (pattern == 1) { // Pattern 1: pine tree shape
            // set loop controlled variable, while the condition x <= astInput is true, increment x
            for (int x = 1; x <= astInput; x++) {
                //Set second variable to control the asterisk printed
                int y = x;
                // while y is more than 1 or x is more than 1, print * then decrement y
                while (y >= 1) {
                    System.out.print("*");
                    y--;
                }
                System.out.println(); // move to next row after inner loop ends
            }
        } else if (pattern == 2) { //Pattern 2: tornado shape
            // set loop control variable, x is the original user input, condition is if x > 1
            for (int x = astInput; x >= 1; x--) {
                int y = x;
                while (y >= 1) {
                    System.out.print("*");
                    y--;
                }
                System.out.println(); // move to next row
            }
        }

        // Close scanner
        input.close();
    }
}
