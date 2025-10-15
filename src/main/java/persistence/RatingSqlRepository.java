package persistence;

import model.Rating;
import java.util.ArrayList;
import java.util.List;

public class RatingSqlRepository implements IRatingRepository {
    private static final RatingSqlRepository INSTANCE = new RatingSqlRepository();
    public static RatingSqlRepository getInstance() { return INSTANCE; }

    private final List<Rating> store = new ArrayList<>();

    private RatingSqlRepository() {}

    @Override
    public boolean create(Rating rating) {
        if (rating == null || rating.getId() == null) return false;
        if (findById(rating.getId()) != null) return false;

        return store.add(rating);
    }

    @Override
    public Rating findById(String id) {
        if (id == null) return null;
        for (Rating r : store) if (id.equals(r.getId())) return r;
        return null;
    }

    @Override
    public List<Rating> findByMediaId(String mediaId) {
        List<Rating> res = new ArrayList<>();
        for (Rating r : store) if (mediaId != null && mediaId.equals(r.getMediaId())) res.add(r);
        return res;
    }

    @Override
    public List<Rating> findByUsername(String username) {
        List<Rating> res = new ArrayList<>();
        for (Rating r : store) if (username != null && username.equals(r.getUsername())) res.add(r);
        return res;
    }

    @Override
    public boolean update(Rating rating) {

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
    public List<Rating> findAll() {
        return new ArrayList<>(store);
    }
}
