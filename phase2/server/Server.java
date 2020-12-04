import com.sun.net.httpserver.HttpServer;
import controllers.GetHandler;
import controllers.PostHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server{

    public static void main(String[] args){
        try {
            InetSocketAddress socket = new InetSocketAddress("localhost", 5000);
            HttpServer server = HttpServer.create(socket, 0);

            server.createContext("/upload", new PostHandler());
            server.createContext("/schedules", new GetHandler());
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
            server.setExecutor(executor);
            server.start();
            System.out.println(" Server started on port 5000");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}