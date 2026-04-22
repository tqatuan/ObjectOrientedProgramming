/**
 * @author Tuan Tran
 * @Date Oct 5th, 2025
 * Module 6
 * @Description: design class ID that has to be a positive interger
 */
public class empId {
    // Declare private variable in this class
    private int id;

    // Constructor
    public empId(int id) {
        this.id = id;
    }

    // Getter is a window to look at the ID
    public int getId() {
        return id;
    }

    // Setter is a method that's used to modify ID of class object EmployeeID
    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive.");
        this.id = id;
    }
    // 5. toString() to add a readable version of ID value instead of using default Java output
    public String toString() {
        return "Employee ID: " + id;
    }
}

