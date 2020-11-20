import controllers.*;
import entities.*;
import gateways.*;
import useCases.*;
import userInterfaces.MenuUserInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //need to get all users and messages from files
        UserIO.readFile("./phase1/src/data/users.txt");
        EventIO.readFile("./phase1/src/data/events.txt");
        MessageIO.readFile("./phase1/src/data/messages.txt");

//        uncomment to try out event system
//        ArrayList a = new ArrayList<>();
//        a.add(new Integer(1));
//        a.add(new Integer(0));
//
//        EventManager.makeEvent(1, "how to cure PTSD from cs post", LocalDateTime.now(), 1,
//                1, 1, a);
//
//        EventManager.makeEvent(2, "waterloo is for clowns", LocalDateTime.now(), 2,
//                2, 1, a);
//
//        EventManager.makeEvent(3, "a is for alphabetical order testing", LocalDateTime.now(), 5,
//                1, 1, a);
        User loggedInUser = null;
        Scanner s = new Scanner(System.in);
        while(loggedInUser == null) {
            System.out.println("Please enter your Username:");
            String username = s.nextLine();
            System.out.println("Please enter your Password:");
            String password = s.nextLine();
            loggedInUser = LoginSystem.loginCheck(username, password);
            if (loggedInUser == null){
                System.out.println("Your username or password is incorrect. Please enter them again.");
            }
        }
        MenuUserInterface.loadMenu(loggedInUser);
    }
}
