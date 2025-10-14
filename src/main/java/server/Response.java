package server;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public final class Response {
    private final HttpExchange ex;

    public Response(HttpExchange ex) { this.ex = ex; }

    public void json(int status, Object payload) {
        try {
            byte[] data = Json.writeBytes(payload);
            ex.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
            ex.sendResponseHeaders(status, data.length);
            try (OutputStream os = ex.getResponseBody()) { os.write(data); }
        } catch (Exception e) {
            plain(500, "Internal server error");
        }
    }

    public void plain(int status, String text) {
        try {
            byte[] data = text.getBytes(StandardCharsets.UTF_8);
            ex.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
            ex.sendResponseHeaders(status, data.length);
            try (OutputStream os = ex.getResponseBody()) { os.write(data); }
        } catch (IOException ignored) {}
    }
}
