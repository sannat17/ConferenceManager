package userInterfaces;

import controllers.MenuController;
import entities.User;
import presenters.MenuPresenter;

import java.util.Scanner;
import java.util.ArrayList;

/** A user interface for getting the message content from the sender */

public class MessageInterface {

    /**
     * Create a new MessageInterface
     */
    public static String getMessageChoice() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter message option:");
        return s.nextLine();
    }

    /**
     * Load the message interface
     */
    //public static void loadMessageMenu(User user) {
    //    System.out.println(MessagePresenter.formatOptions(user.getMenuOptions())); //retrieve menu options from current user
    //}


    /**
     * Get message content from the user
     */
    public static String getMessageContent() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the message content:");
        return s.nextLine();
        }

}



