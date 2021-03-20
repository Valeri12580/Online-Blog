package softuni.onlineblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.onlineblog.domain.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByRole(String role);


}
