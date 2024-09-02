package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {
    @Id
    private String cartId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
    private double cartTotal = 0.0;

    protected  Cart() {}

    public Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.products = builder.products;
        this.cartTotal = calculateCartTotal();
    }
    public String getCartId() {
        return cartId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    private double calculateCartTotal() {
        if (products == null || products.isEmpty()) {
            return 0.0;
        }
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", products=" + products +
                ", cartTotal=" + cartTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Double.compare(cartTotal, cart.cartTotal) == 0 && Objects.equals(cartId, cart.cartId) && Objects.equals(products, cart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, products, cartTotal);
    }

    public static class Builder {
        private String cartId;
        private List<Product> products;
        private double cartTotal;

        public Builder setCartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setProducts(List<Product> products) {
            this.products = products;
            this.cartTotal = products != null ? products.stream().mapToDouble(Product::getPrice).sum() : 0.0;
            return this;
        }

        public Builder setCartTotal(double cartTotal) {
            this.cartTotal = cartTotal;
            return this;
        }

        public Builder copy(Cart cart){
            this.cartId = cart.cartId;
            this.products = cart.products;
            this.cartTotal = cart.cartTotal;
            return this;
        }

        public Cart build() {return new Cart(this);}
    }
}