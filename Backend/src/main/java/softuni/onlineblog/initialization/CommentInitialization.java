package softuni.onlineblog.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import softuni.onlineblog.domain.entities.Article;
import softuni.onlineblog.domain.entities.Comment;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.repositories.ArticleRepository;
import softuni.onlineblog.repositories.CommentRepository;
import softuni.onlineblog.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Component
@Order(4)
public class CommentInitialization  implements CommandLineRunner {
    private CommentRepository commentRepository;
    private ArticleRepository articleRepository;
    private UserRepository userRepository;


    @Autowired
    public CommentInitialization(CommentRepository commentRepository, ArticleRepository articleRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = this.userRepository.findUserByUsername("valeri");
        User user = this.userRepository.findUserByUsername("ivan");
        Comment comment = new Comment("Wow amazing article!!!", admin, LocalDateTime.now());
        Comment commentTwo = new Comment("The article is very good!Im very exited about your next one...", user,
                LocalDateTime.now());

        Article article=this.articleRepository.findAll().get(new Random().nextInt(2));

        comment.setPublishedIn(article);
        commentTwo.setPublishedIn(article);

        commentRepository.saveAll(List.of(comment,commentTwo));
    }
}
