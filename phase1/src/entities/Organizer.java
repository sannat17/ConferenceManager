package entities;

import java.awt.*;

public class Organizer extends User{

    List listOfTalks;

    public Organizer(String username, String password, int ID) {
        super(username, password, ID);
        this.listOfTalks = new List();
    }

    public List getListOfTalks(){
        return this.listOfTalks;
    }

    public void addTalk(Talk newTalk){
        this.listOfTalks.add(newTalk);
    }

}
