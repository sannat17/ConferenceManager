package presenters;

import java.util.*;

import controllers.MessageController;
import entities.Message;
import useCases.MessageManager;

/** A message presenter that formats message options to display */
public class MessagePresenter {

    public static String finalMessage;

    /**
     * Format and return the given options
     * @param options the list of options
     * @return the formatted string derived from the given options
     */
    public static String formatOptions(ArrayList<String> options){
        StringBuilder formattedOptions = new StringBuilder();
        for (String option : options) {
            formattedOptions.append(option).append("\n");
        }
        return formattedOptions.toString();
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
