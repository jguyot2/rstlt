package ch.pouet.rms.controller;

import ch.pouet.rms.dto.AddedSongs;
import ch.pouet.rms.model.Song;
import ch.pouet.rms.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class RmsController {
    final Pattern urlRegexp = Pattern.compile("^https?://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");

    @Autowired
    SongService service;

    @GetMapping("/list")
    public String list(@RequestParam(required = false) final String message,
                       Model model) {
        List<Song> songs = service.getSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("message", message);
        return "list";
    }

    @GetMapping("/add")
    public String addPage() {
        return "addSong";
    }

    @GetMapping("/addSeveral")
    public String addSeveral() {
        return "addSong";
    }

    @PostMapping("/add")
    public String addSongs(@RequestBody AddedSongs addedSongs) {
        String submittedBy = addedSongs.getSubmittedBy();
        Instant now = Instant.now();
        List<Song> songs =
                addedSongs.getSongsUris().lines()
                        .map(s -> Song.builder()
                                .link(s)
                                .submittedBy(submittedBy)
                                .submission(now)
                                .build())
                        .toList();
        service.createSongs(songs);
        return "redirect:/list?message=ok";
    }

    @PostMapping
    public String create(@RequestBody Song song) {
        if (!urlRegexp.matcher(song.getLink()).find())
            throw new RuntimeException();
        service.createSong(song);
        return "redirect:/list?message=ok";
    }
}
