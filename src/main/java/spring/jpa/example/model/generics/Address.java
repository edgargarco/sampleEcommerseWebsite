package spring.jpa.example.model.generics;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Address  implements Serializable {

    private String Address;
    private String city;
    private String country;
    private String zipCode;
    private String anyDescription;

    public Address(){

    }



    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAnyDescription() {
        return anyDescription;
    }

    public void setAnyDescription(String anyDescription) {
        this.anyDescription = anyDescription;
    }
}
