package entities;

import java.util.ArrayList;

/** A speaker user that gives speeches */
public class Speaker extends User{

    /**
     * Create a new Speaker
     *
     * @param username the user name of this speaker
     * @param password the password of this speaker
     * @param ID the unique ID of this speaker
     */
    public Speaker(String username, String password, int ID, String firstName) {
        super(username, password, ID, firstName);
        this.messageOptions.add("Message all attendees of the talk");  //which talk? all talks?
        this.messageOptions.add("Respond to an attendee");
    }

    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return super.toString() + delimiter + "speaker";
    }
}
