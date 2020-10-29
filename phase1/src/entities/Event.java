package entities;

public class Event {

    private int eventID;
    private String timeOfEvent;
    private int roomNumber;
    private int speakerID;

    public Event(int eventID, String timeOfEvent, int roomNumber, int speakerID){
        this.eventID = eventID;
        this.timeOfEvent = timeOfEvent;
        this.roomNumber = roomNumber;
        this.speakerID = speakerID;
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
}
