package GUIPresenters;

import entities.User;
import useCases.UserManager;

public class EventPresenter {

    public static void nextEventPanel(String eventPanelChoice, User u){
        switch (eventPanelChoice){

        }
    }

    public static String[] eventOptions(User u){
        return UserManager.getEventOptionsList(u);
    }
}
