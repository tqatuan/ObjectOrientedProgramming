/**
 * @author Tuan Tran
 * @Date Sep 7, 2025
 * @Description: Develop a program that calculate user's BMI index based off of their input
 * including height and weight
 */

import java.util.Scanner;

public class BMICalculator
{
    public static void main(String[] args)
    {
    // Declare constant
    final double POUNDS_TO_KG = 0.45359237;
    final double INCHES_TO_METERS = 0.0254;

    //Create a Scanner object that reads what the user types from the keyboard
    Scanner input = new Scanner(System.in);

    // Prompt the user for weight in pounds
    System.out.print("Enter your weight in pounds: ");
    double weightPounds = input.nextDouble();

    // Prompt the user for height in inches
    System.out.print("Enter your height in inches: ");
    double heightInches = input.nextDouble();

    // Convert weight to kilograms and height to meters
    double weightKg = weightPounds * POUNDS_TO_KG;
    double heightMeters = heightInches * INCHES_TO_METERS;

    // Calculate BMI
    double bmi = weightKg / (heightMeters * heightMeters);

    // Display BMI
    System.out.printf("Your BMI is: %.2f\n", bmi);
// Display BMI category
    if (bmi < 18.5) {
        System.out.println("BMI Category: Underweight");
    } else if (bmi < 25) {
        System.out.println("BMI Category: Normal");
    } else if (bmi < 30) {
        System.out.println("BMI Category: Overweight");
    } else {
        System.out.println("BMI Category: Obese");
    }

    // Display BMI information reference
    System.out.println("\nBMI Reference:");
    System.out.println("Underweight: less than 18.5");
    System.out.println("Normal: 18.5 – 24.9");
    System.out.println("Overweight: 25 – 29.9");
    System.out.println("Obese: 30 or greater");

    // Close scanner
    input.close();
    }
}
