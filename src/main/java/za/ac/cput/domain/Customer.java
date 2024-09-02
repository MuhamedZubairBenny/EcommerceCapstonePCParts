package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    private String customer_id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL)
    private Shipping shipping;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;


    protected Customer(){}

    public Customer(Builder builder){
        this.customer_id = builder.customer_id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.mobileNumber = builder.mobileNumber;
        this.dateOfBirth = builder.dateOfBirth;
        this.shipping = builder.shipping;
        this.cart = builder.cart;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customer_id, customer.customer_id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && Objects.equals(mobileNumber, customer.mobileNumber) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(shipping, customer.shipping) && Objects.equals(cart, customer.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, firstName, lastName, email, password, mobileNumber, dateOfBirth, shipping, cart);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id='" + customer_id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", shipping=" + shipping +
                ", cart=" + cart +
                '}';
    }

    public static class Builder {
        private String customer_id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String mobileNumber;
        private LocalDate dateOfBirth;
        private Shipping shipping;
        private Cart cart;


        public Builder setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setShipping(Shipping shipping) {
            this.shipping = shipping;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder copy(Customer customer){
            this.customer_id = customer.customer_id;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.password = customer.password;
            this.mobileNumber = customer.mobileNumber;
            this.dateOfBirth = customer.dateOfBirth;
            this.shipping = customer.shipping;
            this.cart = customer.cart;
            return this;
        }

        public Customer build(){ return new Customer(this);}
    }
}