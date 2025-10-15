package persistence;

import model.MediaEntry;
import java.util.ArrayList;
import java.util.List;

public class MediaSqlRepository implements IMediaRepository {
    private static final MediaSqlRepository INSTANCE = new MediaSqlRepository();
    public static MediaSqlRepository getInstance() { return INSTANCE; }

    private final List<MediaEntry> store = new ArrayList<>();

    private MediaSqlRepository() {}

    @Override
    public boolean create(MediaEntry media) {
        if (media == null || media.getId() == null) return false;
        if (findById(media.getId()) != null) return false;
        return store.add(media);
    }

    @Override
    public MediaEntry findById(String id) {
        if (id == null) return null;
        for (MediaEntry m : store) if (id.equals(m.getId())) return m;
        return null;
    }

    @Override
    public boolean update(MediaEntry media) {

        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return store.removeIf(m -> id != null && id.equals(m.getId()));
    }

    @Override
    public List<MediaEntry> findAll() {
        return new ArrayList<>(store);
    }
}
