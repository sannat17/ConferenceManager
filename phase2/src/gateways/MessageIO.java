package gateways;

import useCases.MessageManager;

import java.util.ArrayList;

public class MessageIO extends AbstractIO {
    private static final String delimiter = Character.toString((char) 31);

    /**
     * reads in messages file and passes message data to MessageManager
     */
    public static void readFile() {
        String dir = "./src/data/messages.txt";

        ArrayList<String> data = read(dir);
        data.forEach((String value) -> {
            String[] user = value.split(delimiter);
            int senderID = Integer.parseInt(user[0]);
            int statusID = Integer.parseInt(user[1]);
            int receiverID = Integer.parseInt(user[2]);
            int messageID = Integer.parseInt(user[3]);
            int replyToID = Integer.parseInt(user[4]);
            String messageContent = user[5];
            MessageManager.loadMessage(senderID, statusID, receiverID, messageID, replyToID, messageContent);
        });
    }

    /**
     * writes all user data from MessageManager to file
     */
    public static void writeFile(){
        String dir = "./src/data/messages.txt";
        ArrayList<String> info = MessageManager.getAllMessageInfo();
        write(dir, info);
    }
}
