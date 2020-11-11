package presenters;

import java.util.ArrayList;

/** A message presenter that formats message options to display */
public class MessagePresenter {

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
