package softuni.onlineblog.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductBindingModel {
    private String title;
    private String imageUrl;
    private String description;
    private int quantity;
    private BigDecimal price;
}
