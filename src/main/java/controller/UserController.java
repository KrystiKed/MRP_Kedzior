package controller;

import handler.UserHandler;
import model.User;
import server.Json;
import server.Request;
import server.Response;

import java.util.Map;

public class UserController {
    private final UserHandler userHandler;
    public UserController(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    public void register(Request req, Response res) {
        try {
            Body b = Json.read(req.bodyString(), Body.class);
            if (b == null || isBlank(b.username) || isBlank(b.password)) {
                res.json(400, Map.of("error","invalid input")); return;
            }
            boolean ok = userHandler.register(new User(b.username, b.password));
            if (!ok) {
                res.json(409, Map.of("error","username already exists")); return;
            }
            res.json(201, Map.of("message","registered"));
        } catch (Exception e) {
            res.json(400, Map.of("error","invalid json"));
        }
    }

    private static boolean isBlank(String s){ return s==null || s.isBlank(); }
    private static final class Body { public String username; public String password; }
}
