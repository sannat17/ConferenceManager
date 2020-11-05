package controllers;

import java.util.Scanner;

public class MessageInput {
    public static String getMessageContent() { //gets the message content from the user
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the message content:");
        return s.nextLine();
    }
}

