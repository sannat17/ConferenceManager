package entities;

import java.util.ArrayList;

public class Speaker extends User{
    /**
     * Has the list of IDs of events that the Speaker is speaking at
     */
    ArrayList listOfEventIDs;

    /**
     * Calls the super constructor from Organizer
     * @param username
     * @param password
     * @param ID
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
