package service;

import model.Rating;
import persistence.IRatingRepository;

import java.util.List;

public class RatingService implements IRatingService {
    private final IRatingRepository repo;

    public RatingService(IRatingRepository repo) { this.repo = repo; }

    @Override
    public boolean add(Rating rating) {

        return repo.create(rating);
    }

    @Override
    public Rating get(String id) { return repo.findById(id); }

    @Override
    public List<Rating> listByMedia(String mediaId) { return repo.findByMediaId(mediaId); }

    @Override
    public List<Rating> listByUser(String username) { return repo.findByUsername(username); }

    @Override
    public boolean edit(Rating rating) { return repo.update(rating); }

    @Override
    public boolean remove(String id) { return repo.deleteById(id); }

    @Override
    public boolean removeForMediaByUser(String mediaId, String username) {
        return repo.deleteByMediaAndUser(mediaId, username);
    }

    @Override
    public List<Rating> listAll() { return repo.findAll(); }

    @Override
    public Double averageForMedia(String mediaId) {

        var list = repo.findByMediaId(mediaId);
        if (list == null || list.isEmpty()) return null;
        int sum = 0;
        for (var r : list) sum += r.getScore();
        return sum / (double) list.size();
    }
}
