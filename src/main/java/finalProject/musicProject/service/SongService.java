package finalProject.musicProject.service;

import finalProject.musicProject.domain.AppUser;
import finalProject.musicProject.domain.Song;
import finalProject.musicProject.repository.AppUserRepository;
import finalProject.musicProject.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private SongRepository songRepository;


    @Override
    public Song addSongByUserId(long userId, MultipartFile song, String genre) {
        try {
        if (appUserRepository.existsById(userId)) {

            AppUser user = appUserRepository.getOne(userId);

                Song newSong = new Song(song.getOriginalFilename(), song.getContentType(), song.getBytes(), genre);
                newSong.setUser(user);

                return songRepository.save(newSong);
        } else {
            throw new RuntimeException("Could not find user");
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Could not upload song");
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

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}
