package spring.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.jpa.example.model.Customer;
import spring.jpa.example.model.Product;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT u from Customer u WHERE u.email = :email")
    Customer findByEmail(@Param("email") String email);
    @Query("SELECT u from Customer u WHERE u.confirmationToken = :confirmationToken")
    Customer findByConfirmationToken(String confirmationToken);
    @Query("SELECT u FROM Customer u WHERE u.email = :email AND u.password = :password")
    Customer findByEmailAndPassword(String email,String password);
}
