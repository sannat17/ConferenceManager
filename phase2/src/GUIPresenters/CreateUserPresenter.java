package GUIPresenters;

import useCases.UserManager;

public class CreateUserPresenter {
    public static void createNewUser(String username, String password, String name, String type){
        UserManager.makeNewUser(username, password, name, type);
    }
}
