/**
 * @author Tuan Tran
 * @Date Oct 5, 2025
 * @Description: Develop a program that simulate the race between a tortoise and hare
 * Control the move of each contender through randomization of posibility
 */

import java.util.Random;

public class Simulation {

    public static void main(String[] args) {
        // Declare variables
        char tortoise = 'T';     // T represents Tortoise
        char hare = 'H';         // H represents Hare

        // Both contenders start at position 1
        int positionT = 1;
        int positionH = 1;

        // Variable defines if winner is determined
        boolean winnerFound = false;

        // The race is 50 spaces
        final int FINISH_LINE = 51;

        // Random generator for movement
        Random rand = new Random();

        // Announce race start
        System.out.println("AND THEY’RE OFF!!");

        // Main loop --- continues until a contender finishes
        while (positionT < FINISH_LINE && positionH < FINISH_LINE) {

            double pT = rand.nextDouble(); // random between 0.0 and 1.0
            double pH = rand.nextDouble();

            // Tortoise move logic
            if (pT < 0.2) {
                // 20% chance: shift right by 3
                positionT += 3;
            } else if (pT < 0.7) {
                // 50% chance: shift right by 1
                positionT += 1;
            } else {
                // 30% chance: shift left by 2
                positionT -= 2;
            }

            // Hare move logic
            if (pH < 0.2) {
                // 20% chance: shift right by 9
                positionH += 9;
            } else if (pH < 0.5) {
                // 30% chance: shift right by 1
                positionH += 1;
            } else if (pH < 0.7) {
                // 20% chance: shift left by 12
                positionH -= 12;
            } else if (pH < 0.9) {
                // 20% chance: shift left by 2
                positionH -= 2;
            } // 10% chance: do nothing (hare sleeps)

            // Prevent positions left of 0
            if (positionT < 0) {
                positionT = 0;
            }
            if (positionH < 0) {
                positionH = 0;
            }

            // Print track
            System.out.println("_".repeat(positionT) + tortoise);
            System.out.println("_".repeat(positionH) + hare);

            // Print OUCH when positions coincide
            if (positionT == positionH) {
                System.out.println("OUCH!");
            }

            // Check for winner
            if (positionT >= FINISH_LINE && positionH >= FINISH_LINE) {
                System.out.println("IT’S A TIE!!");
                winnerFound = true;
            } else if (positionT >= FINISH_LINE) {
                System.out.println("TORTOISE WINS!!");
                winnerFound = true;
            } else if (positionH >= FINISH_LINE) {
                System.out.println("HARE WINS!!");
                winnerFound = true;
            }
        }

        System.out.println("Finished!");
    }
}

