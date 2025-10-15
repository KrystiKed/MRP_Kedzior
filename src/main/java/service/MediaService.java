package service;

import model.MediaEntry;
import persistence.IMediaRepository;
import java.util.List;

public class MediaService implements IMediaService {
    private final IMediaRepository repo;

    public MediaService(IMediaRepository repo) { this.repo = repo; }

    @Override
    public boolean add(MediaEntry media) {

        return repo.create(media);
    }

    @Override
    public MediaEntry get(String id) {
        return repo.findById(id);
    }

    @Override
    public boolean edit(MediaEntry media) {

        return repo.update(media);
    }

    @Override
    public boolean remove(String id) {
        return repo.deleteById(id);
    }

    @Override
    public List<MediaEntry> list() {
        return repo.findAll();
    }
}
