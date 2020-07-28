package finalProject.musicProject.service;

import finalProject.musicProject.domain.Song;

public interface ISongService {

    Song addSongByUserId(long id, Song song);

    Song getSongById(long id);

}
