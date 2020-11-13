package entities;

import java.util.ArrayList;

/** An Event */
public class Event {
    /** The title of this event */
    private String title;
    /** The unique ID of this event */
    private int eventID;
    /** The time of this event */
    private String timeOfEvent;
    /** The room number of this event */
    private int roomNumber;
    /** The unique ID of this speaker for the event */
    private int speakerID;
    /** The unique ID of the organizer of the event */
    private int organizerID;
    /** The list of UserIDs that are attending the event */
    private ArrayList<Integer> attending;

    /**
     * Create a new event
     *
     * @param eventID The unique ID of this event
     * @param title the title of this event
     * @param timeOfEvent The time of this event
     * @param roomNumber The room number of this event
     * @param speakerID The unique ID of this speaker for the event
     * @param organizerID The unique ID of the organizer of the event
     */
    public Event(int eventID, String title, String timeOfEvent, int roomNumber, int speakerID, int organizerID){
        this.eventID = eventID;
        this.timeOfEvent = timeOfEvent;
        this.roomNumber = roomNumber;
        this.speakerID = speakerID;
        this.organizerID = organizerID;
        this.attending = new ArrayList<Integer>();
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
     * @return The time of this event
     */
    public String getTimeOfEvent() {
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
    public int getSpeakerID() {
        return speakerID;
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
     * @return The event in a string in the form of "eventID,timeOfEvent,roomNumber,speakerID,organizerID,attending"
     */
    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return  eventID + delimiter + timeOfEvent + delimiter + roomNumber +
                delimiter + speakerID + delimiter + organizerID + delimiter + attending;
    }

    /** Removes the unique ID of the user to the attending list
     *
     * @param userID The unique ID of the user
     */
    public void removeAttendant(int userID){
        attending.remove(userID);
    }
}
