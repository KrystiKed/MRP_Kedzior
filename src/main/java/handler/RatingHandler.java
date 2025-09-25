package handler;

import model.RatingModel;
import service.IRatingService;
import java.util.List;

public class RatingHandler {
    private final IRatingService ratingService;

    public RatingHandler(IRatingService ratingService) { this.ratingService = ratingService; }

    public boolean add(RatingModel rating) {
        if (rating == null || rating.getId() == null) return false;
        return ratingService.add(rating);
    }

    public RatingModel get(String id) { return ratingService.get(id); }

    public List<RatingModel> byMedia(String mediaId) { return ratingService.listByMedia(mediaId); }

    public List<RatingModel> byUser(String username) { return ratingService.listByUser(username); }

    public boolean edit(RatingModel rating) { return ratingService.edit(rating); }

    public boolean remove(String id) { return ratingService.remove(id); }

    public boolean removeForMediaByUser(String mediaId, String username) {
        return ratingService.removeForMediaByUser(mediaId, username);
    }

    public Double average(String mediaId) { return ratingService.averageForMedia(mediaId); }

    public List<RatingModel> listAll() { return ratingService.listAll(); }
}
