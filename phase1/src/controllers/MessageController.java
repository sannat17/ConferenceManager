package controllers;

import entities.Event;
import entities.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static useCases.MessageManager.makeMessage;
import static useCases.MessageManager.makeNewMessage;

/** A message controller which handles user input for message content */
public class MessageController {

    public static HashMap<Integer, ArrayList<Message>> presenterMessageHashMap;

    public static void replyOrNewMessage(){
        Scanner s = new Scanner(System.in);
        System.out.println("Would you like to reply to a message or start a new one?(Type true if reply)");
        boolean reply = s.nextBoolean(); //decides whether sender is replying or starting new message
        if (reply){
            System.out.println("Who are you replying to?");
            int receiverID = s.nextInt(); //gets id of the receiver
            Message messageRepliedTo = presenterMessageHashMap.get(receiverID).
                    get(presenterMessageHashMap.get(receiverID).size() - 1);
            //gets the last message the receiver has sent
            String content = getContent();
            makeNewMessage(messageRepliedTo.getReceiverID(), receiverID,
                    messageRepliedTo.getMessageID(), content);
        }
        else{
            System.out.println("Enter your ID:");
            int senderID = s.nextInt();
            System.out.println("Who are you sending a message to?");
            int receiverID = s.nextInt();
            String content = getContent();
            makeNewMessage(senderID, receiverID, -1, content); //-1 because it isn't a reply

        }
    }
    public static String getContent(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your message:");
        return s.nextLine();
    }

}
