package useCases;
import java.util.*;
import entities.*;

/** A user manager*/
public class UserManager{

    /** A hashmap where the key is the ID of a user and the value is the object of the user with that ID*/
    private static HashMap<Integer, User> userHashMap = new HashMap<>();

    /** Returns the user object corresponding to an ID
     *
     * @param ID The ID of the user wanted
     * @return the User object with a specified ID
     */
    public static User getUser(int ID){
        return userHashMap.get(ID);
    }

    /** Creates a new User and adds it to the userHashMap
     *
     * @param ID The ID of the user being created
     * @param username The username of the user being created
     * @param password The password of the user being created
     * @param name The name of the user being created
     * @param type The type of the user (Attendee, Organizer, Speaker)
     * @return A boolean with true if the User was successfully created and false if it wasn't
     */
    public static Boolean makeUser(Integer ID, String username, String password, String name, String type){
        if (!(checkUsername(username))){
            return false;
        }
        if(!(checkID(ID))){
            return false;
        }
        if (type.toLowerCase().equals("attendee")){
            Attendee a = new Attendee(username, password, ID, name);
            userHashMap.put(ID, a);
        }
        else if (type.toLowerCase().equals("organizer")){
            Organizer o = new Organizer(username, password, ID, name);
            userHashMap.put(ID, o);
        }
        else if (type.toLowerCase().equals("speaker")){
            Speaker s = new Speaker(username, password, ID, name);
            userHashMap.put(ID, s);
        }
        else{
            return false;
        }
        return true;
    }

    /** Creates a new User who does not already have an ID
     *
     * @param username The username of the user being created
     * @param password The password of the user being created
     * @param name The name of the user being created
     * @param type The type of the user (Attendee, Organizer, Speaker)
     * @return A boolean with true if the User was successfully created and false if it wasn't
     */
    public static Boolean makeNewUser(String username, String password, String name, String type){
        int ID = getNextID();
        return makeUser(ID, username, password, name, type);
    }

    /** Checks whether a certain username is already being used
     *
     * @param username The username that we want to check
     * @return Returns true if the username is not already being used and false if it is
     */
    private static boolean checkUsername(String username){
        for (User u: userHashMap.values()){
            if (username.equals(u.getUsername())){
                System.out.println("This Username is already being used"); //im not sure if this can print in this method...
                return false;
            }
        }
        return true;
    }

    /** Checks whether a certain ID is already being used
     *
     * @param ID The ID that we want to check
     * @return Returns true if the ID is not already being used and false if it is
     */
    private static boolean checkID(int ID){
        for (User u: userHashMap.values()){
            if (ID == u.getUserID()){
                System.out.println("This ID is already being used"); //im not sure if this can print in this method...
                return false;
            }
        }
        return true;
    }

    /** Gets the next usable ID for a user
     *
     * @return The maximum ID from all users plus 1
     */
    private static int getNextID(){
        int maxID = -1;
        for (Integer ID: userHashMap.keySet()){
            if(ID > maxID){
                maxID = ID;
            }
        }
        return (maxID + 1);
    }

    /** Returns a list of all the User objects
     *
     * @return a list of all the User objects*/
    public static ArrayList<User> getAllUsers(){
        ArrayList<User> allUsers = new ArrayList<>();
        if (!(userHashMap.isEmpty())){
            allUsers.addAll(userHashMap.values());
        }
        return allUsers;
    }

    /** Returns a list of all the Users information
     *
     * @return a list of all the Users information*/
    public static ArrayList<String> getAllUsersInfo(){
        ArrayList<String> allUsersInfo = new ArrayList<>();
        for (User u: userHashMap.values()){
            allUsersInfo.add(u.toString());
        }
        return allUsersInfo;
    }
}