package softuni.onlineblog.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.onlineblog.domain.models.view.ProductViewModel;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel extends BaseServiceModel {
    private String username;

    private String password;


    private String email;


    private String imageUrl;


    private LocalDateTime registeredOn;

    private List<ProductServiceModel> purchaseHistory;

    private List<CommentServiceModel> comments;

    private List<ProductViewModel> addedProducts;
}
