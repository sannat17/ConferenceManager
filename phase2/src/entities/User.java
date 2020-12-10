package entities;

import java.util.ArrayList;

/** An abstract user to be extended */
public abstract class User {
    /** The unique ID of this user */
    private int userID;
    /** The username of this user */
    private String username;
    /** The password of this user */
    private String password;
    /** The list of menu options available to this user */
    public ArrayList<String> menuOptions = new ArrayList<>();
    /** The first name of this user */
    public String firstName;
    /** The list of message options available to this user */
    public ArrayList<String> messageOptions = new ArrayList<>();
    /** The list of event options available to this user */
    public ArrayList<String> eventOptions = new ArrayList<>();
    /** The dietary restrictions of this user */
    private String dietaryRestrictions;
    /** The accessbility requirements of this user */
    private String accessibilityRequirements;
    /** The status of the dietary restrictions of this user */
    private String dietaryRestrictionsStatus;
    /** The status of the accessibility requirements of this user */
    private String accessibilityRequirementsStatus;
    /**
     * Create a new User and generate its base available menu options
     *
     * @param username the username of this user
     * @param password the password of this user
     * @param ID the unique ID of this user
     * @param firstName the first name of the user.
     */
    public User(String username, String password, int ID, String firstName, String dietaryRestrictions, String accessibilityRequirements) {
        this.userID = ID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.dietaryRestrictions = dietaryRestrictions;
        this.accessibilityRequirements = accessibilityRequirements;
        this.dietaryRestrictionsStatus = "pending";
        this.accessibilityRequirementsStatus = "pending";
        this.menuOptions.add("Messages");
        this.menuOptions.add("Events");
        this.eventOptions.add("View Your Events");
        this.eventOptions.add("Print Events");
        this.messageOptions.add("Display all messages");
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }


    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        if(this.dietaryRestrictions.equals("")){
            this.dietaryRestrictions = "\"\"";
        }
        if(this.accessibilityRequirements.equals("")){
            this.accessibilityRequirements = "\"\"";
        }
        return  userID + delimiter + username + delimiter + password + delimiter + firstName + delimiter + getType() +
                delimiter + this.dietaryRestrictions + delimiter + this.accessibilityRequirements;
    }

    /**
     * Return list of available menu options of this user
     *
     * @return list of available menu options
     */
    public ArrayList<String> getMenuOptions() {
        return this.menuOptions;
    }

    /**
     * Return list of available message options of this user
     *
     * @return list of available message options
     */
    public ArrayList<String> getMessageOptions() {
        return this.messageOptions;
    }

    /**
     * Return list of available event options of this user
     *
     * @return list of available event options
     */
    public ArrayList<String> getEventOptions() {
        return this.eventOptions;
    }

    public abstract String getType();

    /**
     * Return the dietary restrictions of this user
     *
     * @return a string of which describes this user's dietary restrictions
     */
    public String getDietaryRestrictions() {
        return this.dietaryRestrictions;
    }

    /**
     * Return the accessibility requirements of this user
     *
     * @return a string of which describes this user's accessbility requirements
     */
    public String getAccessibilityRequirements() {
        return this.accessibilityRequirements;
    }

    /**
     * Return the status of dietary restrictions of this user
     *
     * @return a string of which describes this user's dietary restrictions's status
     */
    public String getDietaryRestrictionsStatus() {
        return this.dietaryRestrictionsStatus;
    }

    /**
     * Return the status of accessibility requirements of this user
     *
     * @return a string of which describes this user's accessbility requirements's status
     */
    public String getAccessibilityRequirementsStatus() {
        return this.accessibilityRequirementsStatus;
    }

    /**
     * Set the dietary restriction status of a user
     *
     * @param status the string of which represents the new status
     */
    public void setDietaryRestrictionStatus(String status) {
        this.dietaryRestrictionsStatus = status;
    }

    /**
     * Set the accessibility requirement status of a user
     *
     * @param status the string of which represents the new status
     */
    public void setAccessibilityRequirementStatus(String status) {
        this.accessibilityRequirementsStatus = status;
    }
}
