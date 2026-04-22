/**
 * @author Tuan Tran
 * @Date Nov 3rd, 2025
 * Module 10
 * @Description: This program reads and formats data from a .txt file.
 * Then it generates output that can be used to feed a report generator.
 */

import java.io.*;

public class ReportGenerator {

    public static void main(String[] args) {
        // Validate command line arguments: expect 2 arguments
        if (args.length != 2) {
            System.out.println("Usage: java ReportGenerator <inputFile> <numRecords>");
            return; // Exit if the number of arguments is incorrect
        }

        // Initialize input file name and number of records
        String inputFile = args[0];
        int numRecords = 0;

        // Attempt to parse the number of records from arguments
        try {
            numRecords = Integer.parseInt(args[1]);

            // Check if the number of records is a positive integer
            if (numRecords <= 0) {
                System.out.println("Error: Number of records must be positive.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Number of records must be an integer.");
            return; // Exit if the number format is invalid
        }

        // Display the name of the input file and table header
        System.out.println("File: " + inputFile);
        System.out.println("------------------------------------");

        // Specifies how each column should be printed
        System.out.printf("%-5s %-12s %-17s %-25s %s%n",
                "State", "Population", "Child_Population", "Child_Poverty_Population", "Pct_Child_Poverty");
        System.out.printf("%-5s %-12s %-17s %-25s %s%n",
                "-----", "------------", "----------------", "------------------------", "----------------");

        // Define a fixed size for the states array 
        final int MAX_STATECODE = 56;
        StateData[] states = new StateData[MAX_STATECODE];

        // Initialize the array for valid states
        for (int i = 0; i < MAX_STATECODE; i++) {
            states[i] = new StateData(String.format("%02d", i + 1));
        }

        // Read the input file using a BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;           // Variable to hold each line of input
            int count = 0;         // Counter for the number of records processed

            // Read input lines until the end of the file or until numRecords is reached
            while ((line = reader.readLine()) != null && count < numRecords) {

                // Extract state code and population values safely
                String stateCode = safeSubstring(line, 0, 2).trim();
                int totalPopulation = Integer.parseInt(safeSubstring(line, 82, 90).trim());
                int childPopulation = Integer.parseInt(safeSubstring(line, 91, 99).trim());
                int childPovertyPopulation = Integer.parseInt(safeSubstring(line, 100, 108).trim());

                // Convert stateCode to index (0-based)
                int stateIndex = Integer.parseInt(stateCode) - 1;

                // Only process valid codes
                if (stateIndex >= 0 && stateIndex < states.length) {
                    states[stateIndex].addData(totalPopulation, childPopulation, childPovertyPopulation);
                } else {
                    System.out.println("Warning: Invalid state code " + stateCode + " on line: " + line);
                }

                count++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Output aggregated results
        for (StateData data : states) {
            // Check if the data for the state is recorded
            if (data.totalPopulation > 0) {

                // Print out the data
                System.out.printf("%-5s %,-12d %,-17d %,-25d %7.2f%%%n",
                        data.state,
                        data.totalPopulation,
                        data.childPopulation,
                        data.childPovertyPopulation,
                        data.getChildPovertyPct());
            }
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
     * @return the substring from start to end, safely handled for out-of-bounds indexes
     */
    private static String safeSubstring(String s, int start, int end) {
        if (s.length() < start) return "";
        if (s.length() < end) end = s.length();
        return s.substring(start, end);
    }
}
