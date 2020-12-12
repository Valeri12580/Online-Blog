package softuni.onlineblog.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.binding.ArticleBindingModel;
import softuni.onlineblog.domain.models.service.ArticleServiceModel;
import softuni.onlineblog.domain.models.view.ArticleViewModel;
import softuni.onlineblog.exceptions.UserNotFoundException;
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
    public ResponseEntity<ArticleViewModel> addArticle(@RequestBody ArticleBindingModel articleBindingModel, Principal principal) throws UserNotFoundException {

        ArticleServiceModel saved = this.articleService.saveArticle(articleBindingModel.getTitle(), articleBindingModel.getDescription(), articleBindingModel.getImageUrl(), principal.getName());
        ArticleViewModel article = this.modelMapper.map(saved, ArticleViewModel.class);

        return ResponseEntity.ok(article);
    }
}
