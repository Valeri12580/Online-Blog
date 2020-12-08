package softuni.onlineblog.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import softuni.onlineblog.domain.models.binding.UserRegisterBindingModel;
import softuni.onlineblog.domain.models.service.UserServiceModel;
import softuni.onlineblog.domain.models.view.UserViewModel;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.services.UserService;
import softuni.onlineblog.services.impl.UserDetailsServiceImpl;
import softuni.onlineblog.util.jwt.JwtUtil;
import softuni.onlineblog.util.jwt.LoginRequestDto;
import softuni.onlineblog.util.jwt.LoginResponseDto;

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
    private JwtUtil jwtUtil;


    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsServiceImpl, JwtUtil jwtUtil) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtUtil = jwtUtil;
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

    @PostMapping("/login")
    public ResponseEntity<?> authenticate( @RequestBody LoginRequestDto loginRequestDto) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Invalid username or password!");
        }
        UserDetails user = userDetailsServiceImpl.loadUserByUsername(loginRequestDto.getUsername());

        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void>logout(){
        System.out.println("Logged out!");
        SecurityContextHolder.getContext().setAuthentication(null);
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return ResponseEntity.ok().build();
    }


}
