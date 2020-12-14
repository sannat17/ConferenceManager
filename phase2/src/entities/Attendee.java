package entities;


/** An attendee user */
public class Attendee extends User{

    private String type = "attendee";

    /**
     * Create a new Attendee
     *
     * @param username the user name of this attendee
     * @param password the password of this attendee
     * @param ID the unique ID of this attendee
     */
    public Attendee(String username, String password, int ID, String firstName, String dietaryRestrictions, String accessibilityRequirements) {
        super(username, password, ID, firstName, dietaryRestrictions, accessibilityRequirements);
        this.eventOptions.add("Sign up for an event");
        this.eventOptions.add("Cancel sign up for an event");
        this.messageOptions.add("Message an attendee");
        this.messageOptions.add("Message a speaker");

    }

    @Override
    public String getType() {
        return type;
    }
}
