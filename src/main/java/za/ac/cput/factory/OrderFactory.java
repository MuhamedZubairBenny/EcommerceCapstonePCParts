package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class OrderFactory {
    public static Order buildOrder(Long orderId, double overallPrice, Cart cart) {

        if (orderId == null || Helper.isNullOrZeroDouble(overallPrice) || cart ==null )
            return null;

        return new Order.Builder().setOrderId(orderId)
                .setOverallPrice(overallPrice)
                .setCart(cart)
                .build();
    }
    public static Order buildOrder(double overallPrice, Cart cart){
        if (Helper.isNullOrZeroDouble(overallPrice) || cart == null )
            return null;

        Long orderId = Helper.generateLongId();

        return new Order.Builder().setOrderId(orderId)
                .setOverallPrice(overallPrice)
                .setCart(cart)
                .build();
        }
}
