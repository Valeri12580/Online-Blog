package softuni.onlineblog.services;

import softuni.onlineblog.exceptions.ArticleNotFoundException;
import softuni.onlineblog.exceptions.UserNotFoundException;

public interface CommentService {

    void saveComment(String comment, String entityId, String username,String publishType) throws ArticleNotFoundException, UserNotFoundException;

    void deleteCommentById(String id);
}
