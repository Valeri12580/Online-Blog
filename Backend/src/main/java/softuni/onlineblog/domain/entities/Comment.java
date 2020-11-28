package softuni.onlineblog.domain.entities;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity

@NoArgsConstructor
public class Comment extends BaseEntity {

    public Comment(String description, User author, LocalDateTime publishedOn) {
        this.description = description;
        this.author = author;
        this.publishedOn = publishedOn;
    }

    @Column
    @NotNull
    private String description;


    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;

    @Column
    private LocalDateTime publishedOn;

    @ManyToOne
    @JoinColumn(name = "published_in_id", referencedColumnName = "id")
    private BasePublishEntity publishedIn;

}
