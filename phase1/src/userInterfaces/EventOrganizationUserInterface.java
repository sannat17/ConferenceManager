package userInterfaces;

import entities.User;
import useCases.EventManager;

import java.time.LocalDateTime;
import java.util.Scanner;

/** User interface for organizing an event */
public class EventOrganizationUserInterface {

    /**
     * load event organization user interface
     *
     * @param user the user of which this user interface is loading for
     */
    public static void loadEventOrganization(User user) {
        Scanner u = new Scanner(System.in);
        System.out.println("Please enter the title of the event:");
        String title = u.nextLine();
        System.out.println("Please enter the year of the event:");
        String year = u.nextLine();
        System.out.println("Please enter the month of the event:");
        String month = u.nextLine();
        System.out.println("Please enter the day of the event:");
        String day = u.nextLine();
        System.out.println("Please enter the hour of the event in 24H format");
        String hour = u.nextLine();
        System.out.println("Please enter the minute mark of the event:");

        try {
            LocalDateTime eventDate = new LocalDateTime();
        } catch (ExceptionInInitializerError e) {
            System.out.println("Please enter a valid time");
            loadEventOrganization(user);
        }

        System.out.println("Please enter the room number of the event:");
        String roomNumber = u.nextLine();
        System.out.println("Please enter the ID of the speaker of the event:");
        String speakerID = u.nextLine();
        System.out.println("Please enter the ID of the organizer of the event:");
        String organizerID = u.nextLine();

        EventManager.makeNewEvent();
    }

}
