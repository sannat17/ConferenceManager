package presenters;

import entities.Event;
import useCases.EventManager;

import java.util.ArrayList;
import java.util.Collections;

/** The class of which sorts events based on given sorting option */
public class EventSorter {

    /**
     * Return a sorted list of available events by a given sorting option
     *
     * @param sortingOption string of which specifies sorting option
     * @return sorted list of available events by given sorting option
     */
    public static ArrayList<Event> sortBy(String sortingOption) {
        if (sortingOption.equals("title")) {
            return sortByTitle(EventManager.getAllEvents());
        }
        else if (sortingOption.equals("speaker")) {
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
        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<Event> sortedByTitle = new ArrayList<Event>();
        for (Event e: eventsInfo) {
            titles.add(e.getTitle().toUpperCase());
        }
        Collections.sort(titles);
        for (String t: titles){
            for (Event e: eventsInfo){
                if (e.getTitle().toUpperCase().equals(t)){
                    sortedByTitle.add(e);
                }
            }

        }
        return sortedByTitle;
    }

    /**
     * Return a sorted list of events by speaker
     *
     * @return a sorted list of events by speaker
     */
    public static ArrayList<Event> sortBySpeaker(ArrayList<Event> eventsInfo) {
        ArrayList<Integer> speakerIDs = new ArrayList<Integer>();
        ArrayList<Event> sortedBySpeakerID = new ArrayList<Event>();
        for (Event e: eventsInfo) {
            if (!speakerIDs.contains(e.getSpeakerID())) {
                speakerIDs.add(e.getSpeakerID());
            }
        }
        Collections.sort(speakerIDs);
        for (Integer i: speakerIDs){
            for (Event e: eventsInfo){
                if (e.getSpeakerID() == i){
                    sortedBySpeakerID.add(e);
                }
            }

        }
        return sortedBySpeakerID;
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
        return eventsInfo;
    }

}
