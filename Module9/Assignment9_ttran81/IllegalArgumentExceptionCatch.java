/**
 * @author Tuan Tran
 * @date Oct 25th, 2025
 * @description Demonstrates how to catch and handle an IllegalArgumentException.
 * This exception indicates that a method has been passed an illegal or inappropriate argument.
 */
public class IllegalArgumentExceptionCatch {

    public static void main(String[] args) {
        try {
            // Simulate invalid argument being passed
            validateInput(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }

    /**
     * Validates a positive number; throws IllegalArgumentException if invalid.
     */
    public static void validateInput(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Input cannot be negative: " + value);
        }
        System.out.println("Input value: " + value);
    }
}
