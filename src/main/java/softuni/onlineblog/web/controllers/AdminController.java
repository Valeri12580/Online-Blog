package softuni.onlineblog.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.binding.ArticleBindingModel;
import softuni.onlineblog.domain.models.binding.ProductBindingModel;
import softuni.onlineblog.domain.models.service.ArticleServiceModel;
import softuni.onlineblog.domain.models.service.ProductServiceModel;
import softuni.onlineblog.domain.models.view.ArticleViewModel;
import softuni.onlineblog.domain.models.view.ProductViewModel;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.services.ArticleService;
import softuni.onlineblog.services.ProductService;

import java.security.Principal;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private ArticleService articleService;
    private ModelMapper modelMapper;
    private ProductService productService;

    @Autowired
    public AdminController(ArticleService articleService, ModelMapper modelMapper, ProductService productService) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    //todo doesnt work because security configuration
    @PostMapping("/add-article")
    public ResponseEntity<ArticleViewModel> addArticle(@RequestBody ArticleBindingModel articleBindingModel, Principal principal) throws UserNotFoundException {
        System.out.println(principal);
        ArticleServiceModel saved = this.articleService.saveArticle(articleBindingModel.getTitle(), articleBindingModel.getDescription(), articleBindingModel.getImageUrl(), principal.getName());
        ArticleViewModel article = this.modelMapper.map(saved, ArticleViewModel.class);

        return ResponseEntity.ok(article);
    }


    @PostMapping("/add-product")
    public ResponseEntity<ProductViewModel> addProduct(@RequestBody ProductBindingModel productBindingModel, Principal principal) throws UserNotFoundException {
        ProductServiceModel productServiceModel = this.productService.addProduct(this.modelMapper.map(productBindingModel, ProductServiceModel.class), principal.getName());

        return ResponseEntity.ok(this.modelMapper.map(productServiceModel, ProductViewModel.class));
    }
}
