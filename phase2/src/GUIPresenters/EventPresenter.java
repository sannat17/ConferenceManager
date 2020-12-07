package GUIPresenters;

import GUI.mainView;
import controllers.EventController;
import entities.Event;
import entities.User;
import presenters.EventSorter;
import useCases.EventManager;
import useCases.UserManager;

import java.util.ArrayList;

public class EventPresenter {

    public static void nextEventPanel(String eventPanelChoice, User u){
        switch (eventPanelChoice){
            case "View Your Events":
                mainView.toYourEventsPanel(u);
                break;
            case "Sign up for an event":
                mainView.toSignUpEventsPanel(u);
                break;
            case "Cancel sign up for an event":
                mainView.toCancelSignUpEventsPanel(u);
                break;
        }
    }

    public static String[] eventOptions(User u){
        return UserManager.getEventOptionsList(u);
    }

    /**
     * Format events based on given sorting option
     *
     * @param sortingOption method of which events are sorted
     * @return a formatted string displaying available events/the schedule
     */
    public static String formatSchedule(String sortingOption, User u) {

        ArrayList<Event> listOfEvents = EventSorter.sortBy(sortingOption);
        String sortedEvents = "";

        for (Event e: listOfEvents) {
            sortedEvents = sortedEvents + e;
            if (e.getAttending().contains(UserManager.giveIDOfUser(u))){
                sortedEvents = sortedEvents + " Currently Attending";
            }
            sortedEvents = sortedEvents + "\n";
        }
        return sortedEvents.trim();
    }

    /**
     * Returns the events that a user can sign up for
     *
     * @param u The user checked to see if they can sing up for events
     * @return A list of events titles that the user can sign up for
     */
    public static ArrayList<String> getSignUpEventTitle(User u){
        return EventManager.getSignUpEventsTitle(UserManager.giveIDOfUser(u));

    }

    /**
     * Return events of which a user is attending, speaking at, or organizing
     *
     * @param u the user
     * @return an unsorted list of events of which the user is attending, speaking at, or organizing
     */
    public static ArrayList<Event> getAllEventsUser(User u) {
        return EventManager.getAllEventsByUser(u.getUserID());
    }

    /** Allows a User to cancel their spot for an Event
     *
     * @param u The user cancelling their spot for the event
     * @param title the title of the event that the user is cancelling their spot for
     * @return A boolean with true if the User successfully cancelled their spot for the event and false if it wasn't
     */
    public static void cancelSpotEvent(User u, String title){
        EventManager.cancelSpotForEvent(u.getUserID(), EventManager.giveEventIDOfTitle(title));
    }

    public static void signUpForEvent(User u, String title){
        EventController.signUp(u,EventManager.giveEventIDOfTitle(title));
    }
}
