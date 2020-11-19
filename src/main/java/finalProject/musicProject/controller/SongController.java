package finalProject.musicProject.controller;

import finalProject.musicProject.domain.Song;
import finalProject.musicProject.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController("SongController")
@RequestMapping("/api/auth/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @PostMapping("/user/{userid}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Song addSongByUserId(@PathVariable Long userid, @RequestParam("file") MultipartFile song, String genre) {
        return songService.addSongByUserId(userid, song, genre);
    }

    @GetMapping("/{songid}")
    public Song getSongById(@PathVariable long songid) {
        return songService.getSongById(songid);
    }

    @GetMapping("/allsongs")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @DeleteMapping("/{songid}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String deleteSongById(@PathVariable long songid) {
        return songService.deleteSongById(songid);
    }
}
