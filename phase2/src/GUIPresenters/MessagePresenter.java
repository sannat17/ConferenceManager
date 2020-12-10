package GUIPresenters;

import GUI.mainView;
import entities.Message;
import entities.Speaker;
import entities.User;
import useCases.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MessagePresenter {

    public static void nextMessagePanel(String messagePanelChoice){
        System.out.println(messagePanelChoice);
        switch (messagePanelChoice){
            case "Display all messages":
                mainView.toPanel("Display Messages");
                break;
            case "Message a speaker":
                mainView.toMessageUserPanel("speaker");
                break;
            case "Message an attendee":
                mainView.toMessageUserPanel("attendee");
                break;

        }
    }

    public static void sendMessage(String receiver, String content) {
        MessageManager.makeNewMessage(UserManager.giveIDOfUser(AuthManager.getLoggedInUser()),
                UserManager.giveIDOfUsername(receiver), -1, content);
    }

    public static HashMap<Integer, String> messageUsernamnes(){
        HashMap<Integer, String> userHash = new HashMap<>();
        ArrayList<Message> messages = MessageManager.getAllReceivedMessages(
                UserManager.giveIDOfUser(AuthManager.getLoggedInUser()));
        String ID = "";
        for (Message m: messages){
            String status = "";
            if (m.getStatusID() == 0 || m.getStatusID() == 1){
                ID = Integer.toString(m.getMessageID());
                if (m.getStatusID() == 0) {
                    status = " - Unread";
                }
                userHash.put(MessageManager.getIDOfMessage(m),
                        "ID: " + ID + " " + UserManager.giveUsername(UserManager.getUser(MessageManager.getSendersID(MessageManager.getIDOfMessage(m)))) + status);
            }

        }
        return userHash;
    }

    public static void markRead(int ID) {MessageStatusManager.markMessageAsRead(ID);}

    public static String getMessageContent(int ID){return MessageManager.getContent(ID);}

    public static String[] messageOptions(){
        return UserManager.getMessageOptionsList(AuthManager.getLoggedInUser());
    }

    public static String[] usersUsernames(String type) {return UserTypeManager.getUsersByType(type).toArray(new String[0]);}
}
