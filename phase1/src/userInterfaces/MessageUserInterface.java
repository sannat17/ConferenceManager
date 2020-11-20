package userInterfaces;



import entities.Attendee;
import entities.Organizer;
import entities.Speaker;
import entities.User;
import presenters.MessagePresenter;

import java.util.Scanner;

import static controllers.MessageController.*;

/** A user interface for getting the message content from the sender */

public class MessageUserInterface {

    // private variables that represent a arbitrary attendee, speaker and organizer
    private static Attendee a;
    private static Organizer o;
    private static Speaker s;

    /**
     * Create a new MessageInterface
     */
    public static String[] getMessageChoice() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Are you a Organizer, Speaker or Attendee?");
        String userType = scan.next().toLowerCase(); //gets the user's type

        System.out.println("Your options are:"); //lists the user's message options by type
        switch(userType){
            case "organizer":
                loadMessageMenu(o);
                break;
            case "speaker":
                loadMessageMenu(s);
                break;
            case "attendee":
                loadMessageMenu(a);
                break;
        }

        System.out.println("Enter message option:");
        String messageOption = scan.nextLine().toLowerCase();//finally, the sender selects an option

        return new String[]{userType, messageOption}; //returns an array with type and option,
                                                      //since the options depend on the type of the User
    }

    /**
     * Load the message interface
     */
    public static void loadMessageMenu(User user) {
        System.out.println(MessagePresenter.formatOptions(user.getMessageOptions())); //retrieve message options from current user
    }

    /**
     * Display all messages sent or received by this user
     */
    public static void displayMessages(User user) {
        System.out.println(MessagePresenter.displayReceivedMessagesOfUser(user)); //retrieve all messages for the current user
    }

    /**
     * Get message content from the user
     */
    public static String getMessageContent() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the message content:");
        return s.nextLine();
        }

    /**
     * Creates a message based on the user's selected option
      */
    public static void createMessage(){
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter your ID:");
        int senderID = s.nextInt();

        String[] choice = getMessageChoice(); //gets an array of the type of the user, and their message choice
        boolean messagingMultiplePeople = handleOptions(choice); //determines whether multiple people will need to be messaged

        String content = getMessageContent(); //gets content

        if (messagingMultiplePeople){
            handleMultiplePeople(choice[1], senderID, content); //calls a method that handles messaging multiple people
                                                                //based on the user's option
        }
        else{ //if a single person needs to be messaged, then...
            System.out.println("Who do you want to message?");
            int receiverID = s.nextInt(); //get the user's id...
            System.out.println("Enter the ID of the message you're replying to " +
                    "(enter -1 if you're starting a new message):");
            int replyToID = s.nextInt(); //get the replyID or -1 if it's a new message

            replyOrNewMessage(senderID, receiverID, replyToID, content); //pass it onto a method that creates new messages

        }

    }
}



