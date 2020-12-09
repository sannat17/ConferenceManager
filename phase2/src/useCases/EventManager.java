package useCases;

import entities.Event;
import entities.User;
import entities.VIP;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/** An event manager */
public class EventManager {

    /** A hashmap where the key is the ID of an event and the value is the object of the event with that ID*/
    private static HashMap<Integer, Event> eventHashMap = new HashMap<>();

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
     * @param speakerIDs The list of IDs of the speakers of the event being created
     * @param organizerID The ID of the organizer of the event
     * @param attendees The list of UserIDs that are attending the event
     * @param maxCapacity The maximum capacity of the event
     * @return A boolean with true if the Event was successfully created and false if it wasn't
     */
    public static boolean loadEvent(int eventID, String title, LocalDateTime timeOfEvent, int roomNumber, ArrayList<Integer> speakerIDs, int organizerID,
                                    ArrayList<Integer> attendees, boolean vip, int maxCapacity) {
        if (eventHashMap.containsKey(eventID)) {return false;}    // return false if event already exists

        for(int speakerID: speakerIDs)
        for(Event e: eventHashMap.values()){    // return false if there is a time-room number or time-speakerID overlap
            if ((e.getTimeOfEvent().equals(timeOfEvent) && e.getRoomNumber() == roomNumber) ||
                    (e.getTimeOfEvent().equals(timeOfEvent) && e.getSpeakerIDs().contains(speakerID))){
                return false;
            }
        }

        if (speakerIDs.size() == 0){ //if there is no speaker
            for (Event e : eventHashMap.values()) {    // return false if there is only a time-room number conflict                if ((e.getTimeOfEvent().equals(timeOfEvent) && e.getRoomNumber() == roomNumber))
                if ((e.getTimeOfEvent().equals(timeOfEvent) && e.getRoomNumber() == roomNumber))
                {
                    return false;
                }
            }
        }

        Event event; // create an event

        //decide whether the Event should be a Party, Talk or PanelDiscussion based on the speaker size
        if(speakerIDs.size() == 0){ //if there are no speakers, create a Party
            PartyCreator p = new PartyCreator(); //create an instance of the PartyCreator
            //and call the createEvent method to create a Party
            event = p.createEvent(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, vip, maxCapacity);
        }
        else if (speakerIDs.size() == 1){ //if there is 1 speaker, create a Talk
            TalkCreator t = new TalkCreator(); //create an instance of the TalkCreator
            //and call the createEvent method to create a Talk
            event = t.createEvent(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, vip, maxCapacity);

        }
        else { //if there are 2 or more speakers, create a PanelDiscussion
            PanelDiscussionCreator pd = new PanelDiscussionCreator();//create an instance of the PanelDiscussionCreator
            //and call the createEvent method to create a PanelDiscussion
            event = pd.createEvent(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, vip, maxCapacity);
        }

        eventHashMap.put(eventID, event); //put the Event onto the hashmap

        for (int ID: attendees) {    // record event attendants in event object's attendance sheet
            event.addAttendant(ID);
        }

        return true;
    }

    /** Creates a new Event that does not already have an ID
     *
     * @param title The title of the event being created
     * @param timeOfEvent The time of the event being created
     * @param roomNumber The number of the room of the event being created
     * @param speakerIDs The list of IDs of the speakers of the event being created
     * @param organizerID The ID of the organizer of the event
     * @return A boolean with true if the Event was successfully created and false if it wasn't
     */
    public static boolean makeNewEvent(String title, LocalDateTime timeOfEvent,
                                       int roomNumber, ArrayList<Integer> speakerIDs, int organizerID, boolean vip,
                                       int maxCapacity){
        int ID = getNextID();
        return loadEvent(ID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, new ArrayList<>(), vip, maxCapacity);
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

        if(getEvent(eventID).getVIP() && !(UserManager.getUser(userID) instanceof VIP)){
            return false; //false if event is for vips but user isn't vip
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
     *
     * @param user the current user
     * @param title the title of the event that the organizer is cancelling
     * @return A boolean with true if the Organizer successfully cancelled the event
     */
    public static boolean cancelEvent(User user, String title){
        int id = giveEventIDOfTitle(title);
        if (eventHashMap.containsKey(id)){
            if (user.getUserID() == giveOrganizerIDOfTitle(title)) {
                eventHashMap.remove(id);
                return true;
            }
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
            if (e.getAttending().contains(userID) || userID == e.getOrganizerID() || e.getSpeakerIDs().contains(userID)) {
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
        Event e =  getEvent(eventID);
        if (e == null) {
            return new ArrayList<>();
        }

        return e.getAttending();
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

    /**
     * Returns the organizerID of event with title.
     * @param title - the title of the event
     * @return e.getEventID()
     */
    public static int giveOrganizerIDOfTitle (String title){
        for(Event e: getAllEvents()){
            if (e.getTitle().equals(title)){
                return e.getOrganizerID();
            }
        }
        return -1;
    }

    /**
     * Returns the events that a user can sign up for
     *
     * @param userID The userID of the user.
     * @return A list of events that the user can sign up for
     */
    public static ArrayList<String> getSignUpEventsTitle(int userID){
        ArrayList<String> signUp = new ArrayList<>();
        for (Event e: eventHashMap.values()){
            if (!(e.getAttending().contains(userID)) && (e.getAttending().size() <= 2)){
                signUp.add(e.getTitle());
            }
        }
        return signUp;
    }

    /**
     * Returns the events a user is attending
     *
     * @param UserID The userID of the user.
     * @return A list of events that the user is attending
     */
    public static ArrayList<String> getAttending(int UserID){
        ArrayList<String> attending = new ArrayList<>();
        for (Event e: getAllEvents()){
            if (e.getAttending().contains(UserID)){
                attending.add(e.getTitle());
            }
        }
        return attending;
    }

    /**
     * Returns the events an organizer is organizing
     *
     * @param UserID The userID of the organizer.
     * @return A list of events that the user is organizing
     */
    public static ArrayList<String> getOrganizing(int UserID){
        ArrayList <String> organizing = new ArrayList<>();
        for (Event e: getAllEvents()){
            if (e.getOrganizerID() == UserID){
                organizing.add(e.getTitle());
            }
        }
        return organizing;
    }

}
