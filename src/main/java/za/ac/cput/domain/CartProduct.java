package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class CartProduct {
    @EmbeddedId
    private CartProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartId")
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;

    protected CartProduct() {}

    public CartProduct(Builder builder) {
        this.id = builder.id;
        this.cart = builder.cart;
        this.product = builder.product;
        this.quantity = builder.quantity;
    }

    public CartProductId getId() { return id; }
    public Cart getCart() { return cart; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartProduct that)) return false;
        return quantity == that.quantity &&
                Objects.equals(id, that.id) &&
                Objects.equals(cart, that.cart) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cart, product, quantity);
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "id=" + id +
                ", cartId=" + (cart != null ? cart.getCartId() : "null") +
                ", productId=" + (product != null ? product.getProductId() : "null") +
                ", quantity=" + quantity +
                '}';
    }

    public static class Builder {
        private CartProductId id;
        private Cart cart;
        private Product product;
        private int quantity;

        public Builder setId(CartProductId id) {
            this.id = id;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(CartProduct cartProduct) {
            this.id = cartProduct.id;
            this.cart = cartProduct.cart;
            this.product = cartProduct.product;
            this.quantity = cartProduct.quantity;
            return this;
        }

        public CartProduct build() {
            return new CartProduct(this);
        }
    }
}