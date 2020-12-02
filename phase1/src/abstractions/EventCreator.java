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
     * @param eventID
     * @param title
     * @param timeOfEvent
     * @param roomNumber
     * @param speakerIDs
     * @param organizerID
     * @return
     */
    public abstract Event createEvent(int eventID, String title, LocalDateTime timeOfEvent,
                                    int roomNumber, ArrayList<Integer> speakerIDs, int organizerID);
}
