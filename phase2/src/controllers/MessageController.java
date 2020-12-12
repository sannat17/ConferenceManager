package controllers;

import useCases.MessageManager;
import useCases.MessageStatusManager;
import useCases.UserManager;

import java.util.ArrayList;

import static useCases.EventManager.getAttendingSpecificEvent;
import static useCases.EventManager.giveEventIDOfTitle;
import static useCases.UserManager.giveIDOfUsername;

/** A message controller which handles user input for message content */
public class MessageController {

    /**
     * Call this method anytime a message needs to be created
     * the method determines whether the message is new or a reply and creates a
     * Message object accordingly
     *
     * @param senderUsername - the username of the sender
     * @param receiverUsername - the username of the receiver
     * @param replyToID  - the ID of the message to which we are replying (if applicable)
     * @param content    - the content of the message
     */

    public static void createNewMessage(String senderUsername, String receiverUsername,
                                         int replyToID, String content) {
        int senderID = giveIDOfUsername(senderUsername);
        int receiverID = giveIDOfUsername(receiverUsername);
        MessageManager.makeNewMessage(senderID, receiverID, replyToID, content);
    }

    /**
     * Messages every attendee attending the event with EventID
     * @param senderUsername - username of the sender (the speaker)
     * @param eventID - ID of event
     * @param content - content of the message
     */
    public static void messageAllAttendeesOfTalk(String senderUsername, int eventID, String content){
//        int eventID = giveEventIDOfTitle(eventTitle);
        ArrayList<Integer> attendees = getAttendingSpecificEvent(eventID);
//        list of all attendeeIDs attending
        int senderID = giveIDOfUsername(senderUsername);

        for (Integer attendeeID: attendees){
            MessageManager.makeNewMessage(senderID, attendeeID, -1, content);
//            for every attendee, create message with no reply
//            if attendees is empty, no messages will be created
        }
    }

    /**
     * This function calls the method that marks the message as archived from the Manager.
     * @param messageID The ID of the message.
     */
    public static void markAsArchived(int messageID) {

        MessageStatusManager.markMessageAsArchived(messageID);

    }

    /**
     * This function calls the method that marks the message as unarchived.
     * @param messageID The ID of the message.
     */
    public static void markAsUnArchive(int messageID) {
        MessageStatusManager.markMessageAsUnArchived(messageID);
    }

    /**
     * This function deleted the message from the program, by calling the method removeMessage from the Manager.
     * @param ID The ID of the message.
     */
    public static void deleteMessage(int ID) {
        MessageManager.removeMessage(ID);
    }

}
