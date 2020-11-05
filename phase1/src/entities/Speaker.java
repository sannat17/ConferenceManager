package entities;

import java.util.ArrayList;

public class Speaker extends User{

    int numberOfEvents;
    ArrayList listOfEventIDs;

    public Speaker(String username, String password, int ID) {
        super(username, password, ID);
        numberOfEvents = 0;
    }

    public int getNumberOfEvents(){
        return this.numberOfEvents;
    }

    public void addTalk(Event newEvent){
        listOfEventIDs.add(newEvent);
        numberOfEvents++;
    }

}
