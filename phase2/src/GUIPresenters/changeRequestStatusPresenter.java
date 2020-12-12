package GUIPresenters;

import GUI.mainView;
import com.sun.javafx.image.IntPixelGetter;
import useCases.UserManager;

import java.util.HashMap;

/** A presenter of which formats the additional user requests */
public class changeRequestStatusPresenter {

    /**
     * Change a particular user's additional request status
     *
     * @param userID the ID of the user
     * @param accommodation the specific additional request to be changed
     * @param status the status of which the request is changed to
     */
    public static void changeRequestStatus(int userID, String accommodation, String status) {
        if (accommodation.equals("Change Dietary Restrictions Status")) {
            changeDietRestrictionStatus(userID, status);
        } else if (accommodation.equals("Change Accessibility Requirements Status")) {
            changeAccessibilityRequirementStatus(userID, status);
        }
    }

    /**
     * Change a particular user's dietary restriction status
     *
     * @param userID the ID of the user
     * @param status the status of which the request is changed to
     */
    public static void changeDietRestrictionStatus(int userID, String status) {
        UserManager.setDietaryRestrictionStatus(userID, status);
    }

    /**
     * Change a particular user's accessibility requirement status
     *
     * @param userID the ID of the user
     * @param status the status of which the request is changed to
     */
    public static void changeAccessibilityRequirementStatus(int userID, String status) {
        UserManager.setAccessibilityRequirementStatus(userID, status);
    }

    /**
     * Displays the message
     * @param message the message being displayed
     */
    public static void createMessagePopUp(String message){
        mainView.createPopUp(message);
        mainView.toPanel("Menu");;
    }
}
