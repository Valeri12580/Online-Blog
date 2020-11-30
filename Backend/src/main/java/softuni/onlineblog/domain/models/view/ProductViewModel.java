package softuni.onlineblog.domain.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.onlineblog.domain.entities.Comment;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductViewModel extends BaseViewModel {

    private String title;
    private String description;

    private UserViewModel author;
    private String imageUrl;
    private List<CommentViewModel>comments;

    private int quantity;
    private BigDecimal price;
}
