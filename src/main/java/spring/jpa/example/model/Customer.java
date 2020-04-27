package spring.jpa.example.model;

import spring.jpa.example.model.generics.Address;
import spring.jpa.example.model.generics.GenericUser;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Customer extends GenericUser<Customer> implements Serializable {
    public Customer() {
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getConfirmationToken() {
        return super.getConfirmationToken();
    }

    @Override
    public void setConfirmationToken(String confirmationToken) {
        super.setConfirmationToken(confirmationToken);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String getPhone() {
        return super.getPhone();
    }

    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }


    @Override
    public Address getBillingAddress() {
        return super.getBillingAddress();
    }

    @Override
    public void setBillingAddress(Address billingAddress) {
        super.setBillingAddress(billingAddress);
    }
}
