package za.ac.cput.domain;
/*
Author:
Imaan Sadien - 221752838
GitHub Repo:
https://github.com/Elentiya10/EcommercePCParts
 */

import java.util.Objects;

public class Delivery {
    private String deliveryId;
    private Customer customer;
    private Order order;
    private Payment payment;
    private String transitDate;
    private String deliveryDate;

    protected Delivery(){}

    public Delivery(Builder builder){
        this.deliveryId = builder.deliveryId;
        this.customer = builder.customer;
        this.order = builder.order;
        this.payment = builder.payment;
        this.transitDate = builder.transitDate;
        this.deliveryDate = builder.deliveryDate;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order getOrder() {
        return order;
    }

    public Payment getPayment() {
        return payment;
    }

    public String getTransitDate() {
        return transitDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(deliveryId, delivery.deliveryId) && Objects.equals(customer, delivery.customer) && Objects.equals(order, delivery.order) && Objects.equals(payment, delivery.payment) && Objects.equals(transitDate, delivery.transitDate) && Objects.equals(deliveryDate, delivery.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, customer, order, payment, transitDate, deliveryDate);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId='" + deliveryId + '\'' +
                ", customer=" + customer +
                ", order=" + order +
                ", payment=" + payment +
                ", transitDate='" + transitDate + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                '}';
    }

    public static class Builder{
        private String deliveryId;
        private Customer customer;
        private Order order;
        private Payment payment;
        private String transitDate;
        private String deliveryDate;

        public Builder setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder setTransitDate(String transitDate) {
            this.transitDate = transitDate;
            return this;
        }

        public Builder setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder copy(Delivery delivery){
            this.deliveryId = delivery.deliveryId;
            this.customer = delivery.customer;
            this.order = delivery.order;
            this.payment = delivery.payment;
            this.transitDate = delivery.transitDate;
            this.deliveryDate = delivery.deliveryDate;
            return this;
        }

        public Delivery build(){
            return new Delivery(this);
        }
    }
}
