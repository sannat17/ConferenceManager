package controllers;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GetHandler implements HttpHandler {

    public void handle(HttpExchange req) throws IOException{

        if(!req.getRequestMethod().equals("GET"))
            return;

        System.out.println("GET requested");

        String path = "./phase2/server/templates/index.html";
        File file = new File(path);
        String mime = "text/html";

        Headers h = req.getResponseHeaders();
        h.set("Content-Type", mime);
        req.sendResponseHeaders(200, 0);

        OutputStream os = req.getResponseBody();
        FileInputStream fs = new FileInputStream(file);
        final byte[] buffer = new byte[0x10000];
        int count = 0;
        while ((count = fs.read(buffer)) >= 0) {
            os.write(buffer,0,count);
        }
        fs.close();
        os.close();
    }

}
