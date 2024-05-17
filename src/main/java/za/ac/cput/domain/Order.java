package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Objects;


public class Order {

    private String orderId;
    private double overallPrice;
    private Delivery delivery;
    private Customer customer;
    private OrderItem orderItem;

    protected Order(){}

    public Order(Builder builder){
    this.orderId = builder.orderId;
    this.overallPrice = builder.overallPrice;
    this.delivery = builder.delivery;
    this.customer = builder.customer;
    this.orderItem = builder.orderItem;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOverallPrice() {
        return overallPrice;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(overallPrice, order.overallPrice) == 0 && Objects.equals(orderId, order.orderId) && Objects.equals(delivery, order.delivery) && Objects.equals(customer, order.customer) && Objects.equals(orderItem, order.orderItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, overallPrice, delivery, customer, orderItem);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", overallPrice=" + overallPrice +
                ", delivery=" + delivery +
                ", customer=" + customer +
                ", orderItem=" + orderItem +
                '}';
    }

    public static class Builder{
        private String orderId;
        private double overallPrice;
        private Delivery delivery;
        private Customer customer;
        private OrderItem orderItem;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOverallPrice(double overallPrice) {
            this.overallPrice = overallPrice;
            return this;
        }

        public Builder setDelivery(Delivery delivery) {
            this.delivery = delivery;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setOrderItem(OrderItem orderItem) {
            this.orderItem = orderItem;
            return this;
        }
        public Builder copy(Order order){
            this.orderId = order.orderId;
            this.orderItem = order.orderItem;
            this.overallPrice = order.overallPrice;
            this.customer = order.customer;
            this.delivery = order.delivery;
            return this;
        }
        public Order build(){
            return new Order(this);
        }
    }
}
