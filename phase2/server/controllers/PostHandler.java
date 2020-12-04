package controllers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PostHandler implements HttpHandler {

    public void handle(HttpExchange req) throws IOException{

        if(!req.getRequestMethod().equals("POST"))
            return;

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(req.getRequestBody(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

        req.sendResponseHeaders(200, 0);
    }

}
