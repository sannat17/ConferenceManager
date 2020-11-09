package useCases;

import entities.Message;

import java.util.*;

public class MessageManager {

    private static HashMap<Integer, Message> listOfMessageIDs;

    public static Message getMessage(int ID) {
        return listOfMessageIDs.get(ID);
    }

    public static void makeNewMessage(int senderID, int receiverID, String messageContent) {
        Message m = new Message(senderID, receiverID, messageContent);
        int ID = listOfMessageIDs.size();
        listOfMessageIDs.put(ID, m);
    }

    public static void makeReplyMessage(){
        //TODO: Implement this once Reply functionality is added to Message entity
    }

    public static ArrayList<Message> getAllSentMessages(int ID) {

        ArrayList<Message> to_return = new ArrayList<>();
        for (Message m: listOfMessageIDs.values()) {
            if (m.getSenderID() == ID) {
                to_return.add(m);
            }
        }
        return to_return;
    }

    public static ArrayList<Message> getAllReceivedMessages(int ID) {

        ArrayList<Message> to_return = new ArrayList<>();
        for (Message m: listOfMessageIDs.values()) {
            if (m.getReceiverID() == ID) {
                to_return.add(m);
            }
        }
        return to_return;
    }

}
