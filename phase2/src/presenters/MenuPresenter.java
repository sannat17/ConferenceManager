package presenters;

import java.util.ArrayList;
import java.util.HashMap;

/** A menu presenter that formats menu options to display */
public class MenuPresenter extends Presenter {

    /**
     * Create and returns a dictionary of the menu options
     *
     * @param options the list of options that needs to be organized
     * @return a dictionary of the menu options
     */
    public static HashMap<Integer, String> getOptionsDict(ArrayList<String> options) {
        HashMap<Integer, String> optionsDict = new HashMap<Integer, String>();
        int i = 1;
        for (String option : options) {
            if (!(optionsDict.containsValue(option))) {
                optionsDict.put(i, option);
                i += 1;
            }
        }
        return optionsDict;
    }

}
