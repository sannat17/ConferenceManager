package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Party extends Event{
    /**
     * Create a new event
     *  @param eventID     The unique ID of this event
     * @param title       the title of this event
     * @param timeOfEvent The time of this event
     * @param roomNumber  The room number of this event
     * @param speakerIDs  The unique number of IDs of speakers. Always empty since there are no speakers
     * @param organizerID The unique ID of the organizer of the event
     */
    public Party(int eventID, String title, LocalDateTime timeOfEvent, int roomNumber,
                 ArrayList<Integer> speakerIDs, int organizerID, boolean vip) {
        super(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, vip);
    }
}
