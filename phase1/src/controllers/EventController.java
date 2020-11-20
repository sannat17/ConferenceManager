package controllers;
import entities.Event;
import entities.User;
import useCases.EventManager;
import useCases.UserManager;

import java.util.HashMap;

/** The controller class for events */
public class EventController {

    public static boolean signUp(User user, int eventID) {
        for (Event e: EventManager.getAllEventsByUser(user.getUserID())) {
            if (e.getEventID() == eventID) {
                return false;
            }
        }
        EventManager.signUpForEvent(user.getUserID(), eventID);
        return true;
    }

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
