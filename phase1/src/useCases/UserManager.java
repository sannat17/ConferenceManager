package useCases;
import controllers.LoginSystem;
import java.io.*;
import java.util.*;
import entities.*;

/** Manages the user and allows them to login */
public class UserManager{

    private static HashMap<Integer, User> userHashMap;

    public static User getUser(int ID){
        return userHashMap.get(ID);
    }

    public static Boolean makeNewUser(String username, String password, String type){
        if (!(checkUsername(username))){
            return false;
        }
        int ID = getNextID();
        if (type.toLowerCase().equals("attendee")){
            Attendee a = new Attendee(username, password, ID);
            userHashMap.put(ID, a);
        }
        else if (type.toLowerCase().equals("organizer")){
            Organizer o = new Organizer(username, password, ID);
            userHashMap.put(ID, o);
        }
        else if (type.toLowerCase().equals("speaker")){
            Speaker s = new Speaker(username, password, ID);
            userHashMap.put(ID, s);
        }
        else{
            return false;
        }
        return true;

    }

    private static boolean checkUsername(String username){
        for (User u: userHashMap.values()){
            if (username.equals(u.getUsername())){
                System.out.println("This ID is already being used"); //im not sure if this can print in this method...
                return false;
            }
        }
        return true;
    }

    private static int getNextID(){
        int maxID = -1;
        for (Integer ID: userHashMap.keySet()){
            if(ID > maxID){
                maxID = ID;
            }
        }
        return (maxID + 1);
    }

    public static ArrayList<User> getAllUsers(){
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers.addAll(userHashMap.values());
        return allUsers;
    }
}