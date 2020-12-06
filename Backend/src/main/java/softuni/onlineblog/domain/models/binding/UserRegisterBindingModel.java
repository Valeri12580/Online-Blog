package softuni.onlineblog.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {
    private String username;
    private String email;
    private String imageUrl;
    private String password;
    private String rePassword;
}
