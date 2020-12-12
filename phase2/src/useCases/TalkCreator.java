package useCases;

import abstractions.EventCreator;
import entities.Talk;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class TalkCreator extends EventCreator {
    /**
     * Overrides method in EventCreator, creates a new talk
     * @param eventID ID of Talk
     * @param title Title of Talk
     * @param timeOfEvent   Time of talk
     * @param roomNumber    The room number of the talk
     * @param speakerIDs    A list of IDs of the speakers
     * @param organizerID   The ID of the Organizer
     * @param vip           Determines whether the Talk is VIP or not
     * @param maxCapacity   The maximum capacity of people attending
     * @return Talk
     */
    @Override
    public Talk createEvent(int eventID, String title, LocalDateTime timeOfEvent,
                            int roomNumber, ArrayList<Integer> speakerIDs, int organizerID, boolean vip, int maxCapacity) {
        return new Talk(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, vip, maxCapacity);
    }
}
