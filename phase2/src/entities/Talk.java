package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Talk extends Event {
    /**
     * Create a new event
     *
     * @param eventID     The unique ID of this event
     * @param title       the title of this event
     * @param timeOfEvent The time of this event
     * @param roomNumber  The room number of this event
     * @param speakerIDs  The list of unique ID of this speaker for the event, precondition: has to be of length 1
     * @param organizerID The unique ID of the organizer of the event
     * @param vip A boolean specifying whether this event is restricted to VIP users
     * @param maxCapacity The maximum capacity of this event
     */
    public Talk(int eventID, String title, LocalDateTime timeOfEvent, int roomNumber,
                ArrayList<Integer> speakerIDs, int organizerID, boolean vip, int maxCapacity) {
        super(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, vip, maxCapacity);

    }
}
