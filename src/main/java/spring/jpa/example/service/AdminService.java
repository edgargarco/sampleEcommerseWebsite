package spring.jpa.example.service;

import org.springframework.data.jpa.repository.Query;
import spring.jpa.example.model.Admin;
import spring.jpa.example.model.Customer;
import spring.jpa.example.service.generic.IOperations;

public interface AdminService extends IOperations<Admin> {
    @Query("SELECT u FROM Customer u WHERE u.email = :email AND u.password = :password")
    Admin findByEmailAndPassword(String email, String password);
}
