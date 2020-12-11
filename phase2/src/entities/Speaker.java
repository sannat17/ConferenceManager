package entities;

import java.util.ArrayList;

/** A speaker user that gives speeches */
public class Speaker extends User{

    private String type = "speaker";
    /**
     * Create a new Speaker
     *
     * @param username the user name of this speaker
     * @param password the password of this speaker
     * @param ID the unique ID of this speaker
     * @param accessibilityRequirements the accessibility requirements of this speaker
     * @param dietaryRestrictions the dietary restrictions of this speaker
     * @param firstName the first name of this speaker
     */
    public Speaker(String username, String password, int ID, String firstName, String dietaryRestrictions, String accessibilityRequirements) {
        super(username, password, ID, firstName, dietaryRestrictions, accessibilityRequirements);
        this.messageOptions.add("Message all attendees of the talk");
    }

    @Override
    public String getType() {
        return type;
    }
}
