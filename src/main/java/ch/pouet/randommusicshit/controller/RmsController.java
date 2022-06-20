package ch.pouet.randommusicshit.controller;

import ch.pouet.randommusicshit.model.Song;
import ch.pouet.randommusicshit.service.SongService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.regex.Matcher;
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

    @GetMapping("/addSong")
    public String addPage(){
        return "add";
    }

    @PostMapping
    public String create(@RequestBody Song song) {
        if(!urlRegexp.matcher(song.getUrl()).find())
            throw new RuntimeException();
        service.createSong(song);
        return "redirect:/list?message=ok";
    }
}
