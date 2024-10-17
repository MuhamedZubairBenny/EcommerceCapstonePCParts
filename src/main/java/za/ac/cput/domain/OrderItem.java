//package za.ac.cput.domain;
//
//import jakarta.persistence.*;
//
//import java.util.Objects;
//
//@Entity
//public class OrderItem{
//    @Id
//    private String itemId;
//    private int quantity;
//    @ManyToOne
//    @JoinColumn(name = "order_id", nullable = false)
//    private Order order;
//    protected OrderItem(){}
//
//    public OrderItem(Builder builder){
//        this.itemId = builder.itemId;
//        this.product = builder.product;
//        this.quantity = builder.quantity;
//        this.order = builder.order;
//    }
//
//    public String getItemId() {
//        return itemId;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderItem orderItem = (OrderItem) o;
//        return quantity == orderItem.quantity && Objects.equals(itemId, orderItem.itemId) && Objects.equals(product, orderItem.product) && Objects.equals(order, orderItem.order);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(itemId, product, quantity, order);
//    }
//
//    @Override
//    public String toString() {
//        return "OrderItem{" +
//                "itemId='" + itemId + '\'' +
//                ", product=" + product +
//                ", quantity=" + quantity +
//                ", order=" + order +
//                '}';
//    }
//
//    public static class Builder {
//        private String itemId;
//        private Product product;
//        private int quantity;
//        private Order order;
//
//        public Builder setItemId(String itemId) {
//            this.itemId = itemId;
//            return this;
//        }
//
//        public Builder setProduct(Product product) {
//            this.product = product;
//            return this;
//        }
//
//        public Builder setQuantity(int quantity) {
//            this.quantity = quantity;
//            return this;
//        }
//
//        public Builder setOrder(Order order) {
//            this.order = order;
//            return this;
//        }
//
//        public Builder copy(OrderItem orderItem){
//            this.itemId = orderItem.itemId;
//            this.product = orderItem.product;
//            this.quantity = orderItem.quantity;
//            this.order = orderItem.order;
//            return this;
//        }
//
//        public OrderItem build() {return new OrderItem(this);}
//    }
//}
