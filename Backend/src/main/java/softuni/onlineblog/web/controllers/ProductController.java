package softuni.onlineblog.web.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.onlineblog.domain.models.view.ProductViewModel;
import softuni.onlineblog.services.ProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ModelMapper modelMapper;
    private ProductService productService;

    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductViewModel>> findAllProducts() {
        List<ProductViewModel> products = List.of(this.modelMapper.map(this.productService.findAllProducts(), ProductViewModel[].class));
        return ResponseEntity.ok(products);
    }
}
