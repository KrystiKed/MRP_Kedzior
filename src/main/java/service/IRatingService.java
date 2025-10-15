package service;

import model.Rating;
import java.util.List;

public interface IRatingService {
    boolean add(Rating rating);
    Rating get(String id);
    List<Rating> listByMedia(String mediaId);
    List<Rating> listByUser(String username);
    boolean edit(Rating rating);
    boolean remove(String id);
    boolean removeForMediaByUser(String mediaId, String username);
    List<Rating> listAll();

    Double averageForMedia(String mediaId);
}
