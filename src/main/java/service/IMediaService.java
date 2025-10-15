package service;

import model.MediaEntry;
import java.util.List;

public interface IMediaService {
    boolean add(MediaEntry media);
    MediaEntry get(String id);
    boolean edit(MediaEntry media);
    boolean remove(String id);
    List<MediaEntry> list();
}
