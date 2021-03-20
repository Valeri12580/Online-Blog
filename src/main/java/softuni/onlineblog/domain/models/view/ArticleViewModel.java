package softuni.onlineblog.domain.models.view;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class ArticleViewModel extends BaseViewModel {


    private String title;

    private String description;


    private UserViewModel author;


    private String imageUrl;

    private List<CommentViewModel> comments;

    private LocalDateTime publishedOn;
    private PublishedIn publishedIn;
}
