package za.ac.cput.factory;

import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.util.Date;
import java.util.List;

public class DeliveryFactory {
    public static Delivery buildDelivery(String transitDate, String deliveryDate){
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
        return new Delivery.Builder().setTransitDate(transitDate)
                .setDeliveryDate(deliveryDate)
                .build();
    }
}
