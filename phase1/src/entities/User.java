package entities;

import java.util.ArrayList;

/** An abstract user to be extended */
public abstract class User {
    //TODO: Add a "name" attribute to the user

    /** The unique ID of this user */
    private int userID;
    /** The username of this user */
    private String username;
    /** The password of this user */
    private String password;
    /** The list of menu options available to this user */
    public ArrayList<String> menuOptions;

    /**
     * Create a new User and generate its base available menu options
     *
     * @param username the username of this user
     * @param password the password of this user
     * @param ID the unique ID of this user
     */
    public User(String username, String password, int ID) {
        this.userID = ID;
        this.username = username;
        this.password = password;

        this.menuOptions.add("messages");
        this.menuOptions.add("contacts");
        this.menuOptions.add("schedule");
        this.menuOptions.add("events");
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

}
