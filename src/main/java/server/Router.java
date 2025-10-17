package server;

import controller.UserController;
import java.util.Map;

public class Router {
    private final UserController userController;
    public Router(UserController userController) {
        this.userController = userController;
    }

    public void handle(Request req, Response res) {
        String method = req.method();
        String path = req.path();

        if ("POST".equals(method) && "/api/users/register".equals(path)) {
            userController.register(req, res);
            return;
        }
        res.json(404, Map.of("error", "Route not found!"));
    }
}
