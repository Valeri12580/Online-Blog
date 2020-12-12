package softuni.onlineblog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.onlineblog.domain.entities.Product;
import softuni.onlineblog.domain.models.service.ProductServiceModel;
import softuni.onlineblog.exceptions.ProductNotFoundException;
import softuni.onlineblog.repositories.ProductRepository;
import softuni.onlineblog.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
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
}
