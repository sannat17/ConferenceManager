package entities;

import java.util.ArrayList;

/** An organizer user with management level capabilities */
public class Organizer extends User{
    /**
     * The list of IDs of events that this Organizer organizes
     */
    private ArrayList<Integer> listOfEventIDs;

    /**
     * Create new Organizer, initialize a list of this Organizer's events
     * based on ID, and add available menu options
     *
     * @param username the user name of this organizer
     * @param password the password of this organizer
     * @param ID the unique ID of this organizer
     */
    public Organizer(String username, String password, int ID, String name) {
        super(username, password, ID, name);
        this.listOfEventIDs = new ArrayList();
        this.menuOptions.add("message events");
        this.menuOptions.add("organize event");
    }

    /**
     * Return the list of event IDs
     *
     * @return the list of IDs of this organizer's events
     */
    public ArrayList getListOfEvents(){
        return this.listOfEventIDs;
    }

    /**
     * Adds the eventID to the list of events being organized
     * @param eventID The ID of an event being organized by this Organizer.
     */
    public void addEvent(int eventID){
        listOfEventIDs.add(eventID);
    }

    @Override
    public ArrayList<Integer> getListOfEventIDs() {
        return listOfEventIDs;
    }

    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return super.toString() + delimiter + "organizer" + delimiter + listOfEventIDs.toString();
    }
}
