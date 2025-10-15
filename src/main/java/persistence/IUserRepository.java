package persistence;

import model.User;
import java.util.List;

public interface IUserRepository {
    boolean login(User user);

    boolean create(User user);
    User findByUsername(String username);
    boolean update(User user);
    boolean deleteByUsername(String username);
    List<User> findAll();
}
