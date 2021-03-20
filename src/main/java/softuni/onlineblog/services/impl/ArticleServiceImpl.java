package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.Article;
import softuni.onlineblog.domain.entities.PublishedIn;
import softuni.onlineblog.domain.models.service.ArticleServiceModel;
import softuni.onlineblog.domain.models.service.UserServiceModel;
import softuni.onlineblog.exceptions.ArticleNotFoundException;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.repositories.ArticleRepository;
import softuni.onlineblog.services.ArticleService;
import softuni.onlineblog.services.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private ModelMapper modelMapper;
    private UserService userService;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper, UserService userService) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public List<ArticleServiceModel> findAllArticles() {
        List<ArticleServiceModel> articles = List.of(this.modelMapper.map(this.articleRepository.findAll(), ArticleServiceModel[].class));
        return  articles;
    }

    @Override
    public ArticleServiceModel findArticleById(String id) throws ArticleNotFoundException {
        return this.modelMapper.map(this.articleRepository.findById(id).orElseThrow(()->new ArticleNotFoundException("Article not found!")), ArticleServiceModel.class);
    }

    @Override
    public void deleteArticleById(String id) throws ArticleNotFoundException {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("Article not found!"));
        articleRepository.delete(article);

    }

    @Override
    public ArticleServiceModel saveArticle(String title,String description,String imageUrl, String username) throws UserNotFoundException {

        UserServiceModel user = this.userService.findUserByUsername(username);


        ArticleServiceModel articleServiceModel=new ArticleServiceModel(title,description,user,imageUrl);
        articleServiceModel.setPublishedOn(LocalDateTime.now());
        articleServiceModel.setPublishedIn(PublishedIn.BLOG);



        Article article = articleRepository.save(this.modelMapper.map(articleServiceModel, Article.class));


        return this.modelMapper.map(article,ArticleServiceModel.class);
    }
}
