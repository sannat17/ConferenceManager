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
     * @param dietaryRestrictions the dietary restrictions of this user
     * @param accessibilityRequirements the accessibility requirements of this user
     * @return A boolean with true if the User was successfully created and false if it wasn't
     */
    public static Boolean loadUser(Integer ID, String username, String password, String name, String type, String dietaryRestrictions,
                                   String accessibilityRequirements){
        if (!(checkUsername(username))){
            return false;
        }
        if((userHashMap.containsKey(ID))){
            return false;
        }
        if (type.toLowerCase().equals("attendee")){
            Attendee a = new Attendee(username, password, ID, name, dietaryRestrictions, accessibilityRequirements);
            userHashMap.put(ID, a);
        }
        else if (type.toLowerCase().equals("organizer")){
            Organizer o = new Organizer(username, password, ID, name, dietaryRestrictions, accessibilityRequirements);
            userHashMap.put(ID, o);
        }
        else if (type.toLowerCase().equals("speaker")){
            Speaker s = new Speaker(username, password, ID, name, dietaryRestrictions, accessibilityRequirements);
            userHashMap.put(ID, s);
        }
        else if (type.toLowerCase().equals("vip")){
            VIP v = new VIP(username, password, ID, name, dietaryRestrictions, accessibilityRequirements);
            userHashMap.put(ID, v);
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
     * @param type The type of the user (Attendee, Organizer, Speaker, VIP)
     * @param accessibilityRequirements Accessibility requirements of this user
     * @param dietaryRestrictions Dietary restrictions of this user
     * @return A boolean with true if the User was successfully created and false if it wasn't
     */
    public static Boolean makeNewUser(String username, String password, String name, String type, String dietaryRestrictions,
                                      String accessibilityRequirements){
        int ID = getNextID();
        return loadUser(ID, username, password, name, type, dietaryRestrictions, accessibilityRequirements);
    }

    /** Checks whether a certain username is already being used
     *
     * @param username The username that we want to check
     * @return Returns true if the username is not already being used and false if it is
     */
    private static boolean checkUsername(String username){
        for (User u: userHashMap.values()){
            if (username.equals(u.getUsername())){
                return false;
            }
        }
        return true;
    }


    /** Returns the username of a certain user's ID
     *
     * @param ID The ID that we want to check
     * @return Returns the username of a certain user's ID
     */
    public static String getUsernameFromID(int ID){
        String username = "";
        for (User u: userHashMap.values()){
            if (ID == u.getUserID()){
                username = u.getUsername();
            }
        }
        return username;
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

    /**
     * Returns the ID of user with username
     * @param username
     * @return u.getUserID()
     */
    public static int giveIDOfUsername(String username){
        for(User u : getAllUsers()){
            if (u.getUsername().equals(username)){
                return u.getUserID();
            }
        }
        return -1;
    }

    /**
     * Returns the ID of user with username
     * @param u
     * @return u.getUserID()
     */
    public static int giveIDOfUser(User u){
        return u.getUserID();
    }

    public static String giveUsername(int userID){return getUser(userID).getUsername();}


    public static String[] getMenuOptionsList(int userID){
        return getUser(userID).getMenuOptions().toArray(new String[0]);
    }

    public static String[] getEventOptionsList(int userID){
        return getUser(userID).getEventOptions().toArray(new String[0]);
    }

    public static String[] getMessageOptionsList(int userID){
        return getUser(userID).getMessageOptions().toArray(new String[0]);
    }

    /**
     * Return a dictionary of userID's and their associated dietary restrictions
     *
     * @return a dictionary of userID's and their associated dietary restrictions
     */
    public static HashMap<Integer, String> getDietaryRestrictionsDict() {
        HashMap<Integer, String> dietaryRestrictionsDict = new HashMap<Integer, String>();
        for (int userID : userHashMap.keySet()) {
            dietaryRestrictionsDict.put(userID, userHashMap.get(userID).getDietaryRestrictions());
        }

        return dietaryRestrictionsDict;
    }

    /**
     * Return a dictionary of userID's and their associated accessibility requirements
     *
     * @return a dictionary of userID's and their associated accessibility requirements
     */
    public static HashMap<Integer, String> getAccessibilityRequirementsDict() {
        HashMap<Integer, String> accessibilityRequirementsDict = new HashMap<Integer, String>();
        for (int userID : userHashMap.keySet()) {
            accessibilityRequirementsDict.put(userID, userHashMap.get(userID).getAccessibilityRequirements());
        }

        return accessibilityRequirementsDict;
    }

    /**
     * Set the dietary restriction status of a user
     *
     * @param userID the id of the user
     * @param status the string of which represents the new status
     */
    public static void setDietaryRestrictionStatus(int userID, String status) {
        getUser(userID).setDietaryRestrictionStatus(status);
    }

    /**
     * Set the accessibility requirement status of a user
     *
     * @param userID the id of the user
     * @param status the string of which represents the new status
     */
    public static void setAccessibilityRequirementStatus(int userID, String status) {
        getUser(userID).setAccessibilityRequirementStatus(status);
    }
}
