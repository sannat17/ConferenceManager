package gateways;

import java.io.File;
import java.util.Scanner;

public class FileReader {

    // set delimiter to ascii unit separator by default
    private static final String delimiter = Character.toString((char) 31);

    public static void readFile(){
        try{
            File file = new File("example_file.txt");
            Scanner fs = new Scanner(file);

            while(fs.hasNextLine()){
                String[] header = fs.nextLine().split(delimiter); // all metadata goes here
                String body = fs.nextLine(); // all content goes here
                //... implementations go here
            }
        }
        catch(Exception e){
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}
