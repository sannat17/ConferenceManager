package useCases;
import entities.*;

import java.util.ArrayList;

public class UserTypeManager {

    /**
     * Get an arraylist of all the usernames of Users in the system that match the given type.
     *
     * @param type : the type of the user you want
     * @return an arraylist of usernames (Strings) of all the users that match the input type
     */
    public static ArrayList<String> getUsersByType(String type) {

        type = type.toLowerCase();

        ArrayList<String> to_return = new ArrayList<>();

        for (User u: UserManager.getAllUsers()){
            if (u.getType().equals(type)) {
                to_return.add(u.getUsername());
            }
        }

        return to_return;
    }

    /**
     * Gives the type of User by username
     *
     * @param username username of the User
     * @return a String that is the type of the User with given username
     */
    public static String getTypeByUsername(String username) {
        int userID = UserManager.giveIDOfUsername(username);
        return UserManager.getUser(userID).getType();
    }
}
