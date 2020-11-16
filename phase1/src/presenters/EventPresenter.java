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
    public static String formatEvents(String sortingOption) {

        ArrayList<Event> listOfEvents = EventSorter.sortBy(sortingOption);

        for (Event e: listOfEvents) {
            // format these events
        }
        return "Filler String";
    }

}
