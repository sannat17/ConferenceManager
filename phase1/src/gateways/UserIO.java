package gateways;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class UserIO {
    private static final String delimiter = Character.toString((char) 31);

    public static HashMap<String, String> readFile(String dir){
        //reads in user file and returns HashMap mapping username to password

        HashMap<String, String> map = new HashMap<String, String>();

        try{
            File file = new File(dir);
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

    public static void writeFile(HashMap<String, String> map, String dir){
        //writes map data to file
        try{
            File file = new File(dir);
            file.createNewFile(); //attempt to create new file if not preexisting

            FileWriter writer = new FileWriter(dir);
            map.forEach((String key, String value) -> {
                String line = key + delimiter + value;
                try {
                    writer.write(line);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            });
            writer.close();
        }
        catch(Exception e){
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}
