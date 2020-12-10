package GUIPresenters;

import GUI.mainView;
import controllers.EventController;
import gateways.EventExporter;

import useCases.*;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventPresenter {

    /**
     * Goes the next panel for in event
     * @param eventPanelChoice The name of the next event
     */
    public static void nextEventPanel(String eventPanelChoice){
        switch (eventPanelChoice){
            case "View Your Events":
                mainView.toPanel("Your Events");
                break;
            case "Sign up for an event":
                mainView.toPanel("Sign Up for Event");
                break;
            case "Cancel sign up for an event":
                mainView.toPanel("Cancel Sign Up for Event");
                break;
            case "Organize event":
                mainView.toPanel("Organize event");
                break;
            case "Cancel an event":
                mainView.toPanel("Cancel Event");
                break;
            case "Print Events":
                mainView.toPanel("Print Events");
                break;
            }
        }

    /**
     * Gets the event options
     * @return The event options for a user
     */
    public static String[] eventOptions(){
        return UserManager.getEventOptionsList(AuthManager.getLoggedInUser());
    }

    /**
     * Format events based on given sorting option
     *
     * @param sortingOption method of which events are sorted
     * @return a formatted string displaying available events/the schedule
     */
    public static String formatSchedule(String sortingOption) {

        return EventSorter.formatSchedule(sortingOption);
    }

    /**
     * Returns the events that a user can sign up for
     *
     * @return A list of events titles that the user can sign up for
     */
    public static ArrayList<String> getSignUpEventTitle(){
        return EventManager.getSignUpEventsTitle(UserManager.giveIDOfUser(AuthManager.getLoggedInUser()));

    }

    /**
     * Returns the events a user is attending
     *
     * @return A list of events that the user is attending
     */
    public static ArrayList<String> getAttending(){
        return EventManager.getAttending(AuthManager.getLoggedInUser().getUserID());
    }

    /** Allows a User to cancel their spot for an Event
     *
     * @param title the title of the event that the user is cancelling their spot for
     */
    public static void cancelSpotEvent(String title){
        boolean cancelled = EventController.cancelSignUp(AuthManager.getLoggedInUser(), EventManager.giveEventIDOfTitle(title));
        if (!cancelled){
            mainView.createPopUp("Could not cancel your spot ");
        }
        else{
            mainView.createPopUp("Cancelled spot");
            mainView.toPanel("Events");
        }
    }

    /**
     * Signs the logged in user up for an event
     * @param title The title of the event
     */
    public static void signUpForEvent(String title){
        boolean signedUp = EventManager.signUpForEvent(AuthManager.getLoggedInUser().getUserID(),EventManager.giveEventIDOfTitle(title));
        if (!signedUp){
            mainView.createPopUp("Could not sign you up for this event");
        }
        else{
            mainView.createPopUp("Signed up!");
            mainView.toPanel("Events");;
        }
    }

    /**
     * Gets a list of speakers
     * @return Gets a default list model of the speakers
     */
    public static DefaultListModel<String> getSpeakers(){
        ArrayList<String> speakersArrayList = UserTypeManager.getUsersByType("speaker");
        DefaultListModel<String> speakers = new DefaultListModel<>();
        for(String speaker: speakersArrayList){
            speakers.addElement(speaker);
        }
        return speakers;
    }

    /**
     * Makes a new event
     * @param title Title of the event
     * @param time Time of the the event
     * @param roomNumber Room Number of the event
     * @param speakerNames Name of the speakers of the event
     * @param vip Whether or not it is a vip event or not
     * @param maxCapacity Max capacity of the event
     */
    public static void makeEvent(String title, LocalDateTime time, int roomNumber,
                                 DefaultListModel<String> speakerNames, boolean vip, int maxCapacity){
        ArrayList<Integer> speakerIDs = new ArrayList<>();
        for(int i = 0; i < speakerNames.size(); i++ ){
            speakerIDs.add(UserManager.giveIDOfUsername(speakerNames.get(i)));
        }
        boolean made = EventManager.makeNewEvent(title, time, roomNumber, speakerIDs,
                UserManager.giveIDOfUser(AuthManager.getLoggedInUser()), vip, maxCapacity);
        if (!made){
            mainView.createPopUp("There was a conflict while trying to create your event.");
        }
        else{
            mainView.createPopUp("Event Created!");
            mainView.toPanel("Events");;
        }
    }


    public static ArrayList<String> getOrganizingTitles(){
        return EventManager.getOrganizing(AuthManager.getLoggedInUser().getUserID());
    }

    public static void cancelEvent(String title){
        boolean cancelled = EventManager.cancelEvent(AuthManager.getLoggedInUser(), title);
        if (!cancelled) {
            mainView.createPopUp("Could not cancel event");
        }
        else{
            mainView.createPopUp("Event Cancelled!");
            mainView.toPanel("Events");
        }
    }

    public static void export() throws IOException {
        EventExporter.requestExport();
    }
}
