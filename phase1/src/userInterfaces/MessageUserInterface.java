package userInterfaces;


import entities.User;

import presenters.MessagePresenter;

import java.util.Scanner;
import java.util.ArrayList;

/** A user interface for getting the message content from the sender */

public class MessageUserInterface {

    /**
     * Load the message interface
     */
    public static void loadMessageMenu(User user) {
        System.out.println(MessagePresenter.formatOptions(user.getMessageOptions())); //retrieve message options for the current user
        Scanner s = new Scanner(System.in);
        System.out.println("Enter message option:");

        String messageChoice = s.nextLine();
        if (user.getMessageOptions().contains(messageChoice)) {
            switch (messageChoice) {
                case "Go back to the previous screen":
                    MenuUserInterface.loadMenu(user);
                    break;
                case "Display all messages":
                    MessagePresenter.displayReceivedMessagesOfUser(user);
                    break;
                case "Message all attendees of the talk":
                    System.out.println("FUNCTIONALITY IN PROGRESS"); //waiting for controller to implement
                    break;
                case "Respond to an attendee":
                    System.out.println("FUNCTIONALITY IN PROGRESS"); //waiting for controller to implement
                    break;
                case "Message all speakers":
                    System.out.println("FUNCTIONALITY IN PROGRESS"); //waiting for controller to implement
                    break;
                case "Message a specific speaker" : //for organizers
                case "Message a speaker":     //for attendee
                    System.out.println("FUNCTIONALITY IN PROGRESS"); //waiting for controller to implement
                    break;
                case "Message all attendees":
                    System.out.println("FUNCTIONALITY IN PROGRESS"); //waiting for controller to implement
                    break;
                case "Message a specific attendee": //for organizers
                case "Message an attendee": //for attendees
                    //waiting for controller to implement
                    break;

            }
        } else {
            System.out.println("Menu option was invalid, please try again");
            loadMessageMenu(user);
        }}

    /**
     * Display all messages sent or received by this user
     */
    public static void displayMessages(User user) {
        System.out.println(MessagePresenter.displayReceivedMessagesOfUser(user)); //retrieve all messages received by the current user
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



