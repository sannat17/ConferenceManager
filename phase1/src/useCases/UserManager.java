package useCases;
import controllers.LoginSystem;
import java.io.*;
import java.util.*;

//returns true if they can login and false if they cant
//users are saved in the Login class as "Username, Password"
public class UserManager{
    public static boolean login() {
        try {
            Scanner myReader = new Scanner(new File("Login.txt"));
            String[] loginDetails = LoginSystem.getLoginInformation();
            String[] loginCheck = new String[2];
            while (myReader.hasNextLine()){
                String curr = myReader.nextLine();
                loginCheck = curr.split(", ");
                if ((loginDetails[0].equals(loginCheck[0])) && (loginDetails[1].equals(loginCheck[1]))){
                    myReader.close();
                    return true;
                }
            }
            myReader.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Login.txt is missing");
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(login());
    }
}