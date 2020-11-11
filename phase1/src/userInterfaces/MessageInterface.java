package userInterfaces;

import controllers.MenuController;
import presenters.MenuPresenter;

import java.util.Scanner;
import java.util.ArrayList;

/** A user interface for getting the message content from the sender */

public class MessageInterface {

    /**
     * Create a new MessageInterface
     */
    public MessageInterface(){}

    public static String getMessageContent() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the message content:");
        return s.nextLine();
        }

}


