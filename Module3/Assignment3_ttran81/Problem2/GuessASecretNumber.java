/**
 * @author Tuan Tran
 * @Date Sep 15, 2025
 * Module 3 - Problem 2
 * @Description: Develop Guess A Secret Number program
 */

import java.util.Scanner;

public class GuessASecretNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Initialize variable to check user's intent to continue
        String playAgain;

        do {
            //Prompt user for their max range
            System.out.print("Enter maximum of the number range: ");
            int maxNumber = input.nextInt();

            // Prompt user for the max number of guesses allowed
            System.out.print("Enter maximum number of guesses allowed: ");
            int maxGuess = input.nextInt();

            // Generate a random number between 1 and maxNumber
            int secretNumber = (int) (Math.random() * maxNumber) + 1;

            // Boolean variable to check if user guessed correctly
            boolean guessCorrectly = false;

            // initialize guess count, if guess count < maxGuess continue and increment guessCount
            for (int guessCount = 0; guessCount < maxGuess; guessCount++) {
                // Prompt user for their guess
                System.out.print("Enter your guess: ");
                int userGuess = input.nextInt();

                // Compare userGuess and secretNumber
                if (userGuess == secretNumber) {
                    System.out.println("Correct!");
                    guessCorrectly = true;
                    break; // exit loop if user guesses correctly
                } else if (userGuess > secretNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }
            }

            // Prompt user if they want to play again outside of for loop
            System.out.print("Do you want to play again? Please enter Y or N: ");
            playAgain = input.next();

        } while (playAgain.equalsIgnoreCase("Y")); // account for lowercase

        System.out.println("Thanks for playing!");
        input.close();
    }
}
