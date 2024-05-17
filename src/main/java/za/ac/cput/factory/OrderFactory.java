package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrderFactory {
    public static Order buildOrder(String orderId, double overallPrice, Delivery delivery, Customer customer,  List<OrderItem> orderItem ) {

        if (Helper.isNullOrEmpty(orderId) ||
                Helper.isNullOrEmpty(delivery.getDeliveryDate()) ||
                Helper.isNullOrEmpty(delivery.getTransitDate()) ||
                Helper.isNullOrEmpty(customer.getCustomerId()) ||
                Helper.isListEmpty(orderItem)
        )
            return null;
        if (overallPrice < 0)
            return null;

        return new Order.Builder().setOrderId(orderId)
                .setOverallPrice(overallPrice)
                .setDelivery(delivery)
                .setCustomer(customer)
                .setOrderItem(orderItem)
                .build();
    }
        public static Order buildOrder(String orderId, double overallPrice, String transitDate, String deliveryDate, String customerId,
                String itemId, String item, double price, String description, int quantity){

            List<String> dateFormats = Helper.getLocalDateFormats();

       if(Helper.isNullOrEmpty(orderId) || Helper.isNullOrEmpty(customerId) || Helper.isNullOrEmpty(itemId) || Helper.isNullOrEmpty(item)
                        || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(transitDate) || Helper.isNullOrEmpty(deliveryDate) )
                        return null;

            Date transitDateTime = Helper.isDateValid(transitDate, dateFormats);
            if (transitDateTime == null) {
                return null;
            }
            Date deliveryDateTime = Helper.isDateValid(deliveryDate, dateFormats);
            if (deliveryDateTime == null) {
                return null;
            }

            if(price<0 || overallPrice<0 ||quantity<0 )
             return null;

          Delivery delivery = new Delivery.Builder().setTransitDate(transitDate)
        .setDeliveryDate(deliveryDate)
        .build();

          OrderItem orderItem = new OrderItem.Builder().setItemId(itemId)
                    .setItem(item)
                    .setPrice(price)
                    .setDescription(description)
                    .setQuantity(quantity)
                    .build();
            List<OrderItem> orderItemList = new ArrayList<OrderItem>();
            orderItemList.add(orderItem);
        Customer customer = new Customer.Builder().setCustomerId(customerId)
        .build();

return new Order.Builder().setOrderId(orderId)
        .setOverallPrice(overallPrice)
        .setDelivery(delivery)
        .setCustomer(customer)
        .setOrderItem(orderItemList)
        .build();

        }
    }
