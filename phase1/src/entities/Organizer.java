package entities;

import java.util.ArrayList;

public class Organizer extends User{
    /**
     * The list of IDs of events that this Organizer organizes
     */
    ArrayList listOfEventIDs;

    /**
     * Call the super constructor from User and initialize the list of IDs to be empty
     */
    public Organizer(String username, String password, int ID) {
        super(username, password, ID);
        this.listOfEventIDs = new ArrayList();
    }

    /**
     * Returns the list of event IDs
     * @return ArrayList
     */
    public ArrayList getListOfEvents(){
        return this.listOfEventIDs;
    }

    /**
     * Adds the ID of the newEvent to the list
     * @param newEvent
     */

    public void addEvent(Event newEvent){
        listOfEventIDs.add(newEvent.getEventID());
    }

}
