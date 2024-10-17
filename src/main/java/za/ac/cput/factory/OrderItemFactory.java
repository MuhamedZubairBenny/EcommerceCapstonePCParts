//package za.ac.cput.factory;
//
//
//import za.ac.cput.domain.Order;
//import za.ac.cput.domain.OrderItem;
//import za.ac.cput.domain.Product;
//import za.ac.cput.util.Helper;
//
//public class OrderItemFactory {
//    public static OrderItem buildOrderItem(String itemId, Product product, int quantity, Order order) {
//        if (Helper.isNullOrEmpty(itemId) || Helper.isNullOrZeroInt(quantity) || order.getOrderId() == null)
//            return null;
//
//        return new OrderItem.Builder().setItemId(itemId)
//                .setProduct(product)
//                .setQuantity(quantity)
//                .setOrder(order)
//                .build();
//    }
//
//    public static OrderItem buildOrderItem(Product product, int quantity, Order order){
//        if (Helper.isNullOrZeroInt(quantity) || order.getOrderId() == null)
//            return null;
//
//        String itemId = Helper.generateId();
//        return new OrderItem.Builder().setItemId(itemId)
//                .setProduct(product)
//                .setQuantity(quantity)
//                .setOrder(order)
//                .build();
//    }
//}