package useCases;

import entities.Event;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/** An event manager */
public class EventManager {

    /** A hashmap where the key is the ID of an event and the value is the object of the event with that ID*/
    private static HashMap<Integer, Event> eventHashMap = new HashMap<Integer, Event>();

    /** Returns the event object corresponding to an ID
     *
     * @param ID The ID of the event wanted
     * @return the Event object with a specified ID
     */
    public static Event getEvent(int ID) {
        return eventHashMap.get(ID);
    }

    /** Creates a new Event and adds it to the eventHashMap
     *
     * @param eventID The ID of the event being created
     * @param title The title of the event
     * @param timeOfEvent The time of the event being created
     * @param roomNumber The room number of the event being created
     * @param speakerID The ID of the speaker of the event being created
     * @param organizerID The ID of the organizer of the event
     * @param attendees The list of UserIDs that are attending the event
     * @return A boolean with true if the Event was successfully created and false if it wasn't
     */
    public static boolean makeEvent(int eventID, String title, LocalDateTime timeOfEvent, int roomNumber, int speakerID, int organizerID,
                                    ArrayList<Integer> attendees) {
        if (eventHashMap.containsKey(eventID)) {return false;}    // return false if event already exists

        for(Event e: eventHashMap.values()){    // return false if there is a time-room number or time-speakerID overlap
            if ((e.getTimeOfEvent().equals(timeOfEvent) && e.getRoomNumber() == roomNumber) ||
                    (e.getTimeOfEvent().equals(timeOfEvent) && e.getSpeakerID() == speakerID)){
                return false;
            }
        }

        Event e = new Event(eventID, title, timeOfEvent, roomNumber, speakerID, organizerID);
        eventHashMap.put(eventID, e);

        for (int ID: attendees) {    // record event attendants in event object's attendance sheet
            e.addAttendant(ID);
        }

        return true;
    }

    /** Creates a new Event that does not already have an ID
     *
     * @param title The title of the event being created
     * @param timeOfEvent The time of the event being created
     * @param roomNumber The number of the room of the event being created
     * @param speakerID The ID of the speaker of the event being created
     * @param organizerID The ID of the organizer of the event
     * @return A boolean with true if the Event was successfully created and false if it wasn't
     */
    public static boolean makeNewEvent(String title, LocalDateTime timeOfEvent, int roomNumber, int speakerID, int organizerID){
        int ID = getNextID();
        return makeEvent(ID, title, timeOfEvent, roomNumber, speakerID, organizerID, new ArrayList<>());
    }

    /** Sign up a user for an event
     *
     * @param userID The ID of the user signing up for the event
     * @param eventID the ID of the event that the user is signing up for
     * @return A boolean with true if the User successfully signed up for the event and false if it wasn't
     */
    public static boolean signUpForEvent(int userID, int eventID){
        for(Event e: eventHashMap.values()) {    // this loop is unnecessary, just check for our event of interest
            if (e.getAttending().contains(userID)) {
                if (e.getEventID() == eventID || e.getTimeOfEvent().equals(eventHashMap.get(eventID).getTimeOfEvent())) {
                    return false;
                }
            }
        }
        if (eventHashMap.get(eventID).getAttending().size() > 2){
            return false;
        }
        eventHashMap.get(eventID).addAttendant(userID);
        return true;
    }

    /** Allows a User to cancel their spot for an Event
     *
     * @param userID The ID of the user cancelling their spot for the event
     * @param eventID the ID of the event that the user is cancelling their spot for
     * @return A boolean with true if the User successfully cancelled their spot for the event and false if it wasn't
     */
    public static boolean cancelSpotForEvent(int userID, int eventID){
        if (eventHashMap.get(eventID).getAttending().contains(userID)){
            eventHashMap.get(eventID).removeAttendant(userID);
            return true;
        }
        return false;
    }

    /** Allows an organizer to cancel any Event
     *
     * @param title the tile of the event that the organizer is cancelling
     * @return A boolean with true if the Organizer successfully cancelled the event
     */
    public static boolean cancelEvent(String title){
        int id = giveEventIDOfTitle(title);
        if (eventHashMap.containsKey(id)) {
            eventHashMap.remove(id);
            return true;
        }
        return false;
    }

    /** Returns a list of all the Event objects
     *
     * @return a list of all the Event objects
     */
    public static ArrayList<Event> getAllEvents() {    // verify if shallow copy is needed
        return new ArrayList<>(eventHashMap.values());
    }

    /** Returns a list of all the Events' information
     *
     * @return a list of all the Events' information
     */
    public static ArrayList<String> getAllEventsInfo() {
        ArrayList<String> allEventInfo = new ArrayList<>();
        for (Event e: eventHashMap.values()){
            allEventInfo.add(e.toString());
        }
        return allEventInfo;
    }

    /** Gets the next usable ID for an Event
     *
     * @return The maximum ID from all events plus 1
     */
    private static int getNextID(){    // assuming increasing and consecutive ID assignment
        int maxID = -1;
        for (Integer ID: eventHashMap.keySet()){
            if(ID > maxID){
                maxID = ID;
            }
        }
        return (maxID + 1);
    }

    /**
     * Return events of which a user is attending, speaking at, or organizing
     *
     * @param userID the ID of the user
     * @return an unsorted list of events of which the user is attending, speaking at, or organizing
     */
    public static ArrayList<Event> getAllEventsByUser(int userID) {

        ArrayList<Event> eventsByUser = new ArrayList<>();

        for (Event e: eventHashMap.values()){
            if (e.getAttending().contains(userID) || userID == e.getOrganizerID() || userID == e.getSpeakerID()) {
                eventsByUser.add(e);
            }
        }

        return eventsByUser;
    }

    /**
     * Returns the attendees of event with ID eventID
     * @param eventID - ID of event
     * @return event.getAttending()
     */
    public static ArrayList<Integer> getAttendingSpecificEvent(int eventID){
        for(Event event : getAllEvents()){ //for all events..
            if (eventID == event.getEventID()){
            //if the eventID matches...
                return event.getAttending(); //return the list of attendees
            }
        }
        return new ArrayList<Integer>();
        //else if no event matches, return an empty ArrayList
    }

    /**
     * Returns the ID of event with title.
     * @param title - the title of the event
     * @return e.getEventID()
     */
    public static int giveEventIDOfTitle (String title){
        for(Event e: getAllEvents()){
            if (e.getTitle().equals(title)){
                return e.getEventID();
            }
        }
        return -1;
    }
}
