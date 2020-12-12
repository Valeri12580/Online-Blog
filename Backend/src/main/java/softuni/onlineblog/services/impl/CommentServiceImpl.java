package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.BasePublishEntity;
import softuni.onlineblog.domain.entities.Comment;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.exceptions.ArticleNotFoundException;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.repositories.ArticleRepository;
import softuni.onlineblog.repositories.CommentRepository;
import softuni.onlineblog.repositories.ProductRepository;
import softuni.onlineblog.repositories.UserRepository;
import softuni.onlineblog.services.CommentService;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {
    private ArticleRepository articleRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(ArticleRepository articleRepository, ProductRepository productRepository, UserRepository userRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void saveComment(String comment, String entityId, String username,String publishType) throws ArticleNotFoundException, UserNotFoundException {
        BasePublishEntity entity =null;
        if(publishType.equals("product")){
            entity=productRepository.findById(entityId).get();
        }else{
            entity=articleRepository.findById(entityId).get();
        }
        User user = userRepository.findUserByUsername(username).get();
        Comment commentEntity=new Comment(comment,user,LocalDateTime.now(),entity);

        this.commentRepository.save(commentEntity);
    }

    @Override
    public void deleteCommentById(String id) {
        commentRepository.deleteById(id);
    }

//    private JpaRepository publishEntitySolver(String publishType){
//        if(publishType.equals("products")){
//            return productRepository;
//        }
//        return articleRepository;
//    }
}
