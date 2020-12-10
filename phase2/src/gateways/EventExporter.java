package gateways;

import org.json.JSONArray;
import useCases.EventSorter;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class EventExporter{

    public static void requestExport() throws IOException {
        JSONArray eventsJSON = new JSONArray(EventSorter.sortBy("time"));
        URL url = new URL("http://35.202.216.223:5000/upload/0");
        HttpURLConnection req = (HttpURLConnection) url.openConnection();
        req.setRequestMethod("POST");
        req.setRequestProperty("Content-Type", "application/json");
        req.setDoOutput(true);
        req.connect();

        System.out.println("22");
        System.out.println(eventsJSON);

        try{
            System.out.println("26");
            OutputStream os = req.getOutputStream();
            byte[] bytes = eventsJSON.toString().getBytes();
            os.write(bytes, 0, bytes.length);
            System.out.println("29");
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("36");
        req.getInputStream();
        System.out.println("POST attempted");
    }

}