package entities;

/** An attendee user */
public class Attendee extends User{
    /**
     * Create a new Attendee
     *
     * @param username the user name of this attendee
     * @param password the password of this attendee
     * @param ID the unique ID of this attendee
     */
    public Attendee(String username, String password, int ID) {
        super(username, password, ID);
    }

}
