package presenters;

import entities.Event;
import useCases.EventManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/** A presenter class for events/the schedule */
public class EventPresenter extends Presenter {

    /**
     * Format and return a dictionary of available sorting options
     *
     * @return a dictionary of the available sorting options
     */
    public static HashMap<Integer, String> getSortingOptionsDict() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("View events by title");
        options.add("View events by time");
        options.add("View events by speaker");

        HashMap<Integer, String> sortingOptionsDict = new HashMap<Integer, String>();
        int i = 1;
        for (String option : options) {
            if (!(sortingOptionsDict.containsValue(option))) {
                sortingOptionsDict.put(i, option);
                i += 1;
            }
        }
        return sortingOptionsDict;
    }

    /**
     * Format and return dictionary of available event interaction options
     *
     * @return a dictionary of the available event interaction options
     */
    public static HashMap<Integer, String> getEventInteractionDict() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("Sign up for an event");
        options.add("Cancel sign up for an event");
        options.add("Return to main menu");

        HashMap<Integer, String> eventInteractionDict = new HashMap<Integer, String>();
        int i = 1;
        for (String option : options) {
            if (!(eventInteractionDict.containsValue(option))) {
                eventInteractionDict.put(i, option);
                i += 1;
            }
        }
        return eventInteractionDict;
    }

    /**
     * Format events based on given sorting option
     *
     * @param sortingOption method of which events are sorted
     * @return a formatted string displaying available events/the schedule
     */
    public static String formatSchedule(String sortingOption, Integer userID) {

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
