package softuni.onlineblog.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.view.UserViewModel;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.services.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private ModelMapper modelMapper;
    private UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
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
        }catch (UserNotFoundException ex){

        }



        Map<String, Boolean> map = new HashMap<>();
        map.put("email", userViewModelByEmail == null );
        map.put("username", userViewModelByUsername == null );
        return ResponseEntity.ok().body(map);
    }


}
