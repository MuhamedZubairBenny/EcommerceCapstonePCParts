package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {
    @Id
    private String cartId;

    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartProduct> cartProducts;

    private double totalPrice;

    protected Cart() {}

    public Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.customer = builder.customer;
        this.cartProducts = builder.cartProducts;
        this.totalPrice = builder.totalPrice;
    }

    public String getCartId() { return cartId; }
    public Customer getCustomer() { return customer; }
    public List<CartProduct> getCartProducts() { return cartProducts; }
    public double getTotalPrice() { return totalPrice; }

    public void calculateTotalPrice() {
        this.totalPrice = cartProducts.stream()
                .mapToDouble(cartProduct -> cartProduct.getProduct().getPrice() * cartProduct.getQuantity())
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart cart)) return false;
        return Double.compare(cart.getTotalPrice(), getTotalPrice()) == 0 &&
                Objects.equals(getCartId(), cart.getCartId()) &&
                Objects.equals(getCustomer(), cart.getCustomer()) &&
                Objects.equals(getCartProducts(), cart.getCartProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getCustomer(), getCartProducts(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", customer=" + customer +
                ", cartProducts=" + cartProducts +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public static class Builder {
        private String cartId;
        private Customer customer;
        private List<CartProduct> cartProducts;
        private double totalPrice;

        public Builder setCartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setCartProducts(List<CartProduct> cartProducts) {
            this.cartProducts = cartProducts;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cartId = cart.cartId;
            this.customer = cart.customer;
            this.cartProducts = cart.cartProducts;
            this.totalPrice = cart.totalPrice;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}
