package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrderFactory {
    public static Order buildOrder(String orderId, double overallPrice, Customer customer,  List<OrderItem> orderItem ) {

        if (Helper.isNullOrEmpty(orderId) ||
                Helper.isNullOrEmpty(customer.getCustomerId()) ||
                Helper.isListEmpty(orderItem)
        )
            return null;
        if (overallPrice < 0)
            return null;

        return new Order.Builder().setOrderId(orderId)
                .setOverallPrice(overallPrice)
                .setCustomer(customer)
                .setOrderItem(orderItem)
                .build();
    }
        public static Order buildOrder(String orderId, double overallPrice,Customer customer,
                String itemId, String item, double price, String description, int quantity){

        if(Helper.isNullOrEmpty(orderId) || Helper.isNullOrEmpty(itemId) || Helper.isNullOrEmpty(item)
                        || Helper.isNullOrEmpty(description))
            return null;

            if(price<0 || overallPrice<0 ||quantity<0 )
             return null;

            OrderItem orderItem = new OrderItem.Builder().setItemId(itemId)
                    .setItem(item)
                    .setPrice(price)
                    .setDescription(description)
                    .setQuantity(quantity)
                    .build();

            List<OrderItem> orderItemList = new ArrayList<OrderItem>();
            orderItemList.add(orderItem);

return new Order.Builder().setOrderId(orderId)
        .setOverallPrice(overallPrice)
        .setCustomer(customer)
        .setOrderItem(orderItemList)
        .build();

        }
    }
