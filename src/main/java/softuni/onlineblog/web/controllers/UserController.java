package softuni.onlineblog.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import softuni.onlineblog.domain.models.binding.UserRegisterBindingModel;
import softuni.onlineblog.domain.models.service.UserServiceModel;
import softuni.onlineblog.domain.models.view.UserViewModel;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.services.UserService;
import softuni.onlineblog.services.impl.UserDetailsServiceImpl;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")

public class UserController {

    private ModelMapper modelMapper;
    private UserService userService;
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsServiceImpl;


    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceImpl = userDetailsServiceImpl;

    }

    @GetMapping("/availability")
    public ResponseEntity<Map<String, Boolean>> uniqueCheck(@RequestParam("username") String username, @RequestParam("email") String email) {

        UserViewModel userViewModelByUsername = null;
        UserViewModel userViewModelByEmail = null;
        try {
            userViewModelByUsername = this.modelMapper.map(this.userService.findUserByUsername(username), UserViewModel.class);


        } catch (UserNotFoundException ex) {

        }
        try {
            userViewModelByEmail = this.modelMapper.map(this.userService.findUserByEmail(email), UserViewModel.class);
        } catch (UserNotFoundException ex) {

        }


        Map<String, Boolean> map = new HashMap<>();
        map.put("email", userViewModelByEmail == null);
        map.put("username", userViewModelByUsername == null);
        return ResponseEntity.ok().body(map);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRegisterBindingModel userRegisterBindingModel) throws URISyntaxException {

        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        this.userService.registerUser(userServiceModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        System.out.println("Logged out!");
        SecurityContextHolder.getContext().setAuthentication(null);
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<UserViewModel> findUserByUsername(@PathVariable String username) throws UserNotFoundException {
        UserViewModel user = this.modelMapper.map(userService.findUserByUsername(username), UserViewModel.class);
        return ResponseEntity.ok(user);
    }


}
