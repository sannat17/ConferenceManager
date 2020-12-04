package gateways;

import useCases.EventManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class EventIO {
    private static final String delimiter = Character.toString((char) 31);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    /**
     * reads in events file and passes event data to EventManager
     */
    public static void readFile(){
        try{
            String dir = "./phase2/src/data/events.txt";
            File file = new File(dir);
            Scanner fs = new Scanner(file);

            while(fs.hasNextLine()){
                //file format ID-Username-Password-Type
                String[] user = fs.nextLine().split(delimiter);
                int eventID = Integer.parseInt(user[0]);
                String title = user[1];
                LocalDateTime timeOfEvent = LocalDateTime.parse(user[2], formatter);
                int roomNumber = Integer.parseInt(user[3]);
                int speakerID = Integer.parseInt(user[4]);
                int organizerID = Integer.parseInt(user[5]);
                ArrayList<Integer> attendees = toIntArray(user[6]);
                EventManager.makeEvent(eventID, title, timeOfEvent, roomNumber, speakerID, organizerID, attendees);
            }
        }
        catch(Exception e){
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    /**
     * converts comma-separated string to array of integers
     * @param csv - a string with comma separated values
     */
    private static ArrayList<Integer> toIntArray(String csv){
        csv = csv.substring(1, csv.length() - 1);
        //converts string with comma-separated values to an integer ArrayList
        ArrayList<Integer> intList = new ArrayList<Integer>();

        //The csv.split will lead to unexpected outcome when given a string with no element or just 1 element (ie without the delimiter)
        if (csv.isEmpty()){return intList;}
        if (csv.length() == 1){
            intList.add(Integer.parseInt(csv));
            return intList;
        }
        // Once that is dealt with, continue as normal

        String[] list = csv.split(", ");
        for(String v: list){
            intList.add(Integer.parseInt(v));
        }
        return intList;
    }

    /**
     * writes all event data from event to file
     */
    public static void writeFile(){
        try{
            String dir = "./phase2/src/data/events.txt";
            File file = new File(dir);
            boolean existing = file.createNewFile(); //attempt to create new file if not preexisting

            FileWriter writer = new FileWriter(dir);
            ArrayList<String> info = EventManager.getAllEventsInfo();
            info.forEach((String value) -> {
                try {
                    writer.write(value + "\n");
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
