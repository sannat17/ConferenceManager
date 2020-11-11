package entities;

import java.util.ArrayList;

/** A speaker user that gives speeches */
public class Speaker extends User{
    /**
     * Has the list of IDs of events that the Speaker is speaking at
     */
    private ArrayList<Integer> listOfEventIDs;

    /**
     * Create a new Speaker
     *
     * @param username the user name of this speaker
     * @param password the password of this speaker
     * @param ID the unique ID of this speaker
     */
    public Speaker(String username, String password, int ID, String firstName) {
        super(username, password, ID, firstName);
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
