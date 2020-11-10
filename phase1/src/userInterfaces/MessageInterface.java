package userInterfaces;

import controllers.MenuInput;
import controllers.MessageInput;
import presenters.MenuPresenter;

import java.util.ArrayList;
/** A user interface for getting the message content from the sender */

public class MessageInterface {

    /**
     * Create a new MessageInterface
     */
    public MessageInterface(){}

    public static void main() {

        System.out.println("Please enter the message content:");

        MessageInput.getMessageContent();   //Calling the controller class to get the input
    }
}
