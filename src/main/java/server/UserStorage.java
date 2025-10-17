package server;

import model.User;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserStorage implements IUserStorage {
    private final Path file;
    public UserStorage(String path) { this.file = Path.of(path); }

    @Override
    public void loadInto(Map<String, User> target) throws Exception {
        target.clear();
        if (!Files.exists(file)) {
            Files.createDirectories(file.getParent());
            return;
        }
        List<User> list = Json.readListFromFile(file.toString(), User.class);
        for (User u : list)
            if (u != null && u.getUsername() != null) {
            target.put(u.getUsername(), u);
        }
    }

    @Override
    public void saveAll(Map<String, User> source) throws Exception {
        Files.createDirectories(file.getParent());
        Json.writeListToFile(new ArrayList<>(source.values()), file.toString());
    }
}

