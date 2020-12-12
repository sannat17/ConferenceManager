package useCases;

import abstractions.EventCreator;
import entities.PanelDiscussion;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PanelDiscussionCreator extends EventCreator {
    /**
     * Overrides method in EventCreator, creates a new PanelDiscussion
     * @param eventID ID of PanelDiscussion
     * @param title Title of PanelDiscussion
     * @param timeOfEvent   Time of PanelDiscussion
     * @param roomNumber    The room number of the PanelDiscussion
     * @param speakerIDs    A list of IDs of the speakers
     * @param organizerID   The ID of the Organizer
     * @param vip A boolean specifying whether this event is restricted to VIP users
     * @param maxCapacity The maximum capacity of this event
     * @return PanelDiscussion
     */
    @Override
    public PanelDiscussion createEvent(int eventID, String title, LocalDateTime timeOfEvent,
                                       int roomNumber, ArrayList<Integer> speakerIDs, int organizerID, boolean vip, int maxCapacity) {

        return new PanelDiscussion(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, vip, maxCapacity);
    }

}
