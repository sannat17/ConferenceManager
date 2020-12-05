package gateways;

import org.json.JSONArray;
import sun.net.www.protocol.http.HttpURLConnection;
import useCases.EventManager;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class EventExporter{

    public static void requestExport(int userID) throws IOException {
        JSONArray eventsJSON = new JSONArray(EventManager.getAllEvents());
        URL url = new URL("http://localhost:5000/upload/" + userID);
        HttpURLConnection req = (HttpURLConnection) url.openConnection();
        req.setRequestMethod("POST");
        req.setRequestProperty("Content-Type", "application/json");
        req.setDoOutput(true);
        req.connect();

        try{
            OutputStream os = req.getOutputStream();
            byte[] bytes = getBytesFromJSON(eventsJSON);
            os.write(bytes, 0, bytes.length);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        req.getInputStream();
        System.out.println("POST attempted");
    }

    private static byte[] getBytesFromJSON(JSONArray json){
        return json.toString().getBytes();
    }

}