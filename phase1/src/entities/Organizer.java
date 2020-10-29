package entities;

import java.util.ArrayList;

public class Organizer extends User{

    ArrayList listOfEvents;

    public Organizer(String username, String password, int ID) {
        super(username, password, ID);
        this.listOfEvents = new ArrayList();
    }

    public ArrayList getListOfEvents(){
        return this.listOfEvents;
    }

    public void addEvent(Event newEvent){
        listOfEvents.add(newEvent);
    }

}
