package GUIPresenters;

import GUI.mainView;
import com.sun.corba.se.spi.ior.MakeImmutable;
import entities.Message;
import entities.Speaker;
import entities.User;
import useCases.MessageManager;
import useCases.UserManager;
import useCases.UserTypeManager;

import java.util.ArrayList;

public class MessagePresenter {

    public static void nextMessagePanel(String messagePanelChoice, User u){
        System.out.println(messagePanelChoice);
        switch (messagePanelChoice){
            case "Display all messages":
                mainView.toDisplayMessagesPanel(u);
                break;
            case "Message a speaker":
                mainView.toMessageUserPanel(u, "speaker");
                break;
            case "Message an attendee":
                mainView.toMessageUserPanel(u, "attendee");
                break;

        }
    }

    public static void sendMessage(User u, String receiver, String content) {
        MessageManager.makeNewMessage(UserManager.giveIDOfUser(u), UserManager.giveIDOfUsername(receiver), -1, content);
    }

    public static String[] messageUsernamnes(User u){
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<Message> messages = MessageManager.getAllReceivedMessages(UserManager.giveIDOfUser(u));
        for (Message m: messages){
            usernames.add(UserManager.giveUsername(UserManager.getUser(MessageManager.getSendersID(MessageManager.getIDOfMessage(m)))));
        }
        return usernames.toArray(new String[0]);
    }

    public static String[] messageOptions(User u){
        return UserManager.getMessageOptionsList(u);
    }

    public static String[] usersUsernames(String type) {return UserTypeManager.getUsersByType(type).toArray(new String[0]);}
}
