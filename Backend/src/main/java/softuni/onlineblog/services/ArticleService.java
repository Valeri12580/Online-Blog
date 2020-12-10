package softuni.onlineblog.services;

import softuni.onlineblog.domain.models.service.ArticleServiceModel;
import softuni.onlineblog.exceptions.ArticleNotFoundException;

import java.util.List;

public interface ArticleService {

    List<ArticleServiceModel>findAllArticles();

    ArticleServiceModel findArticleById(String id) throws ArticleNotFoundException;

    void deleteArticleById(String id) throws ArticleNotFoundException;


}
