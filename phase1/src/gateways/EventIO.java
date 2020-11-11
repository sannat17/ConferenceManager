package gateways;

import useCases.EventManager;
import useCases.UserManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EventIO {
    private static final String delimiter = Character.toString((char) 31);

    public static void readFile(String dir){
        //reads in user file and returns HashMap mapping username to password

        try{
            File file = new File(dir);
            Scanner fs = new Scanner(file);

            while(fs.hasNextLine()){
                //file format ID-Username-Password-Type
                String[] user = fs.nextLine().split(delimiter);
                int eventID = Integer.parseInt(user[0]);
                String timeOfEvent = user[1];
                int roomNumber = Integer.parseInt(user[2]);
                int speakerID = Integer.parseInt(user[3]);
                EventManager.makeEvent(eventID, timeOfEvent, roomNumber, speakerID);
            }
        }
        catch(Exception e){
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String dir){
        //writes all user data from EventManager to file
        try{
            File file = new File(dir);
            boolean existing = file.createNewFile(); //attempt to create new file if not preexisting

            FileWriter writer = new FileWriter(dir);
            ArrayList<String> info = EventManager.getAllEventsInfo();
            info.forEach((String value) -> {
                try {
                    writer.write(value);
                } catch (IOException e) {
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
