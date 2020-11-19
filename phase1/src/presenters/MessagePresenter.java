package presenters;

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
    public static String displayReceivedMessagesOfUser(User user){


        StringBuilder messagesOfUser = new StringBuilder();

        ArrayList<Message> allReceivedMessages = MessageManager.getAllReceivedMessages(user.getUserID());
        for (Message message : allReceivedMessages) {

            if (message.getReplyToID() == -1) {

                messagesOfUser.append(message.getMessageContent()).append("\n");
            } else {
                messagesOfUser.append(message.getMessageContent()).append("\n");
            }
        }

        return messagesOfUser.toString();
    }


    public String displayAllMessages() {

        ArrayList<String> messages = new ArrayList<>();

        Map<Integer, ArrayList<String>> presenterHashMap = new HashMap<>();


        for (Integer integer: MessageController.presenterMessageHashMap.keySet()) {

            for (Message message: MessageManager.getAllSentMessages(integer)) {

//              This appends all the strings of messages into a list
                messages.add(message.getMessageContent());
                presenterHashMap.put(integer, messages);
            }
        }

        for (Integer userID: presenterHashMap.keySet()) {

            String finalMessage = "These are all the messages sent by the user with ID"
                    + userID + formatOptions(presenterHashMap.get(userID));

        }
        return finalMessage;
    }
}
