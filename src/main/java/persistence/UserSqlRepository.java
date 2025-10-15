package persistence;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserSqlRepository implements IUserRepository {

    private static final UserSqlRepository INSTANCE = new UserSqlRepository();
    public static UserSqlRepository getInstance() { return INSTANCE; }

    private final List<User> users = new ArrayList<>();

    private UserSqlRepository() {}

    @Override
    public boolean login(User user) {

        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())
                    && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean create(User user) {

        if (user == null || user.getUsername() == null) return false;
        if (findByUsername(user.getUsername()) != null) return false;
        return users.add(user);
    }

    @Override
    public User findByUsername(String username) {
        if (username == null) return null;
        for (User u : users) {
            if (username.equals(u.getUsername())) return u;
        }
        return null;
    }

    @Override
    public boolean update(User user) {

        return false;
    }

    @Override
    public boolean deleteByUsername(String username) {
        return users.removeIf(u -> username != null && username.equals(u.getUsername()));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}
