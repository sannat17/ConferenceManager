import express.Express;
import express.http.request.Request;
import express.http.response.Response;
import express.middleware.Middleware;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class Server{

    public static void main(String[] args){
        try {
            System.out.println("Server started on port 5000");

            Express app = new Express();
            app.listen(5000);

            app.use(Middleware.statics("./server/sites"));

            app.get("/:id", Server::handleGet);
            app.get("/json/:id", Server::handleGetJSON);
            app.post("/upload/:id", Server::handlePost);

            app.get("*", (req, res) -> {
                res.send("404. Please check that your URL is correct.");
            });

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handleGet(Request req, Response res){
        //get userID field
        //serve webpage alongside JSON, will generate on client side
        String userID = req.getParam("id");
        File userJSON = new File("./server/users/" + userID + ".json");
        if(userJSON.exists()){
            res.send(Paths.get("./server/sites/index.html"));
        }
        else{
            res.send("404: User not found");
        }
    }

    public static void handleGetJSON(Request req, Response res){
        String userID = req.getParam("id");
        File userJSON = new File("./server/users/" + userID + ".json");
        if(userJSON.exists()){
            res.send(Paths.get("./server/users/" + userID + ".json"));
        }
        else{
            res.send("404");
        }
    }

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