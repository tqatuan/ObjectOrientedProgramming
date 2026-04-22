/**
 * @author Tuan Tran
 * @Date Sep 28th, 2025
 * Module 5 - Problem 1
 * @Description: Write a program that  translate Morse code into English and English into Morse code
 */

import java.util.Scanner;

public class MorseDecoder {
    // Create a 2 dimensions array that map character and Morse COde
    // First dimension is  36 rows (26 letters + 10 numbers)
    // Second dimension is 2 columns
    static String[][] morseCode = {
            {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}
            , {"D", "-.."}, {"E", "."}, {"F", "..-."}
            , {"G", "--."}, {"H", "...."}, {"I", ".."}
            , {"J", ".---"}, {"K", "-.-"}, {"L", ".-.."}
            , {"M", "--"}, {"N", "-."}, {"O", "---"}
            , {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}
            , {"S", "..."}, {"T", "-"}, {"U", "..-"}
            , {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}
            , {"Y", "-.--"}, {"Z", "--.."}
            , {"1", ".----"}, {"2", "..---"}, {"3", "...--"}
            , {"4", "....-"}, {"5", "....."}, {"6", "-...."}
            , {"7", "--..."}, {"8", "---.."}, {"9", "----."}
            , {"0", "-----"}
    };

    // Reusing coding logic - Temperature conversion in Module 4
    public static void main(String[] args) {
        // Initialize variables
        Scanner input = new Scanner(System.in);
        int userChoice = 0;
        String userTextInput;

        // Prompt user for input and display output based on answer from 1st question
        do {
            System.out.print(
                    "Enter 1 - English->Morse Code, 2- Morse Code->English, 3 to quit: ");
            userChoice = input.nextInt();
            input.nextLine(); // consume newline

            if (userChoice == 1) {
                System.out.print(
                        "Enter the English sentence using space between words: ");
                userTextInput = input.nextLine();
                System.out.println(
                        "The Morse representation of your sentence is : " + englishToMorse(userTextInput));
            } else if (userChoice == 2) {
                System.out.print(
                        "Enter the Morse Code you want to translate, using | between codes: ");
                userTextInput = input.nextLine();
                System.out.println(
                        "The English translation of your Morse code is: " + morseToEnglish(userTextInput));
            } else if (userChoice == 3) {
                System.out.println("Bye bye");
                break;
            } else {
                System.out.println("Invalid Data: You must enter 1, 2, or 3");
            }
        } while (userChoice != 3);

        input.close();
    }
    // This method convert English to Morse
    public static String englishToMorse(String userInput) {
        userInput = userInput.toUpperCase(); // Normalize to uppercase
        userInput = userInput.replaceAll("\\s", ""); // Remove spaces for Morse code translation
        String translationStr = "";  //initialize the output string

        // Looping over the length of userInput
        for (int j = 0; j < userInput.length(); j++) {
            // Get each character at position j of userInput, then converts into a String object
            String currentChar = String.valueOf(userInput.charAt(j));

            for (int i = 0; i < morseCode.length; i++) {
                // Return content in 2nd dimension array with same index of 1st dimension
                if (morseCode[i][0].equals(currentChar)) {
                    // Incrementally add the 2nd element of array to output var
                    translationStr += morseCode[i][1] + " ";
                    break;
                }
            }
        }
        return translationStr.trim();
    }

    public static String morseToEnglish(String morseInput) {
        String[] morseSymbols = morseInput.split("\\|"); // Split by delimiter
        String translationStr = ""; //initialize the output string

        // Looping over the length of morseSymbols
        // For each symbol in morseSymbols, find a match in 2nd dimension of array of morseCode
        for (String symbol : morseSymbols) {
            symbol = symbol.trim();
            for (int i = 0; i < morseCode.length; i++) {
                if (morseCode[i][1].equals(symbol)) {
                    translationStr += morseCode[i][0] + " ";
                    break;
                }
            }
        }
        return translationStr.trim();
    }
}
