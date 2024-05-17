package za.ac.cput.domain;

import java.util.List;
import java.util.Objects;

public class Cart {
    private String cartId;
    private Customer customer;
    private List<Product> products;
    private double totalPrice;

    protected Cart() {}
    private Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.customer = builder.customer;
        this.products = builder.products;
        this.totalPrice = builder.totalPrice;
    }
    public String getCartId() {
        return cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart cart)) return false;
        return Double.compare(getTotalPrice(), cart.getTotalPrice()) == 0 && Objects.equals(getCartId(), cart.getCartId()) && Objects.equals(getCustomer(), cart.getCustomer()) && Objects.equals(getProducts(), cart.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getCustomer(), getProducts(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }
    public static class Builder {
        private String cartId;
        private Customer customer;
        private List<Product> products;
        private double totalPrice;

        public Builder setCartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setProducts(List<Product> products) {
            this.products = products;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }
        public Builder copy(Cart cart){
            this.cartId = cart.cartId;
            this.customer = cart.customer;
            this.products = cart.products;
            this.totalPrice = cart.totalPrice;
            return this;
        }
        public Cart build(){
            return new Cart(this);
        }
    }
}
