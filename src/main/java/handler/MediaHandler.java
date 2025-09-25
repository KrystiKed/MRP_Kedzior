package handler;

import model.MediaModel;
import service.IMediaService;
import java.util.List;

public class MediaHandler {
    private final IMediaService mediaService;

    public MediaHandler(IMediaService mediaService) { this.mediaService = mediaService; }

    public boolean add(MediaModel media) {
        if (media == null || media.getId() == null) return false;
        return mediaService.add(media);
    }

    public MediaModel get(String id) { return mediaService.get(id); }
    public boolean edit(MediaModel media) { return mediaService.edit(media); }
    public boolean remove(String id) { return mediaService.remove(id); }
    public List<MediaModel> list() { return mediaService.list(); }
}
