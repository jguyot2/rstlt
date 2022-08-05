package ch.pouet.rms.dao;


import ch.pouet.rms.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface SongRepository extends PagingAndSortingRepository<Song, Long> {

}
