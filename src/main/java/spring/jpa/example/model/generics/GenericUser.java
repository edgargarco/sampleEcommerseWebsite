package spring.jpa.example.model.generics;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@MappedSuperclass
public class GenericUser<T> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2, max=40,message = "Este campo debe tener entre 2 y 40 caracteres")
    private String firstName;

    @Size(min=2, max=40,message = "Este campo debe tener entre 2 y 40 caracteres")
    private String lastName;
    @NotEmpty(message = "Este campo no puede ser nulo")
    private String phone;

    @Column(unique = true,nullable = false)
    @Email
    @NotEmpty(message = "Este campo no puede ser nulo")
    private String email;
    @Embedded
    @Column(name = "BillingAddress",insertable = false,updatable = false)
    private Address billingAddress;
    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Size(min = 6, message = "Su Contraseña debe tener minimo 6 caracteres")
    private String password;
    private Boolean isAvailable;


    public GenericUser() {
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NotNull String phone) {
        this.phone = phone;
    }



    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }


}
