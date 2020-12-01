package entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

/** An attendee user */
public class Attendee extends User{

    /**
     * Create a new Attendee
     *
     * @param username the user name of this attendee
     * @param password the password of this attendee
     * @param ID the unique ID of this attendee
     */
    public Attendee(String username, String password, int ID, String firstName) {
        super(username, password, ID, firstName);
        this.eventOptions.add("Sign up for an event");
        this.eventOptions.add("Cancel sign up for an event");
        this.messageOptions.add("Message an attendee");
        this.messageOptions.add("Message a speaker");

    }

    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return super.toString() + delimiter + "attendee";
    }

}
