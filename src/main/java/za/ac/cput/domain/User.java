package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL)
    private Shipping shipping;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    protected User(){}
    public User(Builder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.mobileNumber = builder.mobileNumber;
        this.dateOfBirth = builder.dateOfBirth;
        this.shipping = builder.shipping;
        this.cart = builder.cart;
    }

    public Long getId() {
        return id;
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
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(mobileNumber, user.mobileNumber) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(shipping, user.shipping) && Objects.equals(cart, user.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, mobileNumber, dateOfBirth, shipping, cart);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
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
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String mobileNumber;
        private LocalDate dateOfBirth;
        private Shipping shipping;
        private Cart cart;

        public Builder setId(Long id) {
            this.id = id;
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

        public Builder copy(User user){
            this.id = user.id;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.email = user.email;
            this.password = user.password;
            this.mobileNumber = user.mobileNumber;
            this.dateOfBirth = user.dateOfBirth;
            this.shipping = user.shipping;
            this.cart = user.cart;
            return this;
        }

        public User build(){ return new User(this);}
    }
}
