package presenters;

import entities.Event;
import useCases.EventManager;

import java.util.ArrayList;

/** The class of which sorts events based on given sorting option */
public class EventSorter {

    /**
     * Return a sorted list of available events by a given sorting option
     *
     * @param sortingOption string of which specifies sorting option
     * @return sorted list of available events by given sorting option
     */
    public static ArrayList<Event> sortBy(String sortingOption) {
        if (sortingOption == "title") {
            return sortByTitle(EventManager.getAllEvents());
        }
        else if (sortingOption == "speaker") {
            return sortBySpeaker(EventManager.getAllEvents());
        }
        else {
            return sortByTime(EventManager.getAllEvents());
        }
    }

    /**
     * Return a sorted list of events by title
     *
     * @return a sorted list of events by title
     */
    public static ArrayList<Event> sortByTitle(ArrayList<Event> eventsInfo) {
        ArrayList<Event> allEvents = eventsInfo;
        for (Event e: allEvents) {
            // sorting algorithm
        }
    }

    /**
     * Return a sorted list of events by speaker
     *
     * @return a sorted list of events by speaker
     */
    public static ArrayList<Event> sortBySpeaker(ArrayList<Event> eventsInfo) {
        ArrayList<Event> allEvents = eventsInfo;
        for (Event e: allEvents) {
            // sorting algorithm
        }
    }

    /**
     * Return a sorted list of events by time
     *
     * @return a sorted list of events by time
     */
    public static ArrayList<Event> sortByTime(ArrayList<Event> eventsInfo) {
        ArrayList<Event> allEvents = eventsInfo;
        for (Event e: allEvents) {
            // sorting algorithm
        }
    }

}
