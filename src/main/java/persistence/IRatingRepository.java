package persistence;

import model.RatingModel;
import java.util.List;

public interface IRatingRepository {
    boolean create(RatingModel rating);
    RatingModel findById(String id);
    List<RatingModel> findByMediaId(String mediaId);
    List<RatingModel> findByUsername(String username);
    boolean update(RatingModel rating);
    boolean deleteById(String id);
    boolean deleteByMediaAndUser(String mediaId, String username);
    List<RatingModel> findAll();
}
