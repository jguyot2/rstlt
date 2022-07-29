package ch.pouet.rms.service;

import ch.pouet.rms.dao.SongRepository;
import ch.pouet.rms.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SongService {
    @Autowired
    public SongRepository repository;

    public void createSong(Song song) {
        repository.save(song);
    }

    public void createSongs(Collection<Song> song) {
        repository.saveAll(song);
    }

    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        repository.findAll().forEach(songs::add);
        return songs;
    }
}
