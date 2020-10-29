package entities;

import java.util.ArrayList;

public class EventAttendants {

    ArrayList<User> attending;

    public EventAttendants(User user){
        this.attending.add(user);
    }
}
