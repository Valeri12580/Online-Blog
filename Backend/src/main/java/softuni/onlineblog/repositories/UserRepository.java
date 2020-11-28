package softuni.onlineblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.onlineblog.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUsername(String username);

}
