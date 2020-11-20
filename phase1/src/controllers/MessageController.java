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

    /**
     * Takes in the array of type {userType, selectedMessageOption}.
     * If the option selected involves messaging multiple people at a time,
     * set multiplePeople = true, else set it to false
     *
     * @param options
     * @return boolean
     */
    public static boolean handleOptions(String[] options) {
        boolean multiplePeople;
        switch (options[0]) {
            case "organizer":
                multiplePeople = handleOrganizerOptions(options[1]);
                break; //method that decides whether an option should message multiple people or not,
            //for all Organizers
            case "speaker":
                multiplePeople = handleSpeakerOptions(options[1]);
                break;//method that decides whether an option should message multiple people or not,
            //for all Speakers
            case "attendee":
                multiplePeople = false;
                break;//set it to false because there is no message option
            // that messages multiple people for Attendee
            default:
                multiplePeople = false;
                //by default set to false
        }
        return multiplePeople;
    }

    /**
     * Method that decides whether an option includes messaging multiple people from
     * Organizer's options
     *
     * @param option
     * @return boolean
     */
    public static boolean handleOrganizerOptions(String option) {
        boolean multiplePeople;

        switch (option) {
            case "message all speakers":
                multiplePeople = true;
                break;
            case "message a specific speaker":
                multiplePeople = false;
                break;
            case "message all attendees":
                multiplePeople = true;
                break;
            case "message a specific attendee":
                multiplePeople = false;
                break;
            default:
                multiplePeople = false;
        }
        return multiplePeople;
    }

    /**
     * Method that decides whether an option includes messaging multiple people from
     * Speakers's options
     *
     * @param option
     * @return boolean
     */
    public static boolean handleSpeakerOptions(String option) {
        boolean multiplePeople;

        switch (option) {
            case "message all attendees of the talk":
                multiplePeople = true;
                break;
            case "respond to an attendee":
                multiplePeople = false;
                break;
            default:
                multiplePeople = false;
        }
        return multiplePeople;
    }

    /**
     * If multiple people need to be messaged, this method creates the messages
     * depending on the message option selected. SenderID and content are also passed so that
     * the message can be created
     *
     * @param option
     * @param senderID
     * @param content
     */
    public static void handleMultiplePeople(String option, int senderID, String content) {
        switch (option) {
            case "message all speakers":
                for (User i : getAllUsers()) { //goes through each User one by one
                    //from UserManager
                    if (i instanceof Speaker) { //if the current user is an instance of Speaker
                        makeNewMessage(senderID, i.getUserID(), -1, content);
                        //create the message with no reply
                    }
                }
                break;
            case "message all attendees":
                for (User i : getAllUsers()) {//goes through each User one by one
                    //from UserManager
                    if (i instanceof Attendee) { //if the current user is an instance of Attendee
                        makeNewMessage(senderID, i.getUserID(), -1, content);
                        //create a message with no reply
                    }
                }
                break;
            //case "message all attendees of the talk":

            //    for (){
            //       if (i instanceof ){
            //         makeNewMessage(senderID, i.getUserID(), -1, content)
            //   }
            //}
            //break;
        }
    }
}