package handler;

import model.User;
import service.IUserService;
import java.util.List;

public class UserHandler {
    private final IUserService userService;

    public UserHandler(IUserService userService) { this.userService = userService; }

    public boolean login(User user) {
        if (user == null) return false;
        if (user.getUsername() == null || user.getUsername().isBlank()) return false;
        if (user.getPassword() == null || user.getPassword().isBlank()) return false;
        return userService.login(user);
    }

    public boolean register(User user) { return userService.register(user); }
    public boolean logout(User user) { return userService.logout(user); }
    public boolean changePassword(String username, String oldPw, String newPw) {
        return userService.changePassword(username, oldPw, newPw);
    }
    public User getUser(String username) { return userService.getByUsername(username); }
    public List<User> listUsers() { return userService.listUsers(); }
}
