package persistence;

import model.Rating;
import java.util.List;

public interface IRatingRepository {
    boolean create(Rating rating);
    Rating findById(String id);
    List<Rating> findByMediaId(String mediaId);
    List<Rating> findByUsername(String username);
    boolean update(Rating rating);
    boolean deleteById(String id);
    boolean deleteByMediaAndUser(String mediaId, String username);
    List<Rating> findAll();
}
