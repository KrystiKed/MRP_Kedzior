package service;

import model.RatingModel;
import java.util.List;

public interface IRatingService {
    boolean add(RatingModel rating);
    RatingModel get(String id);
    List<RatingModel> listByMedia(String mediaId);
    List<RatingModel> listByUser(String username);
    boolean edit(RatingModel rating);
    boolean remove(String id);
    boolean removeForMediaByUser(String mediaId, String username);
    List<RatingModel> listAll();

    Double averageForMedia(String mediaId);
}
