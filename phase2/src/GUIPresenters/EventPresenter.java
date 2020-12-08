package GUIPresenters;

import GUI.mainView;
import controllers.EventController;
import entities.Event;
import entities.User;
import presenters.EventSorter;
import useCases.EventManager;
import useCases.UserManager;
import useCases.UserTypeManager;

import javax.swing.*;
import java.time.LocalDateTime;
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
            case "Organize event":
                mainView.toOrganizeEventPanel(u);
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
            sortedEvents = sortedEvents + e.getTitle();
            if (e.getAttending().contains(UserManager.giveIDOfUser(u))){
                sortedEvents = sortedEvents + " (Currently Attending)";
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
     * Returns the events a user is attending
     *
     * @param u The user.
     * @return A list of events that the user is attending
     */
    public static ArrayList<String> getAttending(User u){
        return EventManager.getAttending(u.getUserID());
    }

    /** Allows a User to cancel their spot for an Event
     *
     * @param u The user cancelling their spot for the event
     * @param title the title of the event that the user is cancelling their spot for
     * @return A boolean with true if the User successfully cancelled their spot for the event and false if it wasn't
     */
    public static void cancelSpotEvent(User u, String title){
        boolean cancelled = EventController.cancelSignUp(u, EventManager.giveEventIDOfTitle(title));
        if (cancelled == false){
            mainView.createPopUp("Could not cancel your spot ");
        }
        else{
            mainView.createPopUp("Cancelled spot");
            mainView.toEventsPanel(u);
        }
    }

    public static void signUpForEvent(User u, String title){
        Boolean signedUp = EventController.signUp(u,EventManager.giveEventIDOfTitle(title));
        if (signedUp == false){
            mainView.createPopUp("Could not sign you up for this event");
        }
        else{
            mainView.createPopUp("Signed up!");
            mainView.toEventsPanel(u);
        }
    }

    public static DefaultListModel<String> getSpeakers(){
        ArrayList<String> speakersArrayList = UserTypeManager.getUsersByType("speaker");
        DefaultListModel<String> speakers = new DefaultListModel<>();
        for(String speaker: speakersArrayList){
            speakers.addElement(speaker);
        }
        return speakers;
    }

    public static void makeEvent(String title, LocalDateTime time, int roomNumber,
                                 DefaultListModel<String> speakerNames, User organizer, boolean vip, int maxCapacity){
        ArrayList<Integer> speakerIDs = new ArrayList<>();
        for(int i = 0; i < speakerNames.size(); i++ ){
            speakerIDs.add(UserManager.giveIDOfUsername(speakerNames.get(i)));
        }
        Boolean made = EventManager.makeNewEvent(title, time, roomNumber, speakerIDs, UserManager.giveIDOfUser(organizer), vip,
                maxCapacity);
        if (made == false){
            mainView.createPopUp("There was a conflict while trying to create your event.");
        }
        else{
            mainView.createPopUp("Event Created!");
            mainView.toEventsPanel(organizer);
        }
    }
}
