package useCases;

import entities.Message;

import java.util.ArrayList;

public class MessageStatusManager {


    public static int getStatusOfMessage(int MessageID){
        return MessageManager.getMessage(MessageID).getStatusID();
    }

    public static void markMessageAsArchived(int MessageID) {

        MessageManager.getMessage(MessageID).setStatusID(-2);
    }

    public static void markMessageAsUnArchived(int MessageID) {

        MessageManager.getMessage(MessageID).setStatusID(1);
    }

    public static void markMessageAsUnread(int MessageID) {

       MessageManager.getMessage(MessageID).setStatusID(0);
    }

    public static void markMessageAsRead(int MessageID) { MessageManager.getMessage(MessageID).setStatusID(1);
    }

    public static ArrayList<Message> getAllReceivedMessagesByStatus(int userID, int statusID) {

        ArrayList<Message> to_return = new ArrayList<>();
        for (Message m : MessageManager.getAllReceivedMessages(userID)) {
                if (m.getStatusID() == statusID) {
                    to_return.add(m);
                }

        }
        return to_return;
    }
}
