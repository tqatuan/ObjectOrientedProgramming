/**
 * @author Tuan Tran
 * @date Oct 25th, 2025
 * @description Demonstrates how to catch and handle a NullPointerException.
 * The program attempts to call a method on a null String, catches the exception,
 * and displays a helpful message to the user.
 */
public class NullPointerExceptionCatch {

    public static void main(String[] args) {

        // Initialize a String variable with a null value
        String sampleText = null;

        try {
            // This line of code throws NullPointerException because sampleText is null
            if (sampleText.equals("gfg")) {
                System.out.println("Same");
            } else {
                System.out.println("Not Same");
            }

        } catch (NullPointerException e) {
            // Display the exception details and a custom explanatory message
            System.out.println("Caught NullPointerException: variable 'sampleText' is null.");
            System.out.println("Exception details: " + e);
        }
    }
}
