package softuni.onlineblog.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import softuni.onlineblog.domain.entities.Role;
import softuni.onlineblog.repositories.RoleRepository;

import java.util.List;

@Component
@Order(1)
public class RolesInitialization implements CommandLineRunner {

    private RoleRepository repository;


    @Autowired
    public RolesInitialization(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role admin=new Role("ADMIN");
        Role user=new Role("USER");

        this.repository.saveAll(List.of(admin,user
        ));
    }
}
