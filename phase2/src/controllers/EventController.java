package controllers;
import useCases.EventManager;

/** The controller class for events */
public class EventController {

    /**
     * Signup a user for a corresponding event
     *
     * @param userID the user of which wants to signup for the event
     * @param eventID the event ID of the event the user wants to signup for
     * @return true if signup successful or false if signup unsuccessful
     */
    public static boolean signUp(int userID, int eventID) {
        if (EventManager.getAllEvents().isEmpty()) {
            return false;
        }
        EventManager.signUpForEvent(userID, eventID);
        return true;
    }


}
