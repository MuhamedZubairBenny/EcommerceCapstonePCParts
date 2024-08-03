package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class OrderItem{
@Id
    private String itemId;
    private String item;
    private Double price;
    private String description;
    private int quantity;

 @ManyToOne( cascade = CascadeType.ALL,  fetch = FetchType.LAZY )
 @JoinColumn(name = "order_id")
private Order order;
    protected OrderItem(){}

    public OrderItem(Builder builder){
        this.itemId = builder.itemId;
        this.item = builder.item;
        this.description=builder.description;
        this.price= builder.price;
        this.quantity = builder.quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItem() {
        return item;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && Objects.equals(itemId, orderItem.itemId) && Objects.equals(item, orderItem.item) && Objects.equals(price, orderItem.price) && Objects.equals(description, orderItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, item, price, description, quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId='" + itemId + '\'' +
                ", item='" + item + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
    public static class Builder{
        private String itemId;
        private String item;
        private Double price;
        private String description;
        private int quantity;

        public Builder setItemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder setItem(String item) {
            this.item = item;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        public Builder copy(OrderItem orderItem){
        this.itemId = orderItem.itemId;
        this.item = orderItem.item;
        this.description = orderItem.description;
        this.price = orderItem.price;
        this.quantity = orderItem.quantity;
        return this;
        }
        public OrderItem build(){
            return new OrderItem(this);
        }
    }
}
