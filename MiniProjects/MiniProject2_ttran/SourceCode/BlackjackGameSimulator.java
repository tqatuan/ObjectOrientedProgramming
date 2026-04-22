/**
 * Entry point for the Blackjack game simulation application.
 * This class handles user input for the starting money and initializes the game.
 * It creates a new Game object and starts the game loop
 *
 * @author Tuan Tran
 * @date October 29th, 2025
 * @description A Java application that simulates a Blackjack game.
 */

import java.util.Scanner;

public class BlackjackGameSimulator {
    public static void main(String[] args) {

        /**
         * Main method that drives the Blackjack game simulation.
         * It prompts the user for their starting money and initializes the game.
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Blackjack! Enter your starting money:");
        double initialMoney = scanner.nextDouble();
        Game game = new Game(initialMoney);
        game.startGame();
        scanner.close();
    }
}