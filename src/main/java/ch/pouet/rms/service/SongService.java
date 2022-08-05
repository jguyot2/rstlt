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

    public Song createSong(Song song) {
        return repository.save(song);
    }

    public Song updateSong(Song song) {
        return repository.save(song);
    }

    public void createSongs(Collection<Song> song) {
        repository.saveAll(song);
    }

    public void deleteSong(Long id){
        repository.deleteById(id);
    }
    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        repository.findAll().forEach(songs::add);
        return songs;
    }
}
