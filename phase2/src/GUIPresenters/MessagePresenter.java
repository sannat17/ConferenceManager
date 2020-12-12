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
                mainView.toPanel("Message Attendees of An Event");
                break;

            case "Message all attendees of the talk":
                mainView.toPanel("Message Attendees of A Talk");
                break;
        }
    }

    public static void replyToMessage(String content, int replyID, String recipientName){
        mainView.toReplyPanel(content, replyID, recipientName);
    }

    public static void reply(int recieverID, int replyID, String content){
        MessageManager.makeNewMessage(AuthManager.getLoggedInUserID(), recieverID, replyID, content);
    }

    public static void sendMessage(String receiver, String content) {
        MessageManager.makeNewMessage(AuthManager.getLoggedInUserID(),
                UserManager.giveIDOfUsername(receiver), -1, content);
    }

    public static void sendMessageToAllType(String type, String content){
        ArrayList<String> users = UserTypeManager.getUsersByType(type);
        for (String u: users){
            sendMessage(u, content);
        }
    }

    public static void sendMessageToAllAttendeesOfTalk(int talkID, String content){
        ArrayList<Integer> attending = EventManager.getAttendingSpecificEvent(talkID);
        for (int i: attending){
            MessageManager.makeNewMessage(AuthManager.getLoggedInUserID(), i, -1, content);
        }
    }

    public static HashMap<Integer, String> getUsernamesFromInbox(){
        HashMap<Integer, String> userHash = new HashMap<>();
        ArrayList<Message> messages = MessageManager.getAllReceivedMessages(
                AuthManager.getLoggedInUserID());
        String ID = "";
        for (Message m: messages){
            if (m.getStatusID() == 0 || m.getStatusID() == 1){
                ID = Integer.toString(MessageManager.getIDOfMessage(m));
                userHash.put(MessageManager.getIDOfMessage(m),
                        "ID: " + ID + " " + UserManager.giveUsername(MessageManager.getSendersID(MessageManager.getIDOfMessage(m))));
            }

        }
        return userHash;
    }

    public static HashMap<Integer, String> getUsernamesFromArchived(){
        HashMap<Integer, String> userHash = new HashMap<>();
        ArrayList<Message> messages = MessageManager.getAllReceivedMessages(
                AuthManager.getLoggedInUserID());
        String ID = "";
        for (Message m: messages){
            if (m.getStatusID() == -2){
                ID = Integer.toString(MessageManager.getIDOfMessage(m));
                userHash.put(MessageManager.getIDOfMessage(m),
                        "ID: " + ID + " " + UserManager.giveUsername(MessageManager.getSendersID(MessageManager.getIDOfMessage(m))));
            }

        }
        return userHash;
    }

    public static String[] getTalksBySpeaker(){
        return EventManager.getAllEventsBySpeaker(AuthManager.getLoggedInUserID()).toArray(new String[0]);
    }

    public static String[] getAllTalks(){
        return EventManager.getAllEventsTitles().toArray(new String[0]);
    }

    public static int getIDOfTalkByTitle(String title){
        return EventManager.giveEventIDOfTitle(title);
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

    public static void markArchived(int ID){MessageController.markAsArchived(ID);}

    public static void markRead(int ID) {MessageStatusManager.markMessageAsRead(ID);}

    public static void markUnread(int ID){MessageStatusManager.markMessageAsUnread(ID);}

    public static String getMessageContent(int ID){return MessageManager.getContent(ID);}

    public static String[] messageOptions(){
        return UserManager.getMessageOptionsList(AuthManager.getLoggedInUserID());
    }

    public static String[] usersUsernames(String type) {
        ArrayList<String> users = UserTypeManager.getUsersByType(type);
        users.remove(UserManager.giveUsername(AuthManager.getLoggedInUserID()));
        return users.toArray(new String[0]);
    }

    public static int getUsersID(String name){
        return UserManager.giveIDOfUsername(name);
    }

    public static String getSendersUsername(int ID){
        return UserManager.getUsernameFromID(MessageManager.getSendersID(ID));
    }

    public static void createMessagePopUp(String message){
        mainView.createPopUp(message);
    }
}
