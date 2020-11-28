package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.models.service.ArticleServiceModel;
import softuni.onlineblog.repositories.ArticleRepository;
import softuni.onlineblog.services.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ArticleServiceModel> findAllArticles() {
        return List.of(this.modelMapper.map(this.articleRepository.findAll(), ArticleServiceModel[].class));
    }
}
