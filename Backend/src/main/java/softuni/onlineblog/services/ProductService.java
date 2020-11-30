package softuni.onlineblog.services;

import softuni.onlineblog.domain.models.service.ProductServiceModel;

import java.util.List;

public interface ProductService {
    List<ProductServiceModel>findAllProducts();
}
