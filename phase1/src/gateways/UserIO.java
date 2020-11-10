package gateways;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class UserIO {
    private static final String delimiter = Character.toString((char) 31);

    public static HashMap<String, String> readFile(){
        //reads in user file and returns HashMap mapping username to password

        HashMap<String, String> map = new HashMap<String, String>();

        try{
            File file = new File("example_file.txt");
            Scanner fs = new Scanner(file);

            while(fs.hasNextLine()){
                String[] user = fs.nextLine().split(delimiter);
                String username = user[0];
                String password = user[1];
                map.put(username, password);
            }
        }
        catch(Exception e){
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        return map;
    }

    public static void writeFile(){

    }
}
