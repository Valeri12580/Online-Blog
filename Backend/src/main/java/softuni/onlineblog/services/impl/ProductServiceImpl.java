package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.Product;
import softuni.onlineblog.domain.entities.PublishedIn;
import softuni.onlineblog.domain.models.service.ProductServiceModel;
import softuni.onlineblog.domain.models.service.UserServiceModel;
import softuni.onlineblog.exceptions.ProductNotFoundException;
import softuni.onlineblog.exceptions.UserNotFoundException;
import softuni.onlineblog.repositories.ProductRepository;
import softuni.onlineblog.services.ProductService;
import softuni.onlineblog.services.UserService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;
    private UserService userService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, UserService userService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public List<ProductServiceModel> findAllProducts() {
        return List.of(this.modelMapper.map(this.productRepository.findAll(), ProductServiceModel[].class));
    }

    @Override
    public void deleteProductById(String id) throws ProductNotFoundException {
        Product product = this.productRepository.findById(id).orElseThrow(() ->new ProductNotFoundException("Product not found"));

        productRepository.delete(product);
    }

    @Override
    public ProductServiceModel findProductById(String id) throws ProductNotFoundException {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return this.modelMapper.map(product,ProductServiceModel.class);
    }

    @Override
    public ProductServiceModel addProduct(ProductServiceModel productServiceModel,String username) throws UserNotFoundException {
        UserServiceModel user=this.userService.findUserByUsername(username);
        productServiceModel.setAuthor(user);

        productServiceModel.setPublishedIn(PublishedIn.SHOP);
        Product product=this.productRepository.save(this.modelMapper.map(productServiceModel,Product.class));
        return this.modelMapper.map(product,ProductServiceModel.class);
    }
}
