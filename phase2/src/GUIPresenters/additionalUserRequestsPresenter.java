package GUIPresenters;

import com.sun.javafx.image.IntPixelGetter;
import useCases.UserManager;

import java.util.HashMap;

/** A presenter of which formats the additional user requests */
public class additionalUserRequestsPresenter {

    /**
     * format and return a string of desired accommodations of all users
     *
     * @param accommodation a string describing the corresponding accommodation
     * @return a string that details the corresponding accommodations for all users
     */
    public static String formatAdditionalUserRequests(String accommodation) {
        if (accommodation.equals("Dietary Restrictions")) {
            return formatDietaryRestrictions(UserManager.getDietaryRestrictionsDict());
        } else if (accommodation.equals("Accessibility Requirements")) {
            return formatAccessibilityRequirements(UserManager.getAccessibilityRequirementsDict());
        }
        return "Invalid Option";
    }

    /**
     * format and return a string that details the dietary restrictions of all users
     *
     * @param dietaryRestrictionsDict a dictionary of which contains all dietary restrictions of all users
     * @return a string that details the additional user requests of all users
     */
    public static String formatDietaryRestrictions(HashMap<Integer, String> dietaryRestrictionsDict) {
        String dietaryRestrictions = "";
        for (int userID : dietaryRestrictionsDict.keySet()) {
            if (!(dietaryRestrictionsDict.get(userID).equals("\"\""))) {
                dietaryRestrictions += "ID: " + Integer.toString(userID) + dietaryRestrictionsDict.get(userID) +
                " (" + UserManager.getUser(userID).getDietaryRestrictionsStatus() + ")\n";
            }
        }
        return dietaryRestrictions;
    }

    /**
     * format and return a string that details the accessibility requirements of all users
     *
     * @param accessibilityRequirementsDict a dictionary of which contains all dietary restrictions of all users
     * @return a string that details the additional user requests of all users
     */
    public static String formatAccessibilityRequirements(HashMap<Integer, String> accessibilityRequirementsDict) {
        String accessibilityRequirements = "";
        for (int userID : accessibilityRequirementsDict.keySet()) {
            if (!(accessibilityRequirementsDict.get(userID).equals("\"\""))) {
                accessibilityRequirements += "ID: " + Integer.toString(userID) + accessibilityRequirementsDict.get(userID) +
                        " (" + UserManager.getUser(userID).getAccessibilityRequirementsStatus() + ")\n";
            }
        }
        return accessibilityRequirements;
    }
}
