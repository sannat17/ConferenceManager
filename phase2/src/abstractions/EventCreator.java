package abstractions;

import entities.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * An abstract class as a base for the Factory Pattern
 */
public abstract class EventCreator {
    /**
     * An abstract method implemented in the subclasses
     * @param eventID ID of event
     * @param title Title of event
     * @param timeOfEvent   Time of event
     * @param roomNumber    The room number of the event
     * @param speakerIDs    A list of IDs of the speakers
     * @param organizerID   The ID of the Organizer
     * @param vip A boolean specifying whether this event is restricted to VIP users
     * @param maxCapacity The maximum capacity of this event
     * @return
     */
    public abstract Event createEvent(int eventID, String title, LocalDateTime timeOfEvent,
                                    int roomNumber, ArrayList<Integer> speakerIDs, int organizerID, boolean vip,
                                      int maxCapacity);
}
