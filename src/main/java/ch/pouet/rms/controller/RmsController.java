package ch.pouet.rms.controller;


import ch.pouet.rms.model.Song;
import ch.pouet.rms.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String addSongs(@RequestParam String url,
                           @RequestParam String submittedBy,
                           @RequestParam(required = false) String name) {
        service.createSong(Song.builder().link(url)
                .submittedBy(submittedBy)
                .name(name)
                .submission(Instant.now())
                .build());
        return "redirect:/list?message=ok";
    }

}
