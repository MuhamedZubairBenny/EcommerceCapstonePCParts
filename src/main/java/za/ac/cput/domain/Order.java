package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false, unique = true)
    private String orderId;
    private double overallPrice;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItem;

    protected Order(){}

    public Order(Builder builder){
    this.orderId = builder.orderId;
    this.overallPrice = builder.overallPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOverallPrice() {
        return overallPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(overallPrice, order.overallPrice) == 0 && Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, overallPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", overallPrice=" + overallPrice +
                '}';
    }

    public static class Builder{
        private String orderId;
        private double overallPrice;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOverallPrice(double overallPrice) {
            this.overallPrice = overallPrice;
            return this;
        }



        public Builder copy(Order order){
            this.orderId = order.orderId;
            this.overallPrice = order.overallPrice;
            return this;
        }
        public Order build(){
            return new Order(this);
        }
    }
}
