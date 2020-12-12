package gateways;

import useCases.EventManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EventIO extends AbstractIO {
    private static final String delimiter = Character.toString((char) 31);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    /**
     * reads in events file and passes event data to EventManager
     */
    public static void readFile(){
        String dir = "./src/data/events.txt";

        ArrayList<String> data = read(dir);
        data.forEach((String value) -> {
            //file format ID-Username-Password-Type
            String[] user = value.split(delimiter);
            int eventID = Integer.parseInt(user[0]);
            String title = user[1];
            LocalDateTime timeOfEvent = LocalDateTime.parse(user[2], formatter);
            int roomNumber = Integer.parseInt(user[3]);
            ArrayList<Integer> speakerIDs = toIntArray(user[4]);
            int organizerID = Integer.parseInt(user[5]);
            ArrayList<Integer> attendees = toIntArray(user[6]);
            boolean vip = Boolean.parseBoolean(user[7]);
            int maxCapacity = Integer.parseInt(user[8]);

            EventManager.loadEvent(eventID, title, timeOfEvent, roomNumber, speakerIDs, organizerID, attendees, vip,
                    maxCapacity);
        });
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
        String dir = "./src/data/events.txt";
        ArrayList<String> info = EventManager.getAllEventsInfo();
        write(dir, info);
    }
}
