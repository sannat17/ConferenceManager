package useCases;

import entities.Message;

import java.util.*;

public class MessageManager {

    private static HashMap<Integer, Message> messageHashMap = new HashMap<>();

    public static Message getMessage(int ID) {
        return messageHashMap.get(ID);
    }

    public static boolean makeMessage(int senderID, int receiverID, int messageID, int replyToID, String messageContent) {

        if (messageHashMap.containsKey(messageID)) {return false;}

        Message m = new Message(senderID, receiverID, messageID, replyToID, messageContent);

        messageHashMap.put(messageID, m);
        return true;
    }

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

}
