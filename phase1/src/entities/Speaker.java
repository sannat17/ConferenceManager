package entities;

import java.util.ArrayList;

public class Speaker extends Organizer{

    int numberOfEvents;
    ArrayList listOfEvents;

    public Speaker(String username, String password, int ID) {
        super(username, password, ID);
        numberOfEvents = 0;
    }

    public int getNumberOfTalks(){
        return this.numberOfEvents;
    }

    public void addTalk(Event newEvent){
        listOfEvents.add(newEvent);
        numberOfEvents++;
    }

}
