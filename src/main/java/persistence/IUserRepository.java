package persistence;

import model.UserModel;
import java.util.List;

public interface IUserRepository {
    boolean login(UserModel user);

    boolean create(UserModel user);
    UserModel findByUsername(String username);
    boolean update(UserModel user);
    boolean deleteByUsername(String username);
    List<UserModel> findAll();
}
