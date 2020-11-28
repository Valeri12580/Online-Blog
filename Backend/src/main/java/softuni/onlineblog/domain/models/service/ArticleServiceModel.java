package softuni.onlineblog.domain.models.service;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.onlineblog.domain.entities.Comment;
import softuni.onlineblog.domain.entities.PublishedIn;
import softuni.onlineblog.domain.entities.User;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

public class ArticleServiceModel extends BaseServiceModel {

    private String title;
    private String description;
    private User author;
    private String imageUrl;
    private List<Comment>comments;
    private LocalDateTime publishedOn;
    private PublishedIn publishedIn;
}
