package ch.pouet.rms.restcontroller;


import ch.pouet.rms.model.Song;
import ch.pouet.rms.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/songs")
public class SongController {
    @Autowired
    private SongService service;

    @GetMapping
    public List<Song> list(@RequestParam(defaultValue = "50") Integer limit,
                           @RequestParam(defaultValue = "0") Integer offset) {
        // TODO pagination
        return service.getSongs();
    }

    @PostMapping
    public Song song(@RequestBody Song created) {
        // TOOO un peu de validation comme même
        return service.createSong(created);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Long id,
                           @RequestBody Song updatedSong) {
        // TOOO un peu de validation comme même
        updatedSong.setId(id);
        return service.updateSong(updatedSong);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        // TOOO un peu de validation comme même
        service.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public Song getByID(@PathVariable Long id) {
        // TODO un peu de gestion d'exception commême
        return service.findById(id).orElseThrow(RuntimeException::new);
    }

}
