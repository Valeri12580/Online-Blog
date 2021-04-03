package softuni.onlineblog.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import softuni.onlineblog.domain.entities.Article;
import softuni.onlineblog.domain.entities.PublishedIn;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.repositories.ArticleRepository;
import softuni.onlineblog.repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Order(3)
public class ArticleInitialization implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;


    @Autowired
    public ArticleInitialization(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;

    }

    @PostConstruct
    public void init() {

    }

    @Override
    public void run(String... args) throws Exception {

        User admin = this.userRepository.findUserByUsername("valeri").get();


        Article articleOne = new Article("Our website is launched!",
                "Welcome to our website.Here you can find various of articles and products that will help you upgrade yourself!",
                admin, "https://cdn.pixabay.com/photo/2014/11/17/13/17/crossfit-534615_1280.jpg", null, PublishedIn.BLOG, LocalDateTime.now());
        Article articleTwo = new Article("How to build more muscles!",
                "You want to get stronger and build more muscles?Well to do that you need to TRAIN HARD!",
                admin, "https://cdn.pixabay.com/photo/2017/02/04/12/25/man-2037255_1280.jpg", null, PublishedIn.BLOG, LocalDateTime.now());


        //todo published_in_id --> null
        articleRepository.saveAll(List.of(articleOne, articleTwo));
    }


}
