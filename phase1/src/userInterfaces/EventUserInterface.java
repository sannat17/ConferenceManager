package userInterfaces;

import com.sun.xml.internal.bind.v2.TODO;
import entities.User;
import presenters.EventPresenter;
import presenters.MenuPresenter;

import java.util.Scanner;

/** The user interface for events */
public class EventUserInterface {

    /**
     * Retrieve a event sorting choice from the user and return
     *
     * @return menu selection string based on user input
     */
    public static String getEventChoice() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter sorting option (Title, Time, Speaker):");

        System.out.println(EventPresenter.formatEvents(s.nextLine()));

        // allow for signup/cancellation to event
        // implement "go back" function
        return "Filler String";
    }

    /**
     * Load the event interface
     */
    public static void loadEventChoices() {
        System.out.println("View events by title \n View events by time \n View events by speaker");
    }

}
