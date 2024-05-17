package za.ac.cput.domain;

import java.util.Objects;

public class Payment {
    private String paymentId;
    private Order order;
    private Customer customer;
    private String paymentType;
    private double paymentTotal;

    protected Payment() {}
    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.order = builder.order;
        this.customer = builder.customer;
        this.paymentType = builder.paymentType;
        this.paymentTotal = builder.paymentTotal;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Double.compare(getPaymentTotal(), payment.getPaymentTotal()) == 0 && Objects.equals(getPaymentId(), payment.getPaymentId()) && Objects.equals(getOrder(), payment.getOrder()) && Objects.equals(getCustomer(), payment.getCustomer()) && Objects.equals(getPaymentType(), payment.getPaymentType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentId(), getOrder(), getCustomer(), getPaymentType(), getPaymentTotal());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", order=" + order +
                ", customer=" + customer +
                ", paymentType='" + paymentType + '\'' +
                ", paymentTotal=" + paymentTotal +
                '}';
    }
    public static class Builder {
        private String paymentId;
        private Order order;
        private Customer customer;
        private String paymentType;
        private double paymentTotal;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setPaymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder setPaymentTotal(double paymentTotal) {
            this.paymentTotal = paymentTotal;
            return this;
        }
        public Builder copy(Payment payment){
            this.paymentId = payment.paymentId;
            this.order = payment.order;
            this.customer = payment.customer;
            this.paymentType = payment.paymentType;
            this.paymentTotal = payment.paymentTotal;
            return this;
        }
        public Payment build(){
            return new Payment(this);
        }
    }

}
//wow