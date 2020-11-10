package entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Attendee extends User{

    private ArrayList<Integer> listOfEventIDs;

    /**
     * Initializes an Attendee by calling the super constructor from User
     * @param username
     * @param password
     * @param ID
     */
    public Attendee(String username, String password, int ID, String name) {
        super(username, password, ID, name);
    }

    @Override
    public String toString() {
        String delimiter = Character.toString((char) 31);
        return super.toString() + delimiter + "attendee" + delimiter + listOfEventIDs.toString();
    }

     public void addEvent(int eventID) {
        listOfEventIDs.add(eventID);
     }

     @Override
     public ArrayList<Integer> getListOfEventIDs() {
        return listOfEventIDs;
     }
}
