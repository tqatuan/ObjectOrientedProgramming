/**
 * @author Tuan Tran
 * @date Oct 25th, 2025
 * @description Demonstrates how to catch and handle a ClassCastException.
 * A ClassCastException occurs when an object is cast to an incompatible type.
 */
public class ClassCastExceptionCatch {

    public static void main(String[] args) {
        Object obj = Integer.valueOf(100); // Create an Integer object

        try {
            // Attempt to cast obj to String (invalid cast)
            String str = (String) obj;
            System.out.println("String value: " + str);

        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException:");
            System.out.println("Message: " + e.getMessage());
            System.out.println("Object type: " + obj.getClass().getName());
            System.out.println("Suggested fix: ensure proper casting before using the object.");
        }
    }
}
