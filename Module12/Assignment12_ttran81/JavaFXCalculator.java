/**
 * @author Tuan Tran
 * @Date Nov 16th, 2025
 * Module 11
 * @Description: Design a javaFX application but only implement the UI
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFXCalculator extends Application {

    // Initialize Labels to describe the text fields
    private Label firstLabel = new Label("First value:");   // Label for first input
    private Label secondLabel = new Label("Second value:"); // Label for second input
    private Label sumLabel = new Label("Sum is:");          // Label for sum output

    // Text fields for user input and output
    private TextField firstValueField = new TextField(); // Field for first value input
    private TextField secondValueField = new TextField(); // Field for second value input
    private TextField sumField = new TextField(); // Field to display sum (read-only)

    // Button to trigger calculation (no functionality per assignment)
    private Button calculateButton = new Button("Calculate");

    /**
     * init()
     *
     * Initializes properties of the input and output fields.
     */
    @Override
    public void init() {
        // Configure the first input field
        firstValueField.setPromptText("Enter first value");
        firstValueField.setPrefColumnCount(10); // Width of text field in columns

        // Configure the second input field
        secondValueField.setPromptText("Enter second value");
        secondValueField.setPrefColumnCount(10); // Width of text field

        // Configure the sum field
        sumField.setEditable(false); // Make output field read-only
        sumField.setPrefColumnCount(10); // Width of output field

    }

    /**
     * start()
     *
     * Sets up the GUI layout and adds all controls to the stage.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java Calculator"); // Window title

        // Using Grid layout manager in this case
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40)); // Space around the edges
        grid.setVgap(10); // Vertical spacing between rows
        grid.setHgap(10); // Horizontal spacing between columns

        // Add labels and text fields to the grid at specific row/column positions
        grid.add(firstLabel, 0, 0);        // Row 0, Column 0
        grid.add(firstValueField, 1, 0);   // Row 0, Column 1
        grid.add(secondLabel, 0, 1);       // Row 1, Column 0
        grid.add(secondValueField, 1, 1);  // Row 1, Column 1

        // Add sum label and field
        grid.add(sumLabel, 0, 2, 2, 1); // Span sum label across 2 columns
        grid.add(sumField, 1, 2);       // Sum field next to label

        // Add the calculate button
        grid.add(calculateButton, 1, 3); // Positioned at row 3, column 1

        // Create the scene with the grid and set window size
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene); // Attach the scene to the stage
        primaryStage.show();          // Display the stage
    }

    /**
     * main()
     *
     * Launches the JavaFX application.
     */
    public static void main(String[] args) {
        launch(args); // Starts the JavaFX application
    }

    /**
     * stop()
     *
     * Called when the application is about to exit.
     */
    @Override
    public void stop() {
        // No resources to clean up in this simple example
    }
}
