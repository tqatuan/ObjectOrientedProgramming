/**
 * @author Tuan Tran
 * @date Oct 25th, 2025
 * @description Demonstrates a ClassCastException being thrown.
 * A ClassCastException occurs when a program tries to cast an object
 * to a subclass of which it is not an instance.
 */
public class ClassCastExceptionThrown {

    public static void main(String[] args) {
        Object obj = Integer.valueOf(100); // Create an Integer object

        // Attempt to cast obj to String (invalid cast)
        String str = (String) obj; // This line will throw ClassCastException
    }
}
