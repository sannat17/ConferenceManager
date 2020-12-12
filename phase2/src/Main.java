import GUI.mainView;
import gateways.*;


public class Main {
    public static void main(String[] args) {
        UserIO.readFile();
        EventIO.readFile();
        MessageIO.readFile();
        new mainView();
    }
}
