/**
 * @author Tuan Tran
 * @Date Nov 3rd, 2025
 * Module 6
 * @Description: This class stores total population, child population, and child poverty population
 *  for a state. It provides methods to group data at state level and
 *  calculating the percentage of child poverty in a state
 */

public class StateData {
    String state;
    int totalPopulation;
    int childPopulation;
    int childPovertyPopulation;

    /**
     * Constructs a new StateData object for a given state code.
     * Initializes all population fields to 0.
     *
     * @param state the state code (e.g., "01", "CA")
     */
    StateData(String state) {
        this.state = state;
        this.totalPopulation = 0;
        this.childPopulation = 0;
        this.childPovertyPopulation = 0;
    }

    /**
     * Adds population data to the existing totals for the state.
     * This allows cumulative addition if multiple records exist for the same state.
     *
     * @param totalPop         the total population to add
     * @param childPop         the child population to add
     * @param childPovertyPop  the child poverty population to add
     */

    void addData(int totalPop, int childPop, int childPovertyPop) {
        this.totalPopulation += totalPop;
        this.childPopulation += childPop;
        this.childPovertyPopulation += childPovertyPop;
    }

    /**
     * Calculates and returns the percentage of children living in poverty.
     *
     * @return the child poverty rate as a percentage (0.0 if childPopulation is 0)
     */
    double getChildPovertyPct() {
        if (childPopulation == 0) return 0.0;
        return ((double) childPovertyPopulation / childPopulation) * 100;
    } }


