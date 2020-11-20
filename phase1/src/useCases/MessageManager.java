package useCases;

import entities.Message;

import java.lang.reflect.Array;
import java.util.*;

public class MessageManager {

    private static HashMap<Integer, Message> messageHashMap = new HashMap<>();

    public static Message getMessage(int ID) {
        return messageHashMap.get(ID);
    }

    /** Make an instance of a message with a specified ID (eg. while loading from a file) and store it in messageHashMap
     *  to be indexed by its ID.
     *
     * @param senderID The ID of the sender of the message
     * @param receiverID The ID of the receiver of the message
     * @param messageID The ID of the message
     * @param replyToID The ID of the reply of the message
     * @param messageContent The ID of the sender of the message
     * @return returns the boolean true is the message is made!
     */
    public static boolean makeMessage(int senderID, int receiverID, int messageID, int replyToID, String messageContent) {

        if (messageHashMap.containsKey(messageID)) {return false;}

        Message m = new Message(senderID, receiverID, messageID, replyToID, messageContent);

        messageHashMap.put(messageID, m);
        return true;
    }

    /** Make an instance of a new message (eg. by a user) and automatically assign it a new unique ID. Store this in the
     * messageHashMap to be indexed by this new ID.
     *
     * @param senderID The ID of the sender of the message
     * @param receiverID The ID of the receiver of the message
     * @param replyToID The ID of the reply of the message
     * @param messageContent The ID of the sender of the message
     * @return returns true if a new message is made.
     */
    public static boolean makeNewMessage(int senderID, int receiverID, int replyToID, String messageContent) {

        int messageID;

        if (messageHashMap.keySet().isEmpty()){
            messageID = 0;
        } else{
            messageID = Collections.max(messageHashMap.keySet()) + 1;
        }

        Message m = new Message(senderID, receiverID, messageID, replyToID, messageContent);

        messageHashMap.put(messageID, m);
        return true;
    }

    /** Return all messages sent by user.
     *
     * @param ID The userID of the user
     * @return return an ArrayList of all the Message objects of messages sent by the user
     */
    public static ArrayList<Message> getAllSentMessages(int ID) {

        ArrayList<Message> to_return = new ArrayList<>();
        for (Message m: messageHashMap.values()) {
            if (m.getSenderID() == ID) {
                to_return.add(m);
            }
        }
        return to_return;
    }

    /** Return all messages received by user
     *
     * @param ID The userID of the user
     * @return return an ArrayList of all the Message objects of messages received by the user
     */
    public static ArrayList<Message> getAllReceivedMessages(int ID) {

        ArrayList<Message> to_return = new ArrayList<>();
        for (Message m: messageHashMap.values()) {
            if (m.getReceiverID() == ID) {
                to_return.add(m);
            }
        }
        return to_return;
    }

    /** Return all the messages in the system.
     *
     * @return return an ArrayList of all Message objects that exist on the system.
     */
    public static ArrayList<Message> getAllMessages() {
        return (ArrayList<Message>) messageHashMap.values();
    }

    /** Return all the information of the messages in the system
     *
     * @return return an ArrayList of the string representation of all Message objects that exist in the system.s
     */
    public static ArrayList<String> getAllMessageInfo() {

        ArrayList<String> to_return = new ArrayList<>();

        for (Message m: messageHashMap.values()) {
            to_return.add(m.toString());
        }

        return to_return;
    }

}
