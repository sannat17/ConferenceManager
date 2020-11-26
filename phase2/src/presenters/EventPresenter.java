package presenters;

import entities.Event;
import useCases.EventManager;

import java.util.ArrayList;

/** A presenter class for events/the schedule */
public class EventPresenter {

    // format events sorted by title
    // format events sorted by time
    // format events sorted by speaker

    // indicate beside event if attending

    /**
     * Format events based on given sorting option
     *
     * @param sortingOption method of which events are sorted
     * @return a formatted string displaying available events/the schedule
     */
    public static String formatEvents(String sortingOption, Integer userID) {

        ArrayList<Event> listOfEvents = EventSorter.sortBy(sortingOption);
        String sortedEvents = "";

        for (Event e: listOfEvents) {
            sortedEvents = sortedEvents + e;
            if (e.getAttending().contains(userID)){
                sortedEvents = sortedEvents + " Currently Attending";
            }
            sortedEvents = sortedEvents + "\n";
        }
        return sortedEvents.trim();
    }

}
