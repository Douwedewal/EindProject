package finalProject.musicProject.service;

import finalProject.musicProject.domain.AppUser;
import finalProject.musicProject.domain.Song;
import finalProject.musicProject.repository.AppUserRepository;
import finalProject.musicProject.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song addSongByUserId(long userId, Song song) {
        if(appUserRepository.existsById(userId)) {
            AppUser user = appUserRepository.getOne(userId);
            song.setUser(user);

            return songRepository.save(song);
        }
            throw new RuntimeException("User nog found");
    }

    @Override
    public Song getSongById(long id) {
        Optional<Song> song = songRepository.findById(id);

        if(song.isPresent()) {

            Song leSong = song.get();
            leSong.setUser(song.get().getUser());
            return leSong;
        }
        throw new RuntimeException("Song with id " + id +  " not found.");
    }
}
