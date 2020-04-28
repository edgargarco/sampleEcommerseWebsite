package spring.jpa.example.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import spring.jpa.example.model.Product;
import spring.jpa.example.model.generics.Tag;
import spring.jpa.example.repository.ProductRepository;
import spring.jpa.example.repository.TagRepository;
import spring.jpa.example.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private static Log log = LogFactory.getLog(ProductServiceImpl.class);
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product findOne(long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }

    @Override
    public Product find(Product entity) {
        return null;
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> create(Product entity) {
           return Optional.ofNullable(productRepository.save(entity));
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
    public Optional<Product> createProductAndTags(Product entity, String[] tags){

            Optional<Product> product = productRepository.findById(entity.getId());
            if(product == null){
                productRepository.save(entity);
            }
        return Optional.ofNullable(entity);
    }

}
