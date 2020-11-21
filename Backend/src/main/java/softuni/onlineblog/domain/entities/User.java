package softuni.onlineblog.domain.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String imageUrl;


    @Column
    @NotNull
    private LocalDateTime registeredOn;

    @ManyToMany
    @JoinTable(name = "users_purchased_products"
            , joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> purchaseHistory;


    @OneToMany
    private Set<Role> roles;

    @OneToMany
    private List<Blog> publishedBlogs;


    @OneToMany(mappedBy = "author")
    private List<Comment> comments;


    @OneToMany(mappedBy = "author")
    private List<Product> addedProducts;
}
