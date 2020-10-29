package entities;

import java.awt.*;

public class Speaker extends Organizer{

    int numberOfTalks;
    List listOfTalks;

    public Speaker(String username, String password, int ID) {
        super(username, password, ID, listOfTalks);
        numberOfTalks = 0;
    }

    public int getNumberOfTalks(){
        return this.numberOfTalks;
    }

    public void addTalk(Talk newTalk){
        this.listOfTalks.add(newTalk);
        numberOfTalks++;
    }

}
