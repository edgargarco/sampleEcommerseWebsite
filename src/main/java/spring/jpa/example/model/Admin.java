package spring.jpa.example.model;

import spring.jpa.example.model.generics.Address;
import spring.jpa.example.model.generics.GenericUser;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Entity
public class Admin extends GenericUser<Admin> {
    public Admin() {
    }

    @Override
    public String getConfirmationToken() {
        return super.getConfirmationToken();
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
    public @NotNull String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(@NotNull String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public @NotNull String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(@NotNull String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public @NotNull String getPhone() {
        return super.getPhone();
    }

    @Override
    public void setPhone(@NotNull String phone) {
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
