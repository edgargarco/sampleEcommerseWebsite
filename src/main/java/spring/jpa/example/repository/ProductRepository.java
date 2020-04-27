package spring.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.jpa.example.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {



}
