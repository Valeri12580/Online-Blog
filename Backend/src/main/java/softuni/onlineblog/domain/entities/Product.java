package softuni.onlineblog.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Product extends BasePublishEntity {
    public Product(String title, String description, User author, String imageUrl, List<Comment> comments, PublishedIn publishedIn, int quantity, BigDecimal price) {
        super(title, description, author, imageUrl, comments, publishedIn);
        this.quantity = quantity;
        this.price = price;
    }

    private int quantity;
    private BigDecimal price;

}
