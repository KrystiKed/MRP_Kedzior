package server;

import java.util.Map;

public class Router {
    public void handle(Request req, Response res) {
        String method = req.method();
        String path = req.path();


        if ("GET".equals(method) && "/test".equals(path)) {
            res.json(200, Map.of("status", "working"));
            return;
        }
        res.json(404, Map.of("error", "Route not found!"));
    }
}
