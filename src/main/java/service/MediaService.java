package service;

import model.MediaModel;
import persistence.IMediaRepository;
import java.util.List;

public class MediaService implements IMediaService {
    private final IMediaRepository repo;

    public MediaService(IMediaRepository repo) { this.repo = repo; }

    @Override
    public boolean add(MediaModel media) {

        return repo.create(media);
    }

    @Override
    public MediaModel get(String id) {
        return repo.findById(id);
    }

    @Override
    public boolean edit(MediaModel media) {

        return repo.update(media);
    }

    @Override
    public boolean remove(String id) {
        return repo.deleteById(id);
    }

    @Override
    public List<MediaModel> list() {
        return repo.findAll();
    }
}
