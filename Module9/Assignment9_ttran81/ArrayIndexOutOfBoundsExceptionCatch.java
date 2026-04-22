/**
 * @author Tuan Tran
 * @Date Oct 25th, 2025
 * Module 9
 * @Description: design a program that catch ArrayIndexOutOfBoundsException
 * This excception occurs when an array has been accessed with an illegal index.
 * To handle this, Use the last valid index to access the array
 */

public class ArrayIndexOutOfBoundsExceptionCatch {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55}; // Array with 5 elements

        // Loop through the indices of the array
        for (int i = 0; i <= 5; i++) {
            try {
                System.out.println("Array index value: " + arr[i] + " at index " + i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Caught ArrayIndexOutOfBoundsException:");
                System.out.println("Message: " + e.getMessage());
                System.out.println("Index attempted: " + i);

                if (i >= arr.length) {
                    System.out.println("Attempting to access an index that is out of bounds. Using last valid index.");
                    int lastValidIndex = arr.length - 1;
                    System.out.println("Last array index value: " + arr[lastValidIndex] + " and last valid index is " + lastValidIndex);
                }
            }
        }
    }
}