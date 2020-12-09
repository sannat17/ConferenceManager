package useCases;

import entities.Message;

import java.util.ArrayList;

public class MessageStatusManager {

//    public static void deleteReceivedMessage(int ID) {
//
//        for (Message message: MessageManager.getAllMessages()) {
//            if (message.getMessageID() == ID) {
//                message.setStatusID(-1);
//            }
//        }
//    }

//    public static void undoDeleteMessage(int ID) {
//
//        for (Message message: MessageManager.getAllMessages()) {
//            if (message.getMessageID() == ID) {
//                message.setStatusID(0);
//            }
//        }
//    }
//
//    public static ArrayList<Message> getAllDeletedMessages(int ID) {
//
//        ArrayList<Message> to_return = new ArrayList<>();
//        for (Message m : MessageManager.getAllMessages()) {
//            if (m.getReceiverID() == ID) {
//                if (m.getStatusID() == -1) {
//                    to_return.add(m);
//                }
//            }
//
//        } return to_return;
//    }

    //*****************************************************************************************************************
    public static void markMessageAsArchived(int MessageID) {

        MessageManager.getMessage(MessageID).setStatusID(-2);
    }

    public static void markMessageAsUnread(int MessageID) {

       MessageManager.getMessage(MessageID).setStatusID(0);
    }

    public static void markMessageAsRead(int MessageID) {
        MessageManager.getMessage(MessageID).setStatusID(1);
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
