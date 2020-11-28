package softuni.onlineblog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.service.ArticleServiceModel;
import softuni.onlineblog.services.ArticleService;

import java.util.List;

@RestController
public class ArticleController {


    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public List<ArticleServiceModel> findAllArticles(){
        return articleService.findAllArticles();
    }



}
