package presenters;
import java.util.*;
import useCases.UserManager;
import entities.Message;
import entities.User;
import useCases.MessageManager;

/** A message presenter that formats message options to display */
public class MessagePresenter {

    /**
     * Format and return the given options
     *
     * @param options the list of message options available to this User
     * @return the formatted string derived from the given options
     */
    public static String formatOptions(ArrayList<String> options) {
        StringBuilder formattedOptions = new StringBuilder();
        for (String option : options) {
            formattedOptions.append(option).append("\n");
        }
        return formattedOptions.toString();
    }

    /**
     * Format and return content of all the messages received by this user
     *
     * @param user the user whose messages you want to display
     * @return the formatted string with content of all the messages received by this user
     */
    public static StringBuilder displayReceivedMessagesOfUser(User user) {

        StringBuilder to_return = new StringBuilder();

        ArrayList<Message> allReceivedMessages = MessageManager.getAllReceivedMessages(user.getUserID());

        for (Message received : allReceivedMessages) {

//            This condition ensures that all the messages that are in the inbox are only displayed, ie:
//            this prevents to include the deleted/archived messages.
//            statusID == 0 are the messages that are unarchived/not-deleted

            if(received.getStatusID() == 0) {

                to_return.append("\nMessage from ").
                        append(UserManager.getUser(received.getSenderID()).getUsername()).
                        append(" with messageID ").
                        append(received.getMessageID()).
                        append(" : ").
                        append(received.getMessageContent()).
                        append("\n");

            }
        } return to_return;
    }

    public static StringBuilder displayDeletedMessages(User user) {

        StringBuilder to_return = new StringBuilder();

        ArrayList<Message> allDeletedMessages = MessageManager.getAllDeletedMessages(user.getUserID());

        for (Message deleted : allDeletedMessages) {
            to_return.append("These are the deleted message of the user with userID ").
                    append(user.getUserID()).append(" ").
                    append(deleted.getMessageContent());
        } return to_return;
    }


    public static StringBuilder displayArchivedMessages(User user) {

        StringBuilder to_return = new StringBuilder();

        ArrayList<Message> allArchivedMessages = MessageManager.getAllArchivedMessages(user.getUserID());

        for (Message archived : allArchivedMessages) {
            to_return.append("These are the archived messages of the user with userID ").
                    append(user.getUserID()).append(" ").
                    append(archived.getMessageContent());
        } return to_return;
    }

}



