package za.ac.cput.factory;


import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

public class OrderItemFactory {
    public static OrderItem buildOrderItem(String itemId, String item, double price, String description, int quantity) {
        if (Helper.isNullOrEmpty(itemId) || Helper.isNullOrEmpty(item) || Helper.isNullOrEmpty(description))
            return null;
        if (price < 0 || quantity < 0)
            return null;
        return new OrderItem.Builder().setItemId(itemId)
                .setItem(item)
                .setPrice(price)
                .setDescription(description)
                .setQuantity(quantity)
                .build();
    }
}