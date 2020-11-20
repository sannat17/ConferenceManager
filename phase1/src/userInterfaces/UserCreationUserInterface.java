package userInterfaces;

import useCases.UserManager;

import java.util.Scanner;
/** Gets information about a user that the Organizer wants to create*/
public class UserCreationUserInterface {
    /** Gets the information for the user from the Organizer
     *
     * @return A boolean with true if the user was successfully created or false if it wasn't*/
    public static boolean loadUserCreation(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the new users Username");
        String username = s.nextLine();
        System.out.println("Please enter the new users Password");
        String password = s.nextLine();
        System.out.println("Please enter the new users Name");
        String name = s.nextLine();
        System.out.println("Please enter the new users type (organizer, speaker, attendee");
        String type = s.nextLine();
        s.close();
        return UserManager.makeNewUser(username, password, name, type);
    }
}
