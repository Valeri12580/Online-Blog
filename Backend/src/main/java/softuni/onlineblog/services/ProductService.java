package softuni.onlineblog.services;

import softuni.onlineblog.domain.models.service.ProductServiceModel;
import softuni.onlineblog.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<ProductServiceModel>findAllProducts();

    void deleteProductById(String id ) throws ProductNotFoundException;
}
