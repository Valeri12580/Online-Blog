package softuni.onlineblog.services;

import softuni.onlineblog.domain.models.service.ArticleServiceModel;

import java.util.List;

public interface ArticleService {

    List<ArticleServiceModel>findAllArticles();
}
