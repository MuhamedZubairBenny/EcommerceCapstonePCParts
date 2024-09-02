package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Shipping {
    @Id
    private String shippingId;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    protected Shipping() {}

    public Shipping(Builder builder) {
        this.shippingId = builder.shippingId;
        this.address = builder.address;
        this.city = builder.city;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.country = builder.country;
    }

    // Getters
    public String getShippingId() {
        return shippingId;
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
        Shipping shipping = (Shipping) o;
        return Objects.equals(shippingId, shipping.shippingId) &&
                Objects.equals(address, shipping.address) &&
                Objects.equals(city, shipping.city) &&
                Objects.equals(state, shipping.state) &&
                Objects.equals(zipCode, shipping.zipCode) &&
                Objects.equals(country, shipping.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shippingId, address, city, state, zipCode, country);
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "shippingId='" + shippingId + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static class Builder {
        private String shippingId;
        private String address;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        public Builder setShippingId(String shippingId) {
            this.shippingId = shippingId;
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


        public Builder copy(Shipping shipping) {
            this.shippingId = shipping.shippingId;
            this.address = shipping.address;
            this.city = shipping.city;
            this.state = shipping.state;
            this.zipCode = shipping.zipCode;
            this.country = shipping.country;
            return this;
        }

        public Shipping build() {
            return new Shipping(this);
        }
    }
}