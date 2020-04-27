package spring.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.jpa.example.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("SELECT u from Admin u WHERE u.email = :email")
    Admin findByEmail(@Param("email") String email);

    @Query("SELECT u from Admin u WHERE u.confirmationToken = :confirmationToken")
    Admin findByConfirmationToken(String confirmationToken);

    @Query("SELECT u FROM Admin u WHERE u.email = :email AND u.password = :password")
    Admin findByEmailAndPassword(String email, String password);
}
