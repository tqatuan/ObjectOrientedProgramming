/**
 * @author Tuan Tran
 * @Date Oct 5th, 2025
 * Module 6
 * @Description: design class empAddress that return Employee's address
 */

public class empAddress {
    // declare 4 private fields required
    private String street;
    private String city;
    private String state;
    private String zip;

    //Build constructor, Address include Street, city state nad zipcode
    public empAddress(String street, String city, String state, String zip) {
        setStreet(street);
        setCity(city);
        setState(state);
        setZipCode(zip);
    }

    //Define getter and setter in constructor
    // Getters and Setters with validation for street
    public String getStreet() { return street; }
    public void setStreet(String street) {
        if (street == null || street.trim().isEmpty()) // if street name is null or empty, throw exception
            throw new IllegalArgumentException("Street cannot be blank.");
        this.street = street.trim();
    }

    //getter and setter with validation for City
    public String getCity() { return city; }
    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) // if city is blanked or null, throw exception
            throw new IllegalArgumentException("City cannot be blank.");
        this.city = city.trim();
    }

    //Getter and sett with validation for city. 2 character allowed
    public String getState() { return state; }
    public void setState(String state) {
        if (state == null || state.trim().length() != 2) // if state is null or is not 2 char, throw exception
            throw new IllegalArgumentException("State must be 2 characters.");
        this.state = state.trim().toUpperCase();
    }

    // Getter and setter with validation for zip, 5 digit allowed
    public String getZipCode() { return zip; }
    public void setZipCode(String zip) {
        if (zip == null || !zip.matches("\\d{5}"))
            throw new IllegalArgumentException("Zip code must be 5 digits.");
        this.zip = zip;
    }

    //return string
    public String toString() {
        return street + ", " + city + ", " + state + " " + zip;
    }
}