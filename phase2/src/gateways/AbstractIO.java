package gateways;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AbstractIO {

    /** Reads in file contents
     * @param dir: the path of the target file
     * @return an string list of raw lines
     */
    public static ArrayList<String> read(String dir){
        ArrayList<String> data = new ArrayList<>();
        try{
            File file = new File(dir);
            Scanner fs = new Scanner(file);
            while(fs.hasNextLine()){
                data.add(fs.nextLine());
            }
            return data;
        }
        catch(Exception e){
            System.out.println("An error has occurred reading");
            e.printStackTrace();
        }
        return data;
    }

    /** Writes content of string list to file
     * @param dir: the path of the target file
     * @param contents: a list of string to write to file, line by line
     */
    public static void write(String dir, ArrayList<String> contents){
        try{
            File file = new File(dir);
            boolean existing = file.createNewFile(); //attempt to create new file if not preexisting

            FileWriter writer = new FileWriter(dir);
            contents.forEach((String value) -> {
                try {
                    writer.write(value + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.close();
        }
        catch(Exception e){
            System.out.println("An error has occurred writing.");
            e.printStackTrace();
        }
    }
}
