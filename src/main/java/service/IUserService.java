package service;

import model.User;
import java.util.List;

public interface IUserService {
    boolean login(User user);
    boolean register(User user);

    /*
    boolean logout(User user);
    boolean changePassword(String username, String oldPw, String newPw);
    User getByUsername(String username);
    List<User> listUsers();
     */
}
