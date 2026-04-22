/**
 * @author Tuan Tran
 * @date Nov 23rd, 2025
 * Module 13
 * @description JavaFX Loan Calculator User Interface (Using ButtonHandler class)
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoanCalculator extends Application {

    // Labels for Loan calculator
    private Label interestRateLabel = new Label("Annual Interest Rate:");
    private Label numYearsLabel = new Label("Number of Years:");
    private Label loanAmountLabel = new Label("Loan Amount:");
    private Label monthlyPaymentLabel = new Label("Monthly Payment:");
    private Label totalPaymentLabel = new Label("Total Payment:");

    // Input and output fields
    private TextField annualInterestRateField = new TextField();
    private TextField numYearsField = new TextField();
    private TextField loanAmountField = new TextField();
    private TextField monthlyPaymentField = new TextField();
    private TextField totalPaymentField = new TextField();

    // Calculate button
    private Button calculateButton = new Button("Calculate");

    /**
     * Initializes UI components and connects button handler.
     */
    @Override
    public void init() {
        annualInterestRateField.setPromptText("Ex: 0.01, 0.05, 0.2");
        annualInterestRateField.setPrefColumnCount(15);

        numYearsField.setPromptText("Ex: 0.5, 3, 5, 10");
        numYearsField.setPrefColumnCount(15);

        loanAmountField.setPromptText("Enter loan amount");
        loanAmountField.setPrefColumnCount(15);

        monthlyPaymentField.setEditable(false);
        monthlyPaymentField.setPrefColumnCount(15);

        totalPaymentField.setEditable(false);
        totalPaymentField.setPrefColumnCount(5);

        // Assign a separate handler class
        calculateButton.setOnAction(new CalculateButtonHandler());
    }

    //Inner class to handle Calculate button actions.

    private class CalculateButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {

                //Assign values from input fields to appropriate variables
                double interestRate = Double.parseDouble(annualInterestRateField.getText());
                double years = Double.parseDouble(numYearsField.getText());
                double amount = Double.parseDouble(loanAmountField.getText());

                // Implementing some validation code for input
                // Interest must be between 0 and 1 (e.g., 0.05 = 5%)
                if (interestRate <= 0 || interestRate >= 1) {
                    monthlyPaymentField.setText("Rate must be 0–1");
                    totalPaymentField.setText("");
                    return;
                }

                // Years must be positive
                if (years <= 0) {
                    monthlyPaymentField.setText("Years must be positive number");
                    totalPaymentField.setText("");
                    return;
                }

                // Loan amount must be positive
                if (amount <= 0) {
                    monthlyPaymentField.setText("Amount must be positive number");
                    totalPaymentField.setText("");
                    return;
                }

                // Implementing the loan calculation formula

                //Calculating periodic rate aka monthly rate
                double monthlyRate = interestRate / 12;
                int months = (int) Math.round(years * 12);

                // If months less than 1, return error
                if (months < 1) {
                    monthlyPaymentField.setText("Invalid loan term");
                    totalPaymentField.setText("");
                    return;
                }

                // Amortization formula
                double monthlyPayment =
                        (monthlyRate * amount) /
                                (1 - Math.pow(1 + monthlyRate, -months));

                //Calculate total payment is the product of monthly payment and months

                double totalPayment = monthlyPayment * months;

                // Assign monthly payment value to Monthly Payment field
                monthlyPaymentField.setText(String.format("%.2f", monthlyPayment));

                //Assign total payment valye to total payment field
                totalPaymentField.setText(String.format("%.2f", totalPayment));

            } catch (NumberFormatException ex) { // catch exception
                monthlyPaymentField.setText("Invalid. Check your input");
                totalPaymentField.setText("Invalid. Check your input");
            }
        }
    }

    /**
     * Sets up the JavaFX UI layout.
     */
    @Override
    public void start(Stage primaryStage) {

        // Set the title of the main application window
        primaryStage.setTitle("Loan Calculator");

        // Create the GridPane layout that will hold all UI components.
        // Padding adds space around the edges; hgap and vgap add spacing
        // between rows and columns of the grid.
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        // Add all labels and text fields to the correct row and column positions.
        // Column 0 contains labels while column 1 contains corresponding input fields.
        grid.add(interestRateLabel, 0, 0);
        grid.add(annualInterestRateField, 1, 0);

        grid.add(numYearsLabel, 0, 1);
        grid.add(numYearsField, 1, 1);

        grid.add(loanAmountLabel, 0, 2);
        grid.add(loanAmountField, 1, 2);

        grid.add(monthlyPaymentLabel, 0, 3);
        grid.add(monthlyPaymentField, 1, 3);

        grid.add(totalPaymentLabel, 0, 4);
        grid.add(totalPaymentField, 1, 4);

        grid.add(calculateButton, 1, 5);

        // Create the scene using the grid layout and set its size.
        Scene scene = new Scene(grid, 360, 260);

        // Attach the scene to the primary stage and display the application window.
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        // Nothing to clean up
    }
}
