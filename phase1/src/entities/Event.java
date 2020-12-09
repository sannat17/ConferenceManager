package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

/** An Event */
public class Event {
    /** The title of this event */
    protected String title;
    /** The unique ID of this event */
    protected int eventID;
    /** The time of this event */
    protected LocalDateTime timeOfEvent;
    /** The room number of this event */
    protected int roomNumber;
    /** The unique ID of this speaker for the event */
    protected ArrayList<Integer> speakerIDs;
    /** The unique ID of the organizer of the event */
    protected int organizerID;
    /** The list of UserIDs that are attending the event */
    protected ArrayList<Integer> attending;
    /** Determines whether the event is VIP or not */
    protected  boolean vip;
 
    /**
     * Create a new event
     *
     * @param eventID The unique ID of this event
     * @param title the title of this event
     * @param timeOfEvent The time of this event
     * @param roomNumber The room number of this event
     * @param speakerIDs The list of unique IDs of the speakers for the event
     * @param organizerID The unique ID of the organizer of the event
     */
    public Event(int eventID, String title, LocalDateTime timeOfEvent, int roomNumber,
                 ArrayList<Integer> speakerIDs, int organizerID, boolean vip){
        this.eventID = eventID;
        this.timeOfEvent = timeOfEvent;
        this.title = title;
        this.roomNumber = roomNumber;
        this.speakerIDs = speakerIDs;
        this.organizerID = organizerID;
        this.attending = new ArrayList<Integer>();
        this.vip = vip;
    }

    /**
     * A constructor for an event that doesn't contain any speakers.
     * Calls the previous constructor but passes an empty ArrayList for the speakerIDs
     * @param eventID The unique ID of this event
     * @param title the title of this event
     * @param timeOfEvent The time of this event
     * @param roomNumber The room number of this event
     * @param organizerID The unique ID of the organizer of the event
     */
    public Event(int eventID, String title, LocalDateTime timeOfEvent,
                 int roomNumber, int organizerID, boolean vip){
        this(eventID, title, timeOfEvent, roomNumber, new ArrayList<Integer>(), organizerID, vip);
    }

    /**
     *
     * @return The unique ID of this event
     */
    public int getEventID() {
        return eventID;
    }

    /**
     *
     * @return The Title of this event
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return The time of this event
     */
    public LocalDateTime getTimeOfEvent() {
        return timeOfEvent;
    }

    /**
     *
     * @return The room number of this event
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     *
     * @return The list of unique IDs of speakers for the event
     */
    public ArrayList<Integer> getSpeakerIDs() {
        return speakerIDs;
    }

    /**
     *
     * @return The unique ID of this organizer for the event
     */
    public int getOrganizerID(){
        return organizerID;
    }

    /**
     *
     * @return The list of UserIDs that are attending the event
     */
    public ArrayList<Integer> getAttending(){
        return attending;
    }

    /**
     *
     * @return Whether the event is VIP or not
     */
    public boolean getVIP(){ return vip; }

    /** Adds the unique ID of the user to the attending list
     *
     * @param userID The unique ID of the user
     */
    public void addAttendant(int userID){
        attending.add(userID);
    }

    /** Returns the Event in the form of a string
     *
     * @return The event in a string in the form of "eventID,title,timeOfEvent,roomNumber,speakerIDs,organizerID,attending"
     */
    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return  eventID + delimiter + title + delimiter + timeOfEvent + delimiter + roomNumber +
                delimiter + speakerIDs + delimiter + organizerID + delimiter + attending + delimiter + vip;
    }

    /** Removes the unique ID of the user to the attending list
     *
     * @param userID The unique ID of the user
     */
    public void removeAttendant(int userID){
        attending.remove(userID);
    }
}
