package softuni.onlineblog.web.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softuni.onlineblog.domain.models.binding.CommentBindingModel;
import softuni.onlineblog.domain.models.service.ProductServiceModel;
import softuni.onlineblog.domain.models.view.ProductViewModel;
import softuni.onlineblog.exceptions.ArticleNotFoundException;
import softuni.onlineblog.exceptions.ProductNotFoundException;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.services.CommentService;
import softuni.onlineblog.services.ProductService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ModelMapper modelMapper;
    private ProductService productService;
    private CommentService commentService;

    public ProductController(ModelMapper modelMapper, ProductService productService, CommentService commentService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<ProductViewModel>> findAllProducts() {
        List<ProductViewModel> products = List.of(this.modelMapper.map(this.productService.findAllProducts(), ProductViewModel[].class));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductViewModel> findProductById(@PathVariable String id) throws ProductNotFoundException {
        ProductServiceModel product = this.productService.findProductById(id);
        return ResponseEntity.ok(this.modelMapper.map(product, ProductViewModel.class));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String id) throws ProductNotFoundException {

        productService.deleteProductById(id);


        return ResponseEntity.ok().build();

    }


    @DeleteMapping("/{id}/comment/delete/{commentId}")
    public ResponseEntity<Void> deleteProductCommentById(@PathVariable String commentId) {
        commentService.deleteCommentById(commentId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<Void>postProductComment(@PathVariable String id,@RequestBody CommentBindingModel commentBindingModel, Principal principal) throws ArticleNotFoundException, UserNotFoundException {

        this.commentService.saveComment(commentBindingModel.getDescription(),id,principal.getName(),"product");

        return ResponseEntity.ok().build();
    }


}
