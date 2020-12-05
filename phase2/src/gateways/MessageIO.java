package gateways;

import useCases.MessageManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageIO {
    private static final String delimiter = Character.toString((char) 31);

    /**
     * reads in messages file and passes message data to MessageManager
     */
    public static void readFile() {
        try {
            String dir = "./src/data/messages.txt";
            File file = new File(dir);
            Scanner fs = new Scanner(file);

            while (fs.hasNextLine()) {
                //file format ID-Username-Password-Type
                String[] user = fs.nextLine().split(delimiter);
                int senderID = Integer.parseInt(user[0]);
                int statusID = Integer.parseInt(user[1]);
                int receiverID = Integer.parseInt(user[2]);
                int messageID = Integer.parseInt(user[3]);
                int replyToID = Integer.parseInt(user[4]);
                String messageContent = user[5];
                MessageManager.makeMessage(senderID, statusID, receiverID, messageID, replyToID, messageContent);
            }
        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    /**
     * writes all user data from MessageManager to file
     */
    public static void writeFile(){
        try{
            String dir = "./src/data/messages.txt";
            File file = new File(dir);
            boolean existing = file.createNewFile(); //attempt to create new file if not preexisting

            FileWriter writer = new FileWriter(dir);
            ArrayList<String> info = MessageManager.getAllMessageInfo();
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
