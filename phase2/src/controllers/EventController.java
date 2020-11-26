package controllers;
import entities.Event;
import entities.User;
import useCases.EventManager;
import useCases.UserManager;

import java.util.HashMap;

/** The controller class for events */
public class EventController {

    /**
     * Signup a user for a corresponding event
     *
     * @param user the user of which wants to signup for the event
     * @param eventID the event ID of the event the user wants to signup for
     * @return true if signup successful or false if signup unsuccessful
     */
    public static boolean signUp(User user, int eventID) {
        for (Event e: EventManager.getAllEventsByUser(user.getUserID())) {
            if (e.getEventID() == eventID) {
                return false;
            }
        }
        EventManager.signUpForEvent(user.getUserID(), eventID);
        return true;
    }

    /**
     * Cancel signup for a user of a corresponding event
     *
     * @param user the user of which wants to cancel sign up for the event
     * @param eventID the event ID of the event the user wants to cancel signup for
     * @return true if cancellation successful or false if cancellation unsuccessful
     */
    public static boolean cancelSignUp(User user, int eventID) {
        for (Event e: EventManager.getAllEventsByUser(user.getUserID())) {
            if (e.getEventID() == eventID) {
                EventManager.cancelSpotForEvent(user.getUserID(), eventID);
                return true;
            }
        }
        return false;
    }
}
