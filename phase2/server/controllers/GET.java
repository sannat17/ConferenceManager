package controllers;

import express.http.request.Request;
import express.http.response.Response;

import java.io.File;
import java.nio.file.Paths;

public class GET {

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

    /** An event handler for GET requests to the /json path.
     * Responds with the raw JSON file associated with this user, or 404 if user is not found
     */
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

}
