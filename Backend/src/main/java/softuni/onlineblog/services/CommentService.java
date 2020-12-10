package softuni.onlineblog.services;

import softuni.onlineblog.exceptions.ArticleNotFoundException;
import softuni.onlineblog.exceptions.UserNotFoundException;

public interface CommentService {

    void saveComment(String comment, String articleId, String username) throws ArticleNotFoundException, UserNotFoundException;

    void deleteCommentById(String id);
}
