package ch.pouet.rms.dao;


import ch.pouet.rms.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {

}
