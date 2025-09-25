package service;

import model.UserModel;
import java.util.List;

public interface IUserService {
    boolean login(UserModel user);

    boolean register(UserModel user);
    boolean logout(UserModel user);
    boolean changePassword(String username, String oldPw, String newPw);
    UserModel getByUsername(String username);
    List<UserModel> listUsers();
}
