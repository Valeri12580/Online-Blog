package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.domain.models.service.UserServiceModel;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.repositories.UserRepository;
import softuni.onlineblog.services.UserService;

@Service
public class UserServiceImpl  implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel findUserByEmail(String email) throws UserNotFoundException {
        User user=this.userRepository.findUserByEmail(email).orElseThrow(()->new UserNotFoundException("User not found!"));
        return this.modelMapper.map(user,UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByUsername(String username) throws UserNotFoundException {
        User user=this.userRepository.findUserByUsername(username).orElseThrow(()->new UserNotFoundException("User not found!"));

        return this.modelMapper.map(user,UserServiceModel.class);
    }
}
