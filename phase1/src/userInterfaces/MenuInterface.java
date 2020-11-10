package userInterfaces;

import controllers.MenuInput;
import presenters.MenuPresenter;

import java.util.ArrayList;

/** A user interface for interacting with the menu */
public class MenuInterface {

    /**
     * Create a new MenuInterface
     */
    public MenuInterface(){}

    public static void main(String[] args) {
        System.out.println(MenuPresenter.getOptions(new ArrayList<>()));

        MenuInput.getMenuChoice("messages");
    }
}
