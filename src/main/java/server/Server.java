package server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;


public class Server {
    private final int port;
    private HttpServer httpServer;

    public Server(int port) { this.port = port; }

    public void start() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(port), 0);

        Router router = new Router();
        httpServer.createContext("/", exchange -> {
            try {
                Request req = Request.from(exchange);
                Response res = new Response(exchange);
                router.handle(req, res);
            } catch (Exception e) {
                new Response(exchange).json(500, Map.of("error", "Internal server error"));
            } finally {
                exchange.close();
            }
        });

        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("[Server] Listening on http://localhost:" + port);
    }

    public void stop() { if (httpServer != null) httpServer.stop(0); }

    public static void main(String[] args) throws Exception {
        new Server(8080).start();
    }
}
