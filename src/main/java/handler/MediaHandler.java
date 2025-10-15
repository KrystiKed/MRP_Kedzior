package handler;

import model.MediaEntry;
import service.IMediaService;
import java.util.List;

public class MediaHandler {
    private final IMediaService mediaService;

    public MediaHandler(IMediaService mediaService) { this.mediaService = mediaService; }

    public boolean add(MediaEntry media) {
        if (media == null || media.getId() == null) return false;
        return mediaService.add(media);
    }

    public MediaEntry get(String id) { return mediaService.get(id); }
    public boolean edit(MediaEntry media) { return mediaService.edit(media); }
    public boolean remove(String id) { return mediaService.remove(id); }
    public List<MediaEntry> list() { return mediaService.list(); }
}
