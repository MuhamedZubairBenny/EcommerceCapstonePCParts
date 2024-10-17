package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id

    @GeneratedValue
    private Long orderId;
    private double overallPrice;
    @OneToOne
    private Cart cart;

    protected Order(){}

    public Order(Builder builder){
    this.orderId = builder.orderId;
    this.cart = builder.cart;
    this.overallPrice = builder.overallPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getOverallPrice() {
        return overallPrice;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(overallPrice, order.overallPrice) == 0 && Objects.equals(orderId, order.orderId) && Objects.equals(cart, order.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, overallPrice, cart);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", overallPrice=" + overallPrice +
                ", cart=" + cart +
                '}';
    }

    public static class Builder{
        private Long orderId;
        private double overallPrice;
        private Cart cart;


        public Builder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOverallPrice(double overallPrice) {
            this.overallPrice = overallPrice;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder copy(Order order){
            this.orderId = order.orderId;
            this.overallPrice = order.overallPrice;
            this.cart = order.cart;
            return this;
        }
        public Order build(){
            return new Order(this);
        }
    }
}
