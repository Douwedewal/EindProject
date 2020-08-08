package finalProject.musicProject.service;

import finalProject.musicProject.domain.Comment;

public interface ICommentService {

    Comment addCommentBySongId(long id, Comment comment);
    Comment getCommentById(long id);
}
