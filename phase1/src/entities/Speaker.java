package entities;

import java.util.ArrayList;

public class Speaker extends User{
    /**
     * Has the list of IDs of events that the Speaker is speaking at
     */
    private ArrayList<Integer> listOfEventIDs;

    /**
     * Calls the super constructor from Organizer
     * @param username
     * @param password
     * @param ID
     */
    public Speaker(String username, String password, int ID, String name) {
        super(username, password, ID, name);
    }

    /**
     * Returns the number of events this Speaker is speaking at
     * @return the size of the list of event IDs
     */
    public int getNumberOfEvents(){
        return this.listOfEventIDs.size();
    }

    @Override
    public ArrayList<Integer> getListOfEventIDs() {
        return listOfEventIDs;
    }

    public void addEvent (int eventID) {
        listOfEventIDs.add(eventID);
    }

    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return super.toString() + delimiter + "speaker" + delimiter + listOfEventIDs.toString();
    }
}
