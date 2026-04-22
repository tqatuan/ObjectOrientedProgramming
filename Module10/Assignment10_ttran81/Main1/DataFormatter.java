/**
 * @author Tuan Tran
 * @date Nov 3rd, 2025
 * Module 10
 * @description Design a program that reads and formats data from a .txt file.
 *  This program will produce an output file in .txt format
 */

import java.io.*;

public class DataFormatter {

    public static void main(String[] args) {

        // Parameter validation: correct number of parameters
        if (args.length != 3) {
            System.out.println("Usage: java DataFormatter <sourceFile> <destinationFile> <numRecords>");
            return; // Exit if the number of arguments is incorrect
        }

        // Initialization: source file and destination file are inline command arguments
        String sourceFile = args[0];
        String destinationFile = args[1];

        // numRecords is to be validated below
        int numRecords;

        /**
         * Attempt to parse the number of records from args array
         * If number of records is 0 or negative, exit program.
         * Handle the exception if a number is not entered.
         */
        try {
            // Parameter validation. args[2] is a string representation, not int
            numRecords = Integer.parseInt(args[2]); // parse numRecords as integer
            if (numRecords <= 0) {
                System.out.println("Error: Number of records must be positive.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number of records.");
            return; // Exit if the number format is invalid
        }

        /**
         * This block creates reader and writer objects.
         * It then starts looping through all lines of the reader object
         * and continues extracting substrings from each line until the end of the file.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;   // Variable to hold each line of input
            int count = 0; // Counter for the number of records processed

            // Add header line once before processing any data
            writer.write("State Total_Population Child_Population Child_Poverty_Population");
            writer.newLine();

            // Continue to read each line from the source file while there are lines to read
            // and the number of records processed is less than numRecords
            while ((line = reader.readLine()) != null && count < numRecords) {
                if (line.trim().isEmpty()) continue; // Skip empty lines

                try {
                    // Extracts the state code from characters 0 to 2
                    String stateCode = safeSubstring(line, 0, 2).trim();

                    // This is not required in the output so comment out
                    //String districtID = safeSubstring(line, 3, 8).trim();
                    // This is not required in the output so comment out
                    //String districtName = safeSubstring(line, 9, 81).trim();

                    // Extracts the total population from characters 82 to 90
                    String totalPop = safeSubstring(line, 82, 90).trim();
                    // Extracts the child population from characters 91 to 99
                    String childPop = safeSubstring(line, 91, 99).trim();
                    // Extracts the child poverty statistic from characters 100 to 108
                    String childPoverty = safeSubstring(line, 100, 108).trim();

                    // Concatenate the extracted fields into a single line in CSV format
                    String csvLine = stateCode + " " + totalPop + " " + childPop + " " + childPoverty;

                    // Write the formatted line to the output file
                    writer.write(csvLine);
                    writer.newLine();

                    // Increment count until it reaches numRecords
                    count++;

                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Skipping errored line #" + (count + 1)
                            + " - not enough characters");
                }
            }

            System.out.println("Reformatted file successfully written to: " + destinationFile);

        } catch (FileNotFoundException e) {
            // Catching FileNotFoundException
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            // Catching other IO exceptions
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }

    /**
     * Safely extracts a substring from the given string.
     * If the start index is greater than the string length, returns an empty string.
     * If the end index is greater than the string length, adjusts to the string's length.
     *
     * @param s     the original string
     * @param start the starting index (inclusive) of the substring
     * @param end   the ending index (exclusive) of the substring
     * @return      the substring from start to end, safely handled for out-of-bounds indexes
     */
    private static String safeSubstring(String s, int start, int end) {
        if (s.length() < start) return "";
        if (s.length() < end) end = s.length();
        return s.substring(start, end);
    }
}
