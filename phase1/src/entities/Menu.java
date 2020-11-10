package entities;

import java.util.ArrayList;

/** A menu of which contains a list of options */
public class Menu {

    /** The list of options for this menu */
    public ArrayList options;

    /**
     * Create a new Menu with list of options
     *
     * @param options the list of options
     */
    public Menu(ArrayList options) {
        this.options = options;
    }

    /**
     * Return the list of options corresponding to this menu
     *
     * @return the list of options corresponding to this menu
     */
    public ArrayList getOptions() {
        return this.options;
    }
}
