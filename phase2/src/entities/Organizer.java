package entities;

import java.util.ArrayList;

/** An organizer user with management level capabilities */
public class Organizer extends User{

    private String type = "organizer";
    /**
     * Create new Organizer, initialize a list of this Organizer's events
     * based on ID, and add available menu options
     *
     * @param username the user name of this organizer
     * @param password the password of this organizer
     * @param ID the unique ID of this organizer
     */
    public Organizer(String username, String password, int ID, String name) {
        super(username, password, ID, name);
        this.eventOptions.add("Sign up for an event");
        this.eventOptions.add("Cancel sign up for an event");
        this.eventOptions.add("Organize event");
        this.eventOptions.add("Cancel an event");
        this.menuOptions.add("Create a new user account");

        this.messageOptions.add("Message all speakers");
        this.messageOptions.add("Message a speaker");
        this.messageOptions.add("Message an attendee");
        this.messageOptions.add("Message all attendees");
        this.messageOptions.add("Message all attendees of an event");

    }

    @Override
    public String getType(){ return type; }
}
