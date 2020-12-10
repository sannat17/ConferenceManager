package gateways;

import org.json.JSONArray;
import useCases.EventSorter;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class EventExporter{

    public static void requestExport(int userID) throws IOException {
        JSONArray eventsJSON = new JSONArray(EventSorter.sortBy("time"));
        System.out.println(userID);
        URL url = new URL("http://localhost:5000/upload/" + userID);
        HttpURLConnection req = (HttpURLConnection) url.openConnection();
        req.setRequestMethod("POST");
        req.setRequestProperty("Content-Type", "application/json");
        req.setDoOutput(true);
        req.connect();

        System.out.println(eventsJSON);

        try{
            OutputStream os = req.getOutputStream();
            byte[] bytes = eventsJSON.toString().getBytes();
            os.write(bytes, 0, bytes.length);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        req.getInputStream();
        System.out.println("POST attempted");
    }

}