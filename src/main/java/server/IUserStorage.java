package server;

import model.User;
import java.util.Map;

public interface IUserStorage {
    void loadInto(Map<String, User> target) throws Exception;
    void saveAll(Map<String, User> source) throws Exception;
}
