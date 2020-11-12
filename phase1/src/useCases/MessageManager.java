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
     * @param senderID
     * @param receiverID
     * @param messageID
     * @param replyToID
     * @param messageContent
     * @return
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
     * @param senderID
     * @param receiverID
     * @param replyToID
     * @param messageContent
     * @return
     */
    public static boolean makeNewMessage(int senderID, int receiverID, int replyToID, String messageContent) {

        int messageID = Collections.max(messageHashMap.keySet()) + 1;

        Message m = new Message(senderID, receiverID, messageID, replyToID, messageContent);

        messageHashMap.put(messageID, m);
        return true;
    }

    public static ArrayList<Message> getAllSentMessages(int ID) {

        ArrayList<Message> to_return = new ArrayList<>();
        for (Message m: messageHashMap.values()) {
            if (m.getSenderID() == ID) {
                to_return.add(m);
            }
        }
        return to_return;
    }

    public static ArrayList<Message> getAllReceivedMessages(int ID) {

        ArrayList<Message> to_return = new ArrayList<>();
        for (Message m: messageHashMap.values()) {
            if (m.getReceiverID() == ID) {
                to_return.add(m);
            }
        }
        return to_return;
    }

    public static ArrayList<Message> getAllMessages() {
        return (ArrayList<Message>) messageHashMap.values();
    }

    public static ArrayList<String> getAllMessageInfo() {

        ArrayList<String> to_return = new ArrayList<>();

        for (Message m: messageHashMap.values()) {
            to_return.add(m.toString());
        }

        return to_return;
    }

}
