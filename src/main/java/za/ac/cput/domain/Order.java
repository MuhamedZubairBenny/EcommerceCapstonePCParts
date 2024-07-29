package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
@Id
    private String orderId;
    private double overallPrice;
    @OneToOne
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItem;

    protected Order(){}

    public Order(Builder builder){
    this.orderId = builder.orderId;
    this.overallPrice = builder.overallPrice;
    this.customer = builder.customer;
    this.orderItem = builder.orderItem;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOverallPrice() {
        return overallPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(overallPrice, order.overallPrice) == 0 && Objects.equals(orderId, order.orderId) && Objects.equals(customer, order.customer) && Objects.equals(orderItem, order.orderItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, overallPrice, customer, orderItem);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", overallPrice=" + overallPrice +
                ", customer=" + customer +
                ", orderItem=" + orderItem +
                '}';
    }

    public static class Builder{
        private String orderId;
        private double overallPrice;
        private Customer customer;
        private  List<OrderItem> orderItem;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOverallPrice(double overallPrice) {
            this.overallPrice = overallPrice;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setOrderItem( List<OrderItem> orderItem) {
            this.orderItem = orderItem;
            return this;
        }
        public Builder copy(Order order){
            this.orderId = order.orderId;
            this.orderItem = order.orderItem;
            this.overallPrice = order.overallPrice;
            this.customer = order.customer;
            return this;
        }
        public Order build(){
            return new Order(this);
        }
    }
}
