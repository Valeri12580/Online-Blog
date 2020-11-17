package softuni.onlineblog.domain.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity
public class Comment extends BaseEntity{
    @Column
    @NotNull
    private String description;


    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private User author;

    @Column
    private LocalDateTime publishedOn;

    @ManyToOne
    @JoinColumn(name = "published_in_id",referencedColumnName = "id")
    private BasePublishEntity publishedIn;
}
