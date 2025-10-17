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

    public boolean register(User user) {
        if (user == null) return false;
        String u = user.getUsername();
        String p = user.getPassword();
        if (u == null || u.isBlank() || p == null || p.isBlank()) return false;
        return userService.register(new User(u.trim(), p));
    }

    /*
    public boolean logout(User user) { return userService.logout(user); }
    public boolean changePassword(String username, String oldPw, String newPw) {
        return userService.changePassword(username, oldPw, newPw);
    }
    public User getUser(String username) { return userService.getByUsername(username); }
    public List<User> listUsers() { return userService.listUsers(); }
     */
}
