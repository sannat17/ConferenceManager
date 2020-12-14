import controllers.GET;
import controllers.POST;
import express.Express;
import express.middleware.Middleware;

public class Server{

    public static void main(String[] args) {
        try {
            System.out.println("Server started on port 5000");

            Express app = new Express();
            app.listen(5000);

            app.use(Middleware.statics("./server/sites"));

            app.get("/:id", GET::handleGet);
            app.get("/json/:id", GET::handleGetJSON);
            app.post("/upload/:id", POST::handlePost);

            app.get("*", (req, res) -> {
                res.send("404. Please check that your URL is correct.");
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}