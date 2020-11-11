package userInterfaces;


import entities.User;

import presenters.MessagePresenter;

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
    public static void loadMessageMenu(User user) {
        System.out.println(MessagePresenter.formatOptions(user.getMessageOptions())); //retrieve message options from current user
    }

    /**
     * Display all messages sent or recieved by this user
     */
    public static void displayMessages(User user) {
        //will call the message manager method to display all messages in order; tab(\t) for replies
    }

    /**
     * Get message content from the user
     */
    public static String getMessageContent() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the message content:");
        return s.nextLine();
        }

}



