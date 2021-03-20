package softuni.onlineblog.domain.models.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserViewModel  extends BaseViewModel{

    private String username;
    private String email;
    private String imageUrl;
    private String registeredOn;
}
