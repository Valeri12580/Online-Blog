package softuni.onlineblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.onlineblog.domain.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {


}
