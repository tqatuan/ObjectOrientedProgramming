/**
 * @author Tuan Tran
 * @date Oct 25th, 2025
 * @description Demonstrates an ArrayIndexOutOfBoundsException being thrown.
 * Occurs when a program tries to access an array index outside its valid range.
 */
public class ArrayIndexOutOfBoundsExceptionThrown {

    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55}; // Array with 5 elements

        // Loop runs from 0 to 5, which will cause an exception on the last iteration
        for (int i = 0; i <= 5; i++) {
            System.out.println("Array index value: " + arr[i] + " at index " + i);
        }
    }
}
