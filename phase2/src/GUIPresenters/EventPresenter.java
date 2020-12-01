package GUIPresenters;

import GUI.mainView;
import entities.Event;
import entities.User;
import presenters.EventSorter;
import useCases.UserManager;

import java.util.ArrayList;

public class EventPresenter {

    public static void nextEventPanel(String eventPanelChoice, User u){
        System.out.println(eventPanelChoice);
        switch (eventPanelChoice){
            case "View Your Events":
                mainView.toYourEventsPanel(u);
                break;

        }
    }

    public static String[] eventOptions(User u){
        return UserManager.getEventOptionsList(u);
    }

    /**
     * Format events based on given sorting option
     *
     * @param sortingOption method of which events are sorted
     * @return a formatted string displaying available events/the schedule
     */
    public static String formatSchedule(String sortingOption, User u) {

        ArrayList<Event> listOfEvents = EventSorter.sortBy(sortingOption);
        String sortedEvents = "";

        for (Event e: listOfEvents) {
            sortedEvents = sortedEvents + e;
            if (e.getAttending().contains(UserManager.giveIDOfUser(u))){
                sortedEvents = sortedEvents + " Currently Attending";
            }
            sortedEvents = sortedEvents + "\n";
        }
        return sortedEvents.trim();
    }
}
