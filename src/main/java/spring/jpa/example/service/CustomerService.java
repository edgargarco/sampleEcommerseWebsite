package spring.jpa.example.service;

import org.springframework.data.jpa.repository.Query;
import spring.jpa.example.model.Customer;
import spring.jpa.example.service.generic.IOperations;

public interface CustomerService extends IOperations<Customer> {
    @Query("SELECT u FROM Customer u WHERE u.email = :email AND u.password = :password")
    Customer findByEmailAndPassword(String email,String password);
}
