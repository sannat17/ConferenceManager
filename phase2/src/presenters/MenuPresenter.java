package presenters;

import java.util.ArrayList;

/** A menu presenter that formats menu options to display */
public class MenuPresenter {

    /**
     * Format and return the given options
     *
     * @param options the list of options
     * @return the formatted string derived from the given options
     */
    public static String formatOptions(ArrayList<String> options){
        StringBuilder formattedOptions = new StringBuilder();
        for (String option : options) {
            formattedOptions.append(option).append("\n");
        }
        return formattedOptions.toString();
    }
}
