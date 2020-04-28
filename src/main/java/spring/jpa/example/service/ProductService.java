package spring.jpa.example.service;

import spring.jpa.example.model.Product;
import spring.jpa.example.service.generic.IOperations;

import java.util.Optional;

public interface ProductService extends IOperations<Product> {
    Optional<Product> createProductAndTags(Product entity, String[] tags);

}
