package entities;

import java.util.ArrayList;

/** A speaker user that gives speeches */
public class Speaker extends User{
    /** This list of IDs of events at which this speaker will present */
    ArrayList listOfEventIDs;

    /**
     * Create a new Speaker
     *
     * @param username the user name of this speaker
     * @param password the password of this speaker
     * @param ID the unique ID of this speaker
     */
    public Speaker(String username, String password, int ID) {
        super(username, password, ID);
    }

    /**
     * Returns the number of events this Speaker is speaking at
     * @return the size of the list of event IDs
     */
    public int getNumberOfEvents(){
        return this.listOfEventIDs.size();
    }

}
