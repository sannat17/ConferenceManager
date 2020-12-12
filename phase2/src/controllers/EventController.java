package controllers;
import entities.Event;
import entities.User;
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

    /**
     * Cancel signup for a user of a corresponding event
     *
     * @param userID the user ID of the user which wants to cancel sign up for the event
     * @param eventID the event ID of the event the user wants to cancel signup for
     * @return true if cancellation successful or false if cancellation unsuccessful
     */
    public static boolean cancelSignUp(int userID, int eventID) {
        for (Event e: EventManager.getAllEventsByUser(userID)) {
            if (e.getEventID() == eventID) {
                EventManager.cancelSpotForEvent(userID, eventID);
                return true;
            }
        }
        return false;
    }

      /**
       * Cancel the event the user wants to cancel
       *
       * @param user the organizer who is cancelling the event
       * @param title the title of the event the organizer wants to cancel
       * @return true if cancellation successful or false if cancellation unsuccessful
       */
       public static boolean cancelEvent(User user, String title) {
       return EventManager.cancelEvent(user.getUserID(), title);
    }
}
