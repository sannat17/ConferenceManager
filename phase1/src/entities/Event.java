package entities;

import java.util.ArrayList;

public class Event {

    private int eventID;
    private String timeOfEvent;
    private int roomNumber;
    private int speakerID;
    private ArrayList<Integer> attending;

    public Event(int eventID, String timeOfEvent, int roomNumber, int speakerID){
        this.eventID = eventID;
        this.timeOfEvent = timeOfEvent;
        this.roomNumber = roomNumber;
        this.speakerID = speakerID;
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

    public void removeAttendant(int userID){
        attending.remove(userID);
    }
}
