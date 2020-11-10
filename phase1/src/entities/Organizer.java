package entities;

import java.util.ArrayList;

public class Organizer extends User{
    /**
     * The list of IDs of events that this Organizer organizes
     */
    private ArrayList<Integer> listOfEventIDs;

    /**
     * Call the super constructor from User and initialize the list of IDs to be empty
     */
    public Organizer(String username, String password, int ID, String name) {
        super(username, password, ID, name);
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
