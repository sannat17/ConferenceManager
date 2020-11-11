package useCases;

import entities.Event;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {

    private static HashMap<Integer, Event> eventHashMap;

    public static Event getEvent(int ID) {
        return eventHashMap.get(ID);
    }

    public static boolean makeEvent(int eventID, String timeOfEvent, int roomNumber, int speakerID, int organizerID,
                                    ArrayList<Integer> attendees) {
        if (eventHashMap.containsKey(eventID)) {return false;}

        for(Event e: eventHashMap.values()){
            if (e.getTimeOfEvent().equals(timeOfEvent) && e.getRoomNumber() == roomNumber){
                return false;
            }
            else if (e.getTimeOfEvent().equals(timeOfEvent) && e.getSpeakerID() == speakerID){
                return false;
            }
        }

        Event e = new Event(eventID, timeOfEvent, roomNumber, speakerID, organizerID);
        eventHashMap.put(eventID, e);

        for (int ID: attendees) {
            e.addAttendant(ID);
        }

        return true;
    }

    public static boolean makeNewEvent(String timeOfEvent, int roomNumber, int speakerID, int organizerID){
        int ID = getNextID();
        return makeEvent(ID, timeOfEvent, roomNumber, speakerID, organizerID, new ArrayList<>());
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

    public static ArrayList<String> getAllEventsInfo() {
        ArrayList<String> allEventInfo = new ArrayList<>();
        for (Event e: eventHashMap.values()){
            allEventInfo.add(e.toString());
        }
        return allEventInfo;
    }

    private static int getNextID(){
        int maxID = -1;
        for (Integer ID: eventHashMap.keySet()){
            if(ID > maxID){
                maxID = ID;
            }
        }
        return (maxID + 1);
    }


}
