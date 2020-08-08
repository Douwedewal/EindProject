package finalProject.musicProject.service;

import finalProject.musicProject.domain.Comment;
import finalProject.musicProject.domain.Song;
import finalProject.musicProject.repository.CommentRepository;
import finalProject.musicProject.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements  ICommentService{

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addCommentBySongId(long id, Comment comment) {
        if(songRepository.existsById(id)) {
            Song song = songRepository.getOne(id);
            comment.setSong(song);

            return commentRepository.save(comment);
        }

        throw new RuntimeException("Song not found");
    }

    @Override
    public Comment getCommentById(long id) {
        Optional<Comment> comment = commentRepository.findById(id);

        if(comment.isPresent()) {
            return comment.get();
        }

        throw new RuntimeException("Comment with id " + id +  " not found.");
    }
}
