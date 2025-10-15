package handler;

import model.Rating;
import service.IRatingService;
import java.util.List;

public class RatingHandler {
    private final IRatingService ratingService;

    public RatingHandler(IRatingService ratingService) { this.ratingService = ratingService; }

    public boolean add(Rating rating) {
        if (rating == null || rating.getId() == null) return false;
        return ratingService.add(rating);
    }

    public Rating get(String id) { return ratingService.get(id); }

    public List<Rating> byMedia(String mediaId) { return ratingService.listByMedia(mediaId); }

    public List<Rating> byUser(String username) { return ratingService.listByUser(username); }

    public boolean edit(Rating rating) { return ratingService.edit(rating); }

    public boolean remove(String id) { return ratingService.remove(id); }

    public boolean removeForMediaByUser(String mediaId, String username) {
        return ratingService.removeForMediaByUser(mediaId, username);
    }

    public Double average(String mediaId) { return ratingService.averageForMedia(mediaId); }

    public List<Rating> listAll() { return ratingService.listAll(); }
}
