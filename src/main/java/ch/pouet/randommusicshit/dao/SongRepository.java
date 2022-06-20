package ch.pouet.randommusicshit.dao;


import ch.pouet.randommusicshit.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {

}
