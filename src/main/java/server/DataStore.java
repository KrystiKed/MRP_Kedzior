package server;

import model.User;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DataStore {
    public static final Map<String, User> usersByName = new ConcurrentHashMap<>();
    private DataStore() {}
}

