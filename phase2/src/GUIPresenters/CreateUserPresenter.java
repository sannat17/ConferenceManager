package GUIPresenters;

import GUI.mainView;
import useCases.UserManager;

public class CreateUserPresenter {
    /**
     * Creates a new user
     * @param username Username of the user
     * @param password Password of the user
     * @param name Name of the user
     * @param type Type of the user
     * @param dietaryRestrictions Dietary Restrictions of the user
     * @param accessibilityRequirements Accessibility Requirements
     */
    public static void createNewUser(String username, String password, String name, String type, String dietaryRestrictions,
                                     String accessibilityRequirements){
        boolean userBool = UserManager.makeNewUser(username, password, name, type, dietaryRestrictions, accessibilityRequirements);
        if (!userBool){
            mainView.createPopUp("Could not create this user");
        }
        else{
            mainView.createPopUp("User Created!");
            mainView.toPanel("Menu");
        }
    }
}
