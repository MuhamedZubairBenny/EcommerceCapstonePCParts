package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Contact {
    @Id
    private String email;
    private String mobile;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    protected Contact(){}
    public Contact(Builder builder) {
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.country = builder.country;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(mobile, contact.mobile) && Objects.equals(address, contact.address) && Objects.equals(city, contact.city) && Objects.equals(state, contact.state) && Objects.equals(zipCode, contact.zipCode) && Objects.equals(country, contact.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobile, address, city, state, zipCode, country);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static class Builder {
        private String email;
        private String mobile;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder copy(Contact contact){
            this.email = contact.email;
            this.mobile = contact.mobile;
            this.address = contact.address;
            this.city = contact.city;
            this.state = contact.state;
            this.zipCode = contact.zipCode;
            this.country = contact.country;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
