package service;

import model.User;
import server.DataStore;
import server.IUserStorage;

public class UserService implements IUserService {

    private final IUserStorage storage;

    public UserService(IUserStorage storage) {

        this.storage = storage;
    }

    /* private static UserService instance = null;
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
*/
    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean register(User user) {

        if (user == null || isBlank(user.getUsername()) || isBlank(user.getPassword())) return false;
        String uname = user.getUsername().trim();
        if (DataStore.usersByName.containsKey(uname)) return false;
        DataStore.usersByName.put(uname, new User(uname, user.getPassword()));

        try {
            storage.saveAll(DataStore.usersByName);
        } catch (Exception ignored) {
        }

        return true;
    }

    private static boolean isBlank(String s) {return s == null || s.isEmpty();}

    /*
    @Override
    public boolean logout(User user) {

        return true;
    }

    @Override
    public boolean changePassword(String username, String oldPw, String newPw) {

        return false;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
     */
}
