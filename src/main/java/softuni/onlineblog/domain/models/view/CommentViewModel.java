package softuni.onlineblog.domain.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentViewModel  extends BaseViewModel{

    private String description;

    private UserViewModel author;

    private LocalDateTime publishedOn;
}
