package entities;

import java.util.ArrayList;

public class Event {

    private int eventID;
    private String timeOfEvent;
    private int roomNumber;
    private int speakerID;
    private int organizerID;
    private ArrayList<Integer> attending;

    public Event(int eventID, String timeOfEvent, int roomNumber, int speakerID, int organizerID){
        this.eventID = eventID;
        this.timeOfEvent = timeOfEvent;
        this.roomNumber = roomNumber;
        this.speakerID = speakerID;
        this.organizerID = organizerID;
        this.attending = new ArrayList<Integer>();
    }

    public int getEventID() {
        return eventID;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getSpeakerID() {
        return speakerID;
    }

    public ArrayList<Integer> getAttending(){
        return attending;
    }

    public void addAttendant(int userID){
        attending.add(userID);
    }

    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return  eventID + delimiter + timeOfEvent + delimiter + roomNumber + delimiter + speakerID + delimiter + organizerID + attending;
    }

    public void removeAttendant(int userID){
        attending.remove(userID);
    }
}
