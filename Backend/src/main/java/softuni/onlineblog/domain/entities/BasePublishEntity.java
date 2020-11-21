package softuni.onlineblog.domain.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BasePublishEntity  extends BaseEntity{

    @Column
    @NotNull
    private String title;
    @Column
    @NotNull
    private String description;



    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private User author;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy = "publishedIn")
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    @Column
    private PublishedIn publishedIn;

}
