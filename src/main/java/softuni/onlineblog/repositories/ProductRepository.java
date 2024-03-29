package softuni.onlineblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.onlineblog.domain.entities.Product;

import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product,String> {

    Optional<Product> findByTitle(String title);
}
