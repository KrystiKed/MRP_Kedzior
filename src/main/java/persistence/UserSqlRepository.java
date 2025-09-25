package persistence;

import model.UserModel;
import java.util.ArrayList;
import java.util.List;

public class UserSqlRepository implements IUserRepository {

    private static final UserSqlRepository INSTANCE = new UserSqlRepository();
    public static UserSqlRepository getInstance() { return INSTANCE; }

    private final List<UserModel> users = new ArrayList<>();

    private UserSqlRepository() {}

    @Override
    public boolean login(UserModel user) {

        for (UserModel u : users) {
            if (u.getUsername().equals(user.getUsername())
                    && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean create(UserModel user) {

        if (user == null || user.getUsername() == null) return false;
        if (findByUsername(user.getUsername()) != null) return false;
        return users.add(user);
    }

    @Override
    public UserModel findByUsername(String username) {
        if (username == null) return null;
        for (UserModel u : users) {
            if (username.equals(u.getUsername())) return u;
        }
        return null;
    }

    @Override
    public boolean update(UserModel user) {

        return false;
    }

    @Override
    public boolean deleteByUsername(String username) {
        return users.removeIf(u -> username != null && username.equals(u.getUsername()));
    }

    @Override
    public List<UserModel> findAll() {
        return new ArrayList<>(users);
    }
}
