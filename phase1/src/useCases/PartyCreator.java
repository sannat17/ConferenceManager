package useCases;

import abstractions.EventCreator;
import entities.Party;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PartyCreator extends EventCreator {
    /**
     * Overrides method in EventCreator, creates a new Party
     * @param eventID ID of Party
     * @param title Title of Party
     * @param timeOfEvent   Time of Party
     * @param roomNumber    The room number of the Party
     * @param speakerIDs    A list of IDs of the speakers (has to be empty)
     * @param organizerID   The ID of the Organizer
     * @return Talk
     */
    @Override
    public Party createEvent(int eventID, String title, LocalDateTime timeOfEvent,
                                    int roomNumber, ArrayList<Integer> speakerIDs, int organizerID, boolean vip){
        return new Party(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, vip);
    }

}
