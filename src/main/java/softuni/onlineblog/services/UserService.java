package softuni.onlineblog.services;

import softuni.onlineblog.domain.models.service.UserServiceModel;
import softuni.onlineblog.exceptions.UserNotFoundException;

public interface UserService {

        UserServiceModel findUserByEmail(String email) throws UserNotFoundException;
        UserServiceModel findUserByUsername(String username) throws UserNotFoundException;

        UserServiceModel registerUser(UserServiceModel userServiceModel);

}
