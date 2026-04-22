/**
 * @author Tuan Tran
 * @date Oct 25th, 2025
 * @description Demonstrates a NullPointerException being thrown.
 * A NullPointerException occurs when a program attempts to call a method
 * on an object reference that has a null value.
 */
public class NullPointerExceptionThrown {

    public static void main(String[] args) {
        // Create a String reference but do not assign an actual object
        String text = null;

        // Attempt to call a method on a null reference
        // This line will throw NullPointerException
        int length = text.length();

        System.out.println("Length of text: " + length);
    }
}
