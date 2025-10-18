package server;

import com.sun.net.httpserver.HttpServer;
import controller.UserController;
import handler.UserHandler;
import service.IUserService;
import service.UserService;
import service.AuthService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;


public class Server {
    private final int port;
    private HttpServer httpServer;

    public Server(int port) { this.port = port; }

    public void start() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(port), 0);

        IUserStorage storage = new UserStorage("data/users.json");
        try {
            storage.loadInto(DataStore.usersByName);
        }
        catch (Exception e) {
            System.err.println("users.json load: " + e.getMessage());
        }

        IUserService userService = new UserService(storage);
        UserHandler userHandler = new UserHandler(userService);
        AuthService authService = new AuthService();
        Router router = new Router(new UserController(userHandler,  authService));


        httpServer.createContext("/", exchange -> {
            try {
                Request req = Request.from(exchange);
                Response res = new Response(exchange);
                router.handle(req, res);
            } catch (Exception e) {
                try { new Response(exchange).json(500, Map.of("error", "Internal server error")); }
                catch (Exception ignored) {}
            } finally {
                exchange.close();
            }
        });

        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("[Server] Listening on http://localhost:" + port);
    }

    public static void main(String[] args) throws Exception {
        new Server(8080).start();
    }
}
