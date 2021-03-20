package softuni.onlineblog.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.onlineblog.domain.entities.BasePublishEntity;
import softuni.onlineblog.domain.entities.PublishedIn;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

public class ArticleServiceModel extends BaseServiceModel {
    public ArticleServiceModel(String title, String description, UserServiceModel author, String imageUrl) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    private String id;
    private String title;
    private String description;


    private UserServiceModel author;


    private String imageUrl;


    private List<CommentServiceModel> comments;
    private LocalDateTime publishedOn;
    private PublishedIn publishedIn;
}
