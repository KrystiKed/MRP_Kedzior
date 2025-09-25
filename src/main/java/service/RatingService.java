package service;

import model.RatingModel;
import persistence.IRatingRepository;

import java.util.List;

public class RatingService implements IRatingService {
    private final IRatingRepository repo;

    public RatingService(IRatingRepository repo) { this.repo = repo; }

    @Override
    public boolean add(RatingModel rating) {

        return repo.create(rating);
    }

    @Override
    public RatingModel get(String id) { return repo.findById(id); }

    @Override
    public List<RatingModel> listByMedia(String mediaId) { return repo.findByMediaId(mediaId); }

    @Override
    public List<RatingModel> listByUser(String username) { return repo.findByUsername(username); }

    @Override
    public boolean edit(RatingModel rating) { return repo.update(rating); }

    @Override
    public boolean remove(String id) { return repo.deleteById(id); }

    @Override
    public boolean removeForMediaByUser(String mediaId, String username) {
        return repo.deleteByMediaAndUser(mediaId, username);
    }

    @Override
    public List<RatingModel> listAll() { return repo.findAll(); }

    @Override
    public Double averageForMedia(String mediaId) {

        var list = repo.findByMediaId(mediaId);
        if (list == null || list.isEmpty()) return null;
        int sum = 0;
        for (var r : list) sum += r.getScore();
        return sum / (double) list.size();
    }
}
