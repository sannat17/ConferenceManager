package entities;

public abstract class User {
    //TODO: Add a "name" attribute to the user

    private int userID;
    private String username;
    private String password;
    private String name;

    public User(String username, String password, int ID, String name) {
        this.userID = ID;
        this.username = username;
        this.password = password;
        this.name = name;
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
