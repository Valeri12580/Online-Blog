package softuni.onlineblog.domain.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private List<Comment> comments;

    @Enumerated(EnumType.STRING)
    @Column
    private PublishedIn publishedIn;

}
