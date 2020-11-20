package userInterfaces;

import entities.User;
import useCases.UserManager;

import java.util.Scanner;
/** Gets information about a user that the Organizer wants to create*/
public class UserCreationUserInterface {
    /** Gets the information for the user from the Organizer
     *
     * @param user The current user
     */
    public static void loadUserCreation(User user){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the new users Username");
        String username = s.nextLine();
        System.out.println("Please enter the new users Password");
        String password = s.nextLine();
        System.out.println("Please enter the new users Name");
        String name = s.nextLine();
        String type = new String();
        Boolean trueType = false;
        while (!trueType) {
            System.out.println("Please enter the new users type (organizer, speaker, attendee)");
            type = s.nextLine().toLowerCase();
            if ((type.equals("organizer") || (type.equals("speaker") || (type.equals("attendee"))))){
                trueType = true;
            }
            else{
                System.out.println("Incorrect type entered");
            }
        }
        UserManager.makeNewUser(username, password, name, type);
        MenuUserInterface.loadMenu(user);
    }
}
