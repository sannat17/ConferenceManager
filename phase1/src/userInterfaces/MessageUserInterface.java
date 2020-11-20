package userInterfaces;

import entities.User;

import presenters.MessagePresenter;

import java.util.Scanner;

import static controllers.MessageController.*;

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
                    System.out.println("Please enter your ID:");
                    int senderIDSpecificEvent = s.nextInt();
                    System.out.println("Please enter the ID of the talk you " +
                            "would like to message the attendees of:");
                    int eventID = s.nextInt();
                    String contentSpecificEvent = getMessageContent();
                    //method to message all the attendees of a talk
                    messageAllAttendeesOfTalk(senderIDSpecificEvent, eventID, contentSpecificEvent);
                    break;
                case "Respond to an attendee":
                case "Message a specific speaker" : //for organizers
                case "Message an attendee": //for attendees
                case "Message a specific attendee":
                case "Message a speaker":     //for attendee
                    System.out.println("Please enter your ID");
                    int senderID = s.nextInt();
                    System.out.println("Please enter the receiver's ID");
                    int receiverID = s.nextInt();
                    System.out.println("Please enter the ID of the message you're replying to " +
                            "or enter -1 if you're starting a new message");
                    int replyToID = s.nextInt();
                    String content = getMessageContent();

                    createNewMessage(senderID, receiverID, replyToID, content);
                    break;
                case "Message all speakers":
                    System.out.println("Please enter your ID");
                    int senderIDAllSpeakers= s.nextInt();
                    String contentAllSpeakers = getMessageContent();
                    messageAllSpeakers(senderIDAllSpeakers, contentAllSpeakers);
                    break;
                case "Message all attendees":
                    System.out.println("Please enter your ID");
                    int senderIDAllAttendees = s.nextInt();
                    String contentAllAttendees = getMessageContent();
                    messageAllAttendees(senderIDAllAttendees, contentAllAttendees);
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



