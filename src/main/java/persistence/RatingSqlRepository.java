package persistence;

import model.RatingModel;
import java.util.ArrayList;
import java.util.List;

public class RatingSqlRepository implements IRatingRepository {
    private static final RatingSqlRepository INSTANCE = new RatingSqlRepository();
    public static RatingSqlRepository getInstance() { return INSTANCE; }

    private final List<RatingModel> store = new ArrayList<>();

    private RatingSqlRepository() {}

    @Override
    public boolean create(RatingModel rating) {
        if (rating == null || rating.getId() == null) return false;
        if (findById(rating.getId()) != null) return false;

        return store.add(rating);
    }

    @Override
    public RatingModel findById(String id) {
        if (id == null) return null;
        for (RatingModel r : store) if (id.equals(r.getId())) return r;
        return null;
    }

    @Override
    public List<RatingModel> findByMediaId(String mediaId) {
        List<RatingModel> res = new ArrayList<>();
        for (RatingModel r : store) if (mediaId != null && mediaId.equals(r.getMediaId())) res.add(r);
        return res;
    }

    @Override
    public List<RatingModel> findByUsername(String username) {
        List<RatingModel> res = new ArrayList<>();
        for (RatingModel r : store) if (username != null && username.equals(r.getUsername())) res.add(r);
        return res;
    }

    @Override
    public boolean update(RatingModel rating) {

        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return store.removeIf(r -> id != null && id.equals(r.getId()));
    }

    @Override
    public boolean deleteByMediaAndUser(String mediaId, String username) {
        return store.removeIf(r ->
                mediaId != null && username != null &&
                        mediaId.equals(r.getMediaId()) && username.equals(r.getUsername())
        );
    }

    @Override
    public List<RatingModel> findAll() {
        return new ArrayList<>(store);
    }
}
