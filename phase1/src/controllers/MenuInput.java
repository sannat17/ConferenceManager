package controllers;

import java.util.Scanner;

/** A controller class of which takes in menu decision from user */
public class MenuInput {

    /**
     * Create a new MenuInput
     */
    public MenuInput(){};

    /**
     * Retrieve a menu choice from the user and return true if valid
     *
     * @param choice the menu decision that the user makes
     */
    public static void getMenuChoice(String choice) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter menu option:");

        String menuOption = s.nextLine();
    }

    //messages - 1:1 messaging, contacts, schedule, events - sign up/cancel
    //messages - 1:1 messaging, 1:many messaging, contacts, schedule, events - organize event, sign up/cancel
}
