package controllers;
import entities.Event;
import useCases.EventManager;
import java.util.HashMap;

// This class controls the EventSignUp ie: it controls the implementation of the useCase class EventManager

public class EventSignupController {

//    This variable stores the hashMap for the presenter, however, in the background, when this method is called
//    the private variable in the useCase EventManager stores the signUp information.

    public static HashMap<Integer, Event> presenterEventHashMap;

    public static String exceptionMessage;

    public static boolean controlSignUp(int userID, int eventID){

        if (EventManager.signUpForEvent(userID, eventID)) {
            presenterEventHashMap.get(eventID).addAttendant(userID);
            return true;
        } else {
            exceptionMessage = "The User with userID" + userID + "already exists in the Event with ID" + eventID;
            return false;
        }
    }

//  ********************************************************************************************************************

    public static boolean controlCancel(int userID, int eventID){

        if (EventManager.cancelSpotForEvent(userID, eventID)) {
            presenterEventHashMap.get(eventID).removeAttendant(userID);
            return true;
        } else {
            exceptionMessage = "The User with userID" + userID + "doesn't exist in the Event with ID" + eventID;
            return false;
        }
    }

//  ********************************************************************************************************************

}
