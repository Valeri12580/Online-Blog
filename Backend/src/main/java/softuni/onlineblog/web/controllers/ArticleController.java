package softuni.onlineblog.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import softuni.onlineblog.domain.models.binding.CommentBindingModel;
import softuni.onlineblog.domain.models.view.ArticleViewModel;
import softuni.onlineblog.exceptions.ArticleNotFoundException;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.services.ArticleService;
import softuni.onlineblog.services.CommentService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin()
public class ArticleController {


    private ArticleService articleService;
    private ModelMapper modelMapper;
    private CommentService commentService;

    @Autowired
    public ArticleController(ArticleService articleService, ModelMapper modelMapper, CommentService commentService) {
        this.articleService = articleService;
        this.modelMapper = modelMapper;
        this.commentService = commentService;
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
    public ResponseEntity<Void>deleteArticleById(@PathVariable String id ) throws ArticleNotFoundException {

        articleService.deleteArticleById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<Void>postArticleComment(@PathVariable String id, @RequestBody CommentBindingModel commentBindingModel, Principal principal) throws ArticleNotFoundException, UserNotFoundException {

        commentService.saveComment(commentBindingModel.getDescription(),id,principal.getName());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{id}/comment/delete/{commentId}")
    public ResponseEntity<Void>deleteArticleComment(@PathVariable String id,@PathVariable String commentId){
        System.out.println("Deleted comment!");
        commentService.deleteCommentById(commentId);
        return ResponseEntity.ok().build();
    }

}
