package controllers;

//import entities.Event;
import entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static useCases.MessageManager.makeMessage;
import static useCases.MessageManager.makeNewMessage;
import static useCases.UserManager.getAllUsers;

/** A message controller which handles user input for message content */
public class MessageController {

    /**
     * Call this method anytime a message needs to be created
     * the method determines whether the message is new or a reply and creates a
     * Message object accordingly
     *
     * @param receiverID - the ID of the receiver
     * @param senderID   - the ID of the sender
     * @param replyToID  - the ID of the message to which we are replying (if applicable)
     * @param content    - the content of the message
     */

    public static void replyOrNewMessage(int receiverID, int senderID,
                                         int replyToID, String content) {
        if (replyToID != -1) {
            makeNewMessage(senderID, receiverID, replyToID, content);
            //make a message with the given input
        } else {
            makeNewMessage(senderID, receiverID, -1, content);
            //-1 because it isn't a reply
        }
    }

    public static void messageAllSpeakers(int senderID, String content){
        for (User i : getAllUsers()) { //goes through each User one by one
            //from UserManager
            if (i instanceof Speaker) { //if the current user is an instance of Speaker
                makeNewMessage(senderID, i.getUserID(),
                        -1, content);
                //create the message with no reply
            }
        }
    }

    public static void messageAllAttendees(int senderID, String content){
        for (User i : getAllUsers()) {//goes through each User one by one
            //from UserManager
            if (i instanceof Attendee) { //if the current user is an instance of Attendee
                makeNewMessage(senderID, i.getUserID(),
                        -1, content);
                //create a message with no reply
            }
        }
    }

}