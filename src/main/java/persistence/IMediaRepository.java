package persistence;

import model.MediaEntry;
import java.util.List;

public interface IMediaRepository {
    boolean create(MediaEntry media);
    MediaEntry findById(String id);
    boolean update(MediaEntry media);
    boolean deleteById(String id);
    List<MediaEntry> findAll();
}
