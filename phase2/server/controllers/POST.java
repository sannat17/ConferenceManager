package controllers;

import express.http.request.Request;
import express.http.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class POST {

    public static void handlePost(Request req, Response res) {
        //get userID field
        //stores json file associated with userID in users
        String userID = req.getParam("id");

        try {
            InputStream is = req.getBody();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            JSONParser jsonParser = new JSONParser();
            JSONArray eventsJSON = (JSONArray) jsonParser.parse(isr);

            String path = "./server/users/" + userID + ".json";
            FileWriter fw = new FileWriter(path);
            fw.write(eventsJSON.toJSONString());
            fw.flush();
            fw.close();
            res.send("http://35.202.216.223:5000/" + userID);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
