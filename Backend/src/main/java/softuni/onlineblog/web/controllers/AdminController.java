package softuni.onlineblog.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softuni.onlineblog.domain.models.view.ArticleViewModel;
import softuni.onlineblog.services.ArticleService;


import java.security.Principal;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private ArticleService articleService;
    private ModelMapper modelMapper;

    @Autowired
    public AdminController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add-article")
    public ResponseEntity<ArticleViewModel>addArticle(@RequestBody ArticleViewModel articleViewModel, Principal principal){
        System.out.println();

        return ResponseEntity.ok(new ArticleViewModel());
    }
}
