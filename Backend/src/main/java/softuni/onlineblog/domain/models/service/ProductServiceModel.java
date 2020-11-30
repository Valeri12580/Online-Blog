package softuni.onlineblog.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.onlineblog.domain.entities.Comment;
import softuni.onlineblog.domain.entities.PublishedIn;
import softuni.onlineblog.domain.entities.User;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductServiceModel extends BaseServiceModel  {
    private String title;
    private String description;
    private User author;
    private String imageUrl;
    private List<Comment>comments;
    private PublishedIn publishedIn;
    private int quantity;
    private BigDecimal price;

}
