package finalProject.musicProject.controller;

import finalProject.musicProject.domain.Song;
import finalProject.musicProject.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("SongController")
@RequestMapping("/api/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @PostMapping("/user/{userid}")
    public Song addSongByUserId(@PathVariable Long userid, @RequestBody Song song) {

        Song savedSong = songService.addSongByUserId(userid, song);
        return savedSong;
    }

    @GetMapping("/{songid}")
    public Song getSongById(@PathVariable long songid) {
        return songService.getSongById(songid);
    }
}
