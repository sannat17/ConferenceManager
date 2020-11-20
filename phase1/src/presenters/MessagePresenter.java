package presenters;

import java.lang.reflect.Array;
import java.util.*;

import controllers.MessageController;
import entities.Message;
import entities.User;
import useCases.MessageManager;

/** A message presenter that formats message options to display */
public class MessagePresenter {

    public static String finalMessage;

    /**
     * Format and return the given options
     * @param options the list of message options available to this User
     * @return the formatted string derived from the given options
     */
    public static String formatOptions(ArrayList<String> options){
        StringBuilder formattedOptions = new StringBuilder();
        for (String option : options) {
            formattedOptions.append(option).append("\n");
        }
        return formattedOptions.toString();
    }

    /**
     * Format and return content of all the messages received by this user
     * @param user the user whose messages you want to display
     * @return the formatted string with content of all the messages received by this user
     */
    public static String displayReceivedMessagesOfUser(User user) {


        StringBuilder to_return = new StringBuilder(user.firstName + "replied:");

        ArrayList<Message> allSentMessages = MessageManager.getAllSentMessages(user.getUserID());
        ArrayList<Message> allReceivedMessages = MessageManager.getAllReceivedMessages(user.getUserID());

        for (Message sent: allSentMessages) {
            for (Message replied: allReceivedMessages) {
                if (sent.getReplyToID() == -1) {
                    to_return.append("You sent:").append(sent).append("No one replied -_-");
                } else if (sent.getMessageID() == replied.getReplyToID()) {
                    to_return.append("You sent:").
                            append(sent).append("\n").
                            append(user.firstName).append("replied:").append(replied);
                }
            }
        } return to_return.toString();
    }
}
