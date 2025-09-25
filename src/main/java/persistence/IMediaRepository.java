package persistence;

import model.MediaModel;
import java.util.List;

public interface IMediaRepository {
    boolean create(MediaModel media);
    MediaModel findById(String id);
    boolean update(MediaModel media);
    boolean deleteById(String id);
    List<MediaModel> findAll();
}
