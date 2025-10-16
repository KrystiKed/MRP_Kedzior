package server;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.LinkedHashMap;
import java.net.URLDecoder;

public final class Request {
    private final HttpExchange ex;
    private final String method;
    private final String path;
    private final Map<String,String> query;

    private Request(HttpExchange ex) {
        this.ex = ex;
        this.method = ex.getRequestMethod();
        URI uri = ex.getRequestURI();
        this.path = (uri.getPath() == null || uri.getPath().isEmpty()) ? "/" : uri.getPath();
        this.query = parseQuery(uri.getRawQuery());
    }
    public static Request from(HttpExchange ex) { return new Request(ex); }

    public HttpExchange exchange() { return ex; }
    public String method() { return method; }
    public String path() { return path; }
    public Map<String,String> query() { return query; }

    public String bodyString() throws IOException {
        return new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
    }

    public String header(String name) {
        var values = ex.getRequestHeaders().get(name);
        return (values == null || values.isEmpty()) ? null : values.get(0);
    }

    private static Map<String,String> parseQuery(String raw) {
        Map<String,String> out = new LinkedHashMap<>();
        if (raw == null || raw.isEmpty()) return out;

        String[] pairs = raw.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf('=');
            String k = decode(idx >= 0 ? pair.substring(0, idx) : pair);
            String v = decode(idx >= 0 ? pair.substring(idx + 1) : "");
            out.putIfAbsent(k, v);
        }
        return out;
    }

    private static String decode(String s) {
        try {
            return URLDecoder.decode(s, StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            return s;
        }
    }
}
