package persistence;

import model.MediaModel;
import java.util.ArrayList;
import java.util.List;

public class MediaSqlRepository implements IMediaRepository {
    private static final MediaSqlRepository INSTANCE = new MediaSqlRepository();
    public static MediaSqlRepository getInstance() { return INSTANCE; }

    private final List<MediaModel> store = new ArrayList<>();

    private MediaSqlRepository() {}

    @Override
    public boolean create(MediaModel media) {
        if (media == null || media.getId() == null) return false;
        if (findById(media.getId()) != null) return false;
        return store.add(media);
    }

    @Override
    public MediaModel findById(String id) {
        if (id == null) return null;
        for (MediaModel m : store) if (id.equals(m.getId())) return m;
        return null;
    }

    @Override
    public boolean update(MediaModel media) {

        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return store.removeIf(m -> id != null && id.equals(m.getId()));
    }

    @Override
    public List<MediaModel> findAll() {
        return new ArrayList<>(store);
    }
}
