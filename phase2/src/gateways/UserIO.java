package gateways;

import useCases.UserManager;

import java.util.ArrayList;

public class UserIO extends AbstractIO {
    //handles reading and writing from user file

    private static final String delimiter = Character.toString((char) 31);

    /**
     * reads in user file and passes user data to UserManager
     */
    public static void readFile(){
        String dir = "./src/data/users.txt";

        ArrayList<String> data = read(dir);
        data.forEach((String value) -> {
            //file format ID-Username-Password-Name-Type-eventIDs-dietaryRestrictions-accessibilityRequirements
            String[] user = value.split(delimiter);
            Integer ID = Integer.parseInt(user[0]);
            String username = user[1];
            String password = user[2];
            String name = user[3];
            String type = user[4];
            String dietaryRestrictions = user[5];
            String accessibilityRequirements = user[6];
            UserManager.loadUser(ID, username, password, name, type, dietaryRestrictions, accessibilityRequirements);
        });
    }

    /**
     * writes all user data from UserManager to file
     */
    public static void writeFile(){
        String dir = "./src/data/users.txt";
        ArrayList<String> info = UserManager.getAllUsersInfo();
        write(dir, info);
    }

}