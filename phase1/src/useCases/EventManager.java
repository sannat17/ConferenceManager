package useCases;

import entities.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {

    private static HashMap<Integer, Event> eventHashMap;

    public static Event getEvent(int ID) {
        return eventHashMap.get(ID);
    }

    public static boolean makeNewEvent(int eventID, String timeOfEvent, int roomNumber, int speakerID) {
        if (eventHashMap.containsKey(eventID)) {return false;}

        for(Event e: eventHashMap.values()){
            if (e.getTimeOfEvent().equals(timeOfEvent) && e.getRoomNumber() == roomNumber){
                return false;
            }
        }
        //TODO: Implement check for speaker and make sure he is not booked for another event at the same time.

        Event e = new Event(eventID, timeOfEvent, roomNumber, speakerID);
        eventHashMap.put(eventID, e);
        return true;
    }

    public static boolean signUpForEvent(int userID, int eventID){
        for(Event e: eventHashMap.values()) {
            if (e.getAttending().contains(userID)) {
                if (e.getEventID() == eventID || e.getTimeOfEvent().equals(eventHashMap.get(eventID).getTimeOfEvent())) {
                    return false;
                }
            }
        }
        eventHashMap.get(eventID).addAttendant(userID);
        return true;
    }

    public static boolean cancelSpotForEvent(int userID, int eventID){
        if (eventHashMap.get(eventID).getAttending().contains(userID)){
            eventHashMap.get(eventID).removeAttendant(userID);
            return true;
        }
        return false;
    }

    public static ArrayList<Event> getAllEvents() {
        return new ArrayList<>(eventHashMap.values());
    }


}
