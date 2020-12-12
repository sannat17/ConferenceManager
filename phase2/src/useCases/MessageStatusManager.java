package useCases;

import entities.Message;

import java.util.ArrayList;

/**
 * This class manages the status of the messages, and contains methods
 * that deal with manipulating the statusID of messages.
 */
public class MessageStatusManager {

    /**
     * This function gets the status of the message, the descriptors of the different statuses are given in the
     * Message entity.
     * @param MessageID The ID of the message
     * @return returns the int of the status of the message, ie: the statusID by calling the getter getStatusID().
     */
    public static int getStatusOfMessage(int MessageID){
        return MessageManager.getMessage(MessageID).getStatusID();
    }

    /**
     * This function marks the message as archived by setting the status of the Archived message as -2.
     * @param MessageID The ID of the message.
     */
    public static void markMessageAsArchived(int MessageID) {

        MessageManager.getMessage(MessageID).setStatusID(-2);
    }

    /**
     * This function marks the message as archived by setting the status of the Archived message as -2.
     * @param MessageID The ID of the message.
     */
    public static void markMessageAsUnArchived(int MessageID) {

        MessageManager.getMessage(MessageID).setStatusID(1);
    }

    /**
     * This function marks the message unread by setting the statusID of the message as 0.
     * @param MessageID The ID of the message.
     */
    public static void markMessageAsUnread(int MessageID) {

       MessageManager.getMessage(MessageID).setStatusID(0);
    }

    /**
     * This function marks the message as archived by setting the status of the Archived message as -2.
     * @param MessageID The ID of the message.
     */
    public static void markMessageAsRead(int MessageID) { MessageManager.getMessage(MessageID).setStatusID(1);
    }

    /**
     * This function gets all the received messages by the user according to the statusID.
     * @param statusID The statusID of the message.
     * @param userID The userID of the user.
     */
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
