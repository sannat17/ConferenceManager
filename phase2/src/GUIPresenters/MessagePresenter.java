package GUIPresenters;

import GUI.mainView;
import controllers.MessageController;
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
            case "Message all attendees":
                mainView.toMessageAllUsersPanel("attendee");
                break;

            case "Message all speakers":
                mainView.toMessageAllUsersPanel("speaker");
                break;

            case "Message all attendees of an event":
                break;

            case "Message all attendees of the talk":
                break;
        }
    }

    public static void sendMessage(String receiver, String content) {
        MessageManager.makeNewMessage(UserManager.giveIDOfUser(AuthManager.getLoggedInUser()),
                UserManager.giveIDOfUsername(receiver), -1, content);
    }

    public static void sendMessageToAllType(String type, String content){
        ArrayList<String> users = UserTypeManager.getUsersByType(type);
        for (String u: users){
            sendMessage(u, content);
        }
    }

    public static HashMap<Integer, String> getUsernamesFromInbox(){
        HashMap<Integer, String> userHash = new HashMap<>();
        ArrayList<Message> messages = MessageManager.getAllReceivedMessages(
                UserManager.giveIDOfUser(AuthManager.getLoggedInUser()));
        String ID = "";
        for (Message m: messages){
            if (m.getStatusID() == 0 || m.getStatusID() == 1){
                ID = Integer.toString(MessageManager.getIDOfMessage(m));
                userHash.put(MessageManager.getIDOfMessage(m),
                        "ID: " + ID + " " + UserManager.giveUsername(UserManager.getUser(MessageManager.getSendersID(MessageManager.getIDOfMessage(m)))));
            }

        }
        return userHash;
    }

    public static HashMap<Integer, String> getUsernamesFromArchived(){
        HashMap<Integer, String> userHash = new HashMap<>();
        ArrayList<Message> messages = MessageManager.getAllReceivedMessages(
                UserManager.giveIDOfUser(AuthManager.getLoggedInUser()));
        String ID = "";
        for (Message m: messages){
            if (m.getStatusID() == -2){
                ID = Integer.toString(MessageManager.getIDOfMessage(m));
                userHash.put(MessageManager.getIDOfMessage(m),
                        "ID: " + ID + " " + UserManager.giveUsername(UserManager.getUser(MessageManager.getSendersID(MessageManager.getIDOfMessage(m)))));
            }

        }
        return userHash;
    }



    public static String getMessageStatus(int ID){
        if(MessageStatusManager.getStatusOfMessage(ID) == 0) {
            return "Unread";
        } else if (MessageStatusManager.getStatusOfMessage(ID) == 1){
            return "Read";
        } else if (MessageStatusManager.getStatusOfMessage(ID) == -2){
            return "Archived";
        }
        return "";
    }

    public static void deleteMessage(int ID){MessageController.deleteMessage(ID);}

    public static void markArchived(int ID){MessageStatusManager.markMessageAsArchived(ID);}

    public static void markRead(int ID) {MessageStatusManager.markMessageAsRead(ID);}

    public static void markUnread(int ID){MessageStatusManager.markMessageAsUnread(ID);}

    public static String getMessageContent(int ID){return MessageManager.getContent(ID);}

    public static String[] messageOptions(){
        return UserManager.getMessageOptionsList(AuthManager.getLoggedInUser());
    }

    public static String[] usersUsernames(String type) {
        ArrayList<String> users = UserTypeManager.getUsersByType(type);
        if(users.contains(UserManager.giveUsername(AuthManager.getLoggedInUser()))){
            users.remove(UserManager.giveUsername(AuthManager.getLoggedInUser()));
        }
        return users.toArray(new String[0]);
    }
}
