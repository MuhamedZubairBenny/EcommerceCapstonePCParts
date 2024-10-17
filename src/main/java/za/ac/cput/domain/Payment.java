package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity

public class Payment {
    @Id
    @GeneratedValue
    private Long paymentId;
    @OneToOne
    private Order order;
    @OneToOne
    private User user;
    private String paymentType;
    private double paymentTotal;

    protected Payment() {}
    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.order = builder.order;
        this.user = builder.user;
        this.paymentType = builder.paymentType;
        this.paymentTotal = builder.paymentTotal;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public User getUser() {
        return user;
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
        return Double.compare(getPaymentTotal(), payment.getPaymentTotal()) == 0 && Objects.equals(getPaymentId(), payment.getPaymentId()) && Objects.equals(getOrder(), payment.getOrder()) && Objects.equals(getUser(), payment.getUser()) && Objects.equals(getPaymentType(), payment.getPaymentType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentId(), getOrder(), getUser(), getPaymentType(), getPaymentTotal());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", order=" + order +
                ", paymentType='" + paymentType + '\'' +
                ", paymentTotal=" + paymentTotal +
                '}';
    }
    public static class Builder {
        private Long paymentId;
        private Order order;
        private User user;
        private String paymentType;
        private double paymentTotal;

        public Builder setPaymentId(Long paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
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
            this.user = payment.user;
            this.paymentType = payment.paymentType;
            this.paymentTotal = payment.paymentTotal;
            return this;
        }
        public Payment build(){
            return new Payment(this);
        }
    }

}
