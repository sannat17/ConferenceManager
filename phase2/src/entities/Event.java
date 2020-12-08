package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

/** An Event */
public class Event {
    /** The title of this event */
    private String title;
    /** The unique ID of this event */
    private int eventID;
    /** The time of this event */
    private LocalDateTime timeOfEvent;
    /** The room number of this event */
    private int roomNumber;
    /** The unique ID of this speaker for the event */
    private ArrayList<Integer> speakerIDs;
    /** The unique ID of the organizer of the event */
    private int organizerID;
    /** The list of UserIDs that are attending the event */
    private ArrayList<Integer> attending;
    /** Whether event is VIP or not */
    private boolean vip;
    /** The maximum capacity of this event */
    private int maxCapacity;

    /**
     * Create a new event
     *
     * @param eventID The unique ID of this event
     * @param title the title of this event
     * @param timeOfEvent The time of this event
     * @param roomNumber The room number of this event
     * @param speakerIDs The unique ID of this speaker for the event
     * @param organizerID The unique ID of the organizer of the event
     * @param vip A boolean specifying whether this event is restricted to VIP users
     * @param maxCapacity The maximum capacity of this event
     */
    public Event(int eventID, String title, LocalDateTime timeOfEvent,
                 int roomNumber, ArrayList<Integer> speakerIDs, int organizerID,
                 boolean vip, int maxCapacity){
        this.eventID = eventID;
        this.timeOfEvent = timeOfEvent;
        this.title = title;
        this.roomNumber = roomNumber;
        this.speakerIDs = speakerIDs;
        this.organizerID = organizerID;
        this.attending = new ArrayList<Integer>();
        this.vip = vip;
        this.maxCapacity = maxCapacity;
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
     * @return The unique ID of this speaker for the event
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

    /** Adds the unique ID of the user to the attending list
     *
     * @param userID The unique ID of the user
     */
    public void addAttendant(int userID){
        attending.add(userID);
    }

    /** Returns the Event in the form of a string
     *
     * @return The event in a string in the form of "eventID,title,timeOfEvent,roomNumber,speakerID,organizerID,attending"
     */
    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        if (!(speakerIDs.isEmpty())) {
            return  eventID + delimiter + title + delimiter + timeOfEvent + delimiter + roomNumber +
                    delimiter + speakerIDs + delimiter + organizerID + delimiter + attending +
                    delimiter + vip + delimiter + maxCapacity;
        } else {
            return  eventID + delimiter + title + delimiter + timeOfEvent + delimiter + roomNumber +
                    delimiter + -99 + delimiter + organizerID + delimiter + attending + delimiter + vip +
                    delimiter + maxCapacity;
        }
    }

    /** Removes the unique ID of the user to the attending list
     *
     * @param userID The unique ID of the user
     */
    public void removeAttendant(int userID){
        attending.remove(attending.indexOf(userID));
    }
}
