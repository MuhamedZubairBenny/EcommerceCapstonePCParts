package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

import java.util.Date;
import java.util.List;

public class DeliveryFactory {
    public static Delivery buildDelivery(String deliveryId, Customer customer, Order order, Payment payment, String transitDate, String deliveryDate){
        List<String> dateFormats = Helper.getLocalDateFormats();
    if(Helper.isNullOrEmpty(deliveryId) ||Helper.isNullOrEmpty(transitDate) || Helper.isNullOrEmpty(deliveryDate))
    return null;

    Date transitDateTime = Helper.isDateValid(transitDate, dateFormats);
    if (transitDateTime == null) {
        return null;
    }
    Date deliveryDateTime = Helper.isDateValid(deliveryDate, dateFormats);
    if (deliveryDateTime == null) {
        return null;
        }

    return new Delivery.Builder().setDeliveryId(deliveryId).setCustomer(customer).setOrder(order).setPayment(payment).setTransitDate(transitDate)
                .setDeliveryDate(deliveryDate)
                .build();
    }

    public static Delivery buildDelivery(Customer customer, Order order, Payment payment, String transitDate, String deliveryDate){
        List<String> dateFormats = Helper.getLocalDateFormats();
        if(Helper.isNullOrEmpty(transitDate) || Helper.isNullOrEmpty(deliveryDate))
            return null;

        Date transitDateTime = Helper.isDateValid(transitDate, dateFormats);
        if (transitDateTime == null) {
            return null;
        }
        Date deliveryDateTime = Helper.isDateValid(deliveryDate, dateFormats);
        if (deliveryDateTime == null) {
            return null;
        }

        String deliveryId = Helper.generateId();

        return new Delivery.Builder().setDeliveryId(deliveryId).setCustomer(customer).setOrder(order).setPayment(payment).setTransitDate(transitDate)
                .setDeliveryDate(deliveryDate)
                .build();
    }
}
