package finalProject.musicProject.service;

import finalProject.musicProject.domain.Song;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ISongService {

    Song addSongByUserId(long id, MultipartFile song, String genre);
    Song getSongById(long id);
    List<Song> getAllSongs();
    String deleteSongById(long id);

}
