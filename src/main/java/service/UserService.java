package service;

import model.UserModel;
import persistence.IUserRepository;
import java.util.List;

public class UserService implements IUserService {

    private static UserService instance = null;
    private final IUserRepository userRepository;

    private UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserService getInstance(IUserRepository userRepository) {
        if (instance == null) {
            instance = new UserService(userRepository);
        }
        return instance;
    }

    @Override
    public boolean login(UserModel user) {
        return userRepository.login(user);
    }

    @Override
    public boolean register(UserModel user) {

        return userRepository.create(user);
    }

    @Override
    public boolean logout(UserModel user) {

        return true;
    }

    @Override
    public boolean changePassword(String username, String oldPw, String newPw) {

        return false;
    }

    @Override
    public UserModel getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }
}
