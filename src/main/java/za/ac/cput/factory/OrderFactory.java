package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrderFactory {
    public static Order buildOrder(String orderId, double overallPrice) {

        if (Helper.isNullOrEmpty(orderId) || Helper.isNullOrZeroDouble(overallPrice) )
            return null;

        return new Order.Builder().setOrderId(orderId)
                .setOverallPrice(overallPrice)

                .build();
    }
    public static Order buildOrder(double overallPrice){
        if (Helper.isNullOrZeroDouble(overallPrice) )
            return null;

        String orderId = Helper.generateId();

        return new Order.Builder().setOrderId(orderId)
                .setOverallPrice(overallPrice)
                .build();
        }
}
