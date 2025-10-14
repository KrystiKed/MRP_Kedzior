package server;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class Request {
    private final HttpExchange ex;
    private final String method;
    private final String path;
    private final Map<String,String> query;

    private Request(HttpExchange ex) {
        this.ex = ex;
        this.method = ex.getRequestMethod();
        URI uri = ex.getRequestURI();
        this.path = uri.getPath();
        this.query = Urls.parseQuery(uri.getRawQuery());
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
}
