package entities;

import java.util.ArrayList;

public class Organizer extends User{

    ArrayList listOfEventIDs;

    public Organizer(String username, String password, int ID) {
        super(username, password, ID);
        this.listOfEventIDs = new ArrayList();
    }

    public ArrayList getListOfEvents(){
        return this.listOfEventIDs;
    }

    public void addEvent(Event newEvent){
        listOfEventIDs.add(newEvent);
    }

}
