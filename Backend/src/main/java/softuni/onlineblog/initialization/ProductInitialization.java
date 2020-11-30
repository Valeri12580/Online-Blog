package softuni.onlineblog.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import softuni.onlineblog.domain.entities.Product;
import softuni.onlineblog.domain.entities.PublishedIn;
import softuni.onlineblog.domain.entities.User;
import softuni.onlineblog.repositories.ProductRepository;
import softuni.onlineblog.repositories.UserRepository;

import java.math.BigDecimal;

@Component
@Order(4)
public class ProductInitialization  implements CommandLineRunner {

    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public ProductInitialization(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //todo fix empty author_id in Product and Article Tables
        User user=userRepository.findUserByUsername("valeri").get();
        Product productOne=new Product("Whey protein","The protein is the main building block of the muscle.Every human need a certain amount to be able to help build muscle mass and growth. In addition, it is involved in many processes. The benefits of its increased intake are: faster recovery, increased muscle mass, accelerated metabolism and others ..."
        ,user,"https://st2.depositphotos.com/1177973/5235/i/600/depositphotos_52354609-stock-photo-whey-protein-powder-in-scoop.jpg",null, PublishedIn.SHOP,3,new BigDecimal("50.99"));

        productRepository.save(productOne);
    }
}
