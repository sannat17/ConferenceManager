package entities;

public class Attendee extends User{
    /**
     * Initializes an Attendee by calling the super constructor from User
     * @param username
     * @param password
     * @param ID
     */
    public Attendee(String username, String password, int ID, String name) {
        super(username, password, ID, name);
    }

}
