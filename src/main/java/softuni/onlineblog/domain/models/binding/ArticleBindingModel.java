package softuni.onlineblog.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArticleBindingModel {
    private String title;
    private String description;
    private String imageUrl;
}
