package userInterfaces;

import entities.User;
import useCases.EventManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/** User interface for organizing an event */
public class EventOrganizationUserInterface {

    /**
     * load event organization user interface
     *
     * @param user the user of which this user interface is loading for
     */
    public static void loadEventOrganization(User user) {
        LocalDateTime eventDate = null;
        Scanner u = new Scanner(System.in);
        System.out.println("Please enter the title of the event:");
        String title = u.nextLine();
        System.out.println("Please enter the year,month and date and time of the event (dd-MMM-yyyy: HH:mm:ss): \n" +
                "For Example, November 20th 2020 at 6:35:05PM will be written as 20-Nov-2020 18:35:05");
        String dateTime = u.nextLine();

        try {
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
            eventDate = LocalDateTime.parse(dateTime, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Please enter a valid format");
            //loadEventOrganization(user);
        }

        System.out.println("Please enter the room number of the event:");
        String roomNumber = u.nextLine();
        System.out.println("Please enter the ID of the speaker of the event:");
        String speakerID = u.nextLine();
        System.out.println("Please enter the ID of the organizer of the event:");
        String organizerID = u.nextLine();

        EventManager.makeNewEvent(title, eventDate, Integer.parseInt(roomNumber), Integer.parseInt(speakerID), Integer.parseInt(organizerID));
    }

}
