package ch.pouet.rms.dto;

import ch.pouet.rms.model.Song;
import lombok.Data;

import java.util.List;

@Data
public class AddedSongs {
    private String songsUris;
    private String submittedBy;
}
