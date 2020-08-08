package finalProject.musicProject.controller;

import finalProject.musicProject.domain.Comment;
import finalProject.musicProject.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping(value = "api/song/comment/{songid}")
    public Comment addCommentBySongId(@PathVariable Long songid, @RequestBody Comment comment) {
        return commentService.addCommentBySongId(songid, comment);
    }

    @GetMapping(value = "api/song/comment/get/{songid}")
    public String getCommentById(@PathVariable long songid) {
        return commentService.getCommentById(songid).getPost();
    }
}
