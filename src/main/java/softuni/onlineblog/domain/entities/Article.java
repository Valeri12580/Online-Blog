package softuni.onlineblog.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor

public class Article extends BasePublishEntity {


    public Article(String title, String description, User author, String imageUrl, List<Comment> comments, PublishedIn publishedIn, LocalDateTime publishedOn) {
        super(title, description, author, imageUrl, comments, publishedIn);
        this.publishedOn = publishedOn;
    }

    @Column
    private LocalDateTime publishedOn;
}
