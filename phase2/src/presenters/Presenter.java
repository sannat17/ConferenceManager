package presenters;

import java.util.HashMap;

public abstract class Presenter {

    /**
     * Format and return the given options
     *
     * @param options the list of options
     * @return the formatted string derived from the given options
     */
    public static String formatOptions(HashMap<Integer, String> options){
        StringBuilder formattedOptions = new StringBuilder();

        for (Integer key : options.keySet()) {
            formattedOptions.append(key.toString()).append(". ").append(options.get(key)).append("\n");
        }

        return formattedOptions.toString();
    }

}
