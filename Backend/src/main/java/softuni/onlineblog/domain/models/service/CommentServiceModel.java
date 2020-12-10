package softuni.onlineblog.domain.models.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.onlineblog.domain.entities.BasePublishEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentServiceModel extends BaseServiceModel {



    private String description;
    private UserServiceModel author;
    private LocalDateTime publishedOn;
    private BasePublishEntity publishedIn;
}
