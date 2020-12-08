package softuni.onlineblog.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import softuni.onlineblog.domain.models.view.ArticleViewModel;
import softuni.onlineblog.exceptions.ArticleNotFoundException;
import softuni.onlineblog.services.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/articles")

public class ArticleController {


    private ArticleService articleService;
    private ModelMapper modelMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ModelMapper modelMapper) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<ArticleViewModel>> findAllArticles() {
        List<ArticleViewModel> result = List.of(this.modelMapper.map(this.articleService.findAllArticles(), ArticleViewModel[].class));
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleViewModel> findArticleById(@PathVariable String id) throws ArticleNotFoundException {
        ArticleViewModel article = this.modelMapper.map(this.articleService.findArticleById(id), ArticleViewModel.class);

        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteArticleById(@PathVariable String id ){
        System.out.println();
        return ResponseEntity.ok().build();
    }


}
