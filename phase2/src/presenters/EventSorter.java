package presenters;

import entities.Event;
import useCases.EventManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        if (sortingOption.equals("Title")) {
            return sortByTitle(EventManager.getAllEvents());
        }
        else if (sortingOption.equals("Speaker")) {
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
            if (!speakerIDs.contains(e.getSpeakerIDs().get(0))) {
                speakerIDs.add(e.getSpeakerIDs().get(0));
            }
        }
        Collections.sort(speakerIDs);
        for (Integer i: speakerIDs){
            for (Event e: eventsInfo){
                if (e.getSpeakerIDs().get(0) == i){
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
        ArrayList<LocalDateTime> times = new ArrayList<LocalDateTime>();
        ArrayList<Event> sortedByTime = new ArrayList<Event>();
        for (Event e: eventsInfo) {
            if (!times.contains(e.getTimeOfEvent())) {
                times.add(e.getTimeOfEvent());
            }
        }
        Collections.sort(times);
        for (LocalDateTime t: times){
            for (Event e: eventsInfo){
                if (e.getTimeOfEvent() == t){
                    sortedByTime.add(e);
                }
            }

        }
        return sortedByTime;
    }

}
