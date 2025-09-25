package service;

import model.MediaModel;
import java.util.List;

public interface IMediaService {
    boolean add(MediaModel media);
    MediaModel get(String id);
    boolean edit(MediaModel media);
    boolean remove(String id);
    List<MediaModel> list();
}
