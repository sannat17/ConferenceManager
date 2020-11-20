package controllers;

//import entities.Event;
import entities.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static useCases.MessageManager.makeMessage;
import static useCases.MessageManager.makeNewMessage;

/** A message controller which handles user input for message content */
public class MessageController {

    public static HashMap<Integer, ArrayList<Message>> presenterMessageHashMap;

    /**
     * Call this method anytime a message needs to be created
    the method determines whether the message is new or a reply and creates a
    Message object accordingly
    @param reply - determines whether the message created is a reply or not
    @param receiverID - the ID of the receiver
    @param senderID - the ID of the sender
    @param replyToID - the ID of the message to which we are replying (if applicable)
    @param content - the content of the message
    */

    public static void replyOrNewMessage(boolean reply, int receiverID, int senderID,
                                         int replyToID, String content){
        if (reply){
            makeNewMessage(senderID, receiverID, replyToID, content);
            //make a message with the given input
        }
        else{
            makeNewMessage(senderID, receiverID, -1, content);
            //-1 because it isn't a reply
        }
    }

}
