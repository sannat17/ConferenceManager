package userInterfaces;

import useCases.UserManager;

import java.util.Scanner;

public class UserCreationUserInterface {
    public boolean loadUserCreation(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the new users Username");
        String username = s.nextLine();
        System.out.println("Please enter the new users Password");
        String password = s.nextLine();
        System.out.println("Please enter the new users Name");
        String name = s.nextLine();
        System.out.println("Please enter the new users type (organizer, speaker, attendee");
        String type = s.nextLine();
        return UserManager.makeNewUser(username, password, name, type);
    }
}
