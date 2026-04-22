/**
 * @author Tuan Tran
 * @date Oct 25th, 2025
 * @description Demonstrates an IllegalArgumentException being thrown.
 * This occurs when a method receives an argument that is illegal or inappropriate.
 */
public class IllegalArgumentExceptionThrown {

    public static void main(String[] args) {
        // Attempt to set invalid ages
        setAge(-5);  // This will throw IllegalArgumentException
    }

    /**
     * Sets the age value if valid; otherwise throws an IllegalArgumentException.
     */
    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        System.out.println("Age set to: " + age);
    }
}
