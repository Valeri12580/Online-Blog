package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.domain.models.service.UserServiceModel;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.repositories.UserRepository;
import softuni.onlineblog.services.RoleService;
import softuni.onlineblog.services.UserService;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class UserServiceImpl  implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
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

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user=this.modelMapper.map(userServiceModel,User.class);

        if(user.getImageUrl()==null){
            user.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/User_icon_2.svg/72px-User_icon_2.svg.png");
        }

        user.setRegisteredOn(LocalDateTime.now());
        user.setRoles(Set.of(roleService.findRoleByName("USER")));
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        user=this.userRepository.save(user);
        return this.modelMapper.map(user,UserServiceModel.class);
    }
}
