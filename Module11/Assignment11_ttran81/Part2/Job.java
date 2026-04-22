/**
 * @author Tuan Tran
 * @Date Nov 10th, 2025
 * Module 10
 * @Description: This class represents a single print job with
 * two key properties: the job ID and the estimated print time.
 */

public class Job {
    private int id;
    private int printTime;

    // Default constructor - template for the class with 2 data elements
    public Job() {
        this.id = -1;
        this.printTime = -1;
    }

    /**
     * Main constructor of a job
     *
     * @param id each ID for the printing job
     * @param printTime time it takes for each printing job
     */
    public Job(int id, int printTime) {
        this.id = id;
        this.printTime = printTime;
    }

    // Getter for the JobId
    public int getId() {
        return id;
    }

    //Getter for the print time
    public int getPrintTime() {
        return printTime;
    }

    // String representation of a Job
    @Override
    public String toString() {
        return "Job #: " + id + ", Print time: " + printTime + " secs";
    }
}
