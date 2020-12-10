package controllers;

import entities.*;
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
     * An organizer can message all the speakers
     * @param senderUsername - username of sender
     * @param content - content of message
     */
    public static void messageAllSpeakers(String senderUsername, String content){
        int senderID = giveIDOfUsername(senderUsername);
        for (User i : UserManager.getAllUsers()) { //goes through each User one by one
                                        //from UserManager
            if (i instanceof Speaker) { //if the current user is an instance of Speaker
                MessageManager.makeNewMessage(senderID, i.getUserID(),
                        -1, content);
//                create the message with no reply
            }
        }
    }

    /**
     * An organizer can message all the attendees
     * @param senderUsername - username of sender
     * @param content - content of message
     */
    public static void messageAllAttendees(String senderUsername, String content){
        int senderID = giveIDOfUsername(senderUsername);
        for (User i : UserManager.getAllUsers()) {//goes through each User one by one
                                        //from UserManager
            if (i instanceof Attendee) { //if the current user is an instance of Attendee
                MessageManager.makeNewMessage(senderID, i.getUserID(),
                        -1, content);
//                create a message with no reply
            }
        }
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

    public static void markAsArchived(int messageID) {

        MessageStatusManager.markMessageAsArchived(messageID);

    }

    public static void markAsUnArchive(int messageID) {
        MessageStatusManager.markMessageAsUnArchived(messageID);
    }

    public static void deleteMessage(int ID) {
        MessageManager.removeMessage(ID);
    }

//    public static void deleteMessage(Message message) {
//
////      Calls the deleteReceivedMessage function from the MessageManager to set the statusID to -1 ie: deleted!
//        MessageStatusManager.deleteReceivedMessage(message.getMessageID());
//
////      Adds the deleted messages to the deleted messages list for the presenter to present the list.
//        MessageStatusManager.getAllDeletedMessages(message.getReceiverID()).add(message);
//    }
}
