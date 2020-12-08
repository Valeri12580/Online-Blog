package softuni.onlineblog.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import softuni.onlineblog.domain.entities.Role;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.repositories.RoleRepository;
import softuni.onlineblog.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
@Order(2)
public class UserInitialization implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder encoder;
    private RoleRepository roleRepository;

    @Autowired
    public UserInitialization(UserRepository userRepository, PasswordEncoder encoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = this.roleRepository.findByRole("ADMIN");
        Role roleUser = this.roleRepository.findByRole("USER");
        //todo encode passwords
        User user = new User("ivan12", encoder.encode("ivan12345"), "ivan@abv.bg", "https://static.toiimg.com/photo/72975551.cmsxqFwoTCOCsqumrpe0CFQAAAAAdAAAAABAD",
                LocalDateTime.now(), null, Set.of(roleUser), null, null, null);

        User admin = new User("valeri", encoder.encode("valeri12345"), "valeri@abv.bg", "https://i.ytimg.com/vi/WhIrvsbEJ6Q/maxresdefault.jpg",
                LocalDateTime.now(), null, Set.of(roleAdmin, roleUser), null, null, null);

        userRepository.saveAll(List.of(user,admin));
    }
}
