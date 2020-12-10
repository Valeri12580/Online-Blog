package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.Article;
import softuni.onlineblog.domain.entities.Comment;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.domain.models.service.ArticleServiceModel;
import softuni.onlineblog.domain.models.service.CommentServiceModel;
import softuni.onlineblog.domain.models.service.UserServiceModel;
import softuni.onlineblog.exceptions.ArticleNotFoundException;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.repositories.ArticleRepository;
import softuni.onlineblog.repositories.CommentRepository;
import softuni.onlineblog.repositories.UserRepository;
import softuni.onlineblog.services.CommentService;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {
    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(ArticleRepository articleRepository, UserRepository userRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void saveComment(String comment, String articleId, String username) throws ArticleNotFoundException, UserNotFoundException {
        Article article = articleRepository.findById(articleId).get();
        User user = userRepository.findUserByUsername(username).get();
        Comment commentEntity=new Comment(comment,user,LocalDateTime.now(),article);

        this.commentRepository.save(commentEntity);
    }

    @Override
    public void deleteCommentById(String id) {
        commentRepository.deleteById(id);
    }
}
