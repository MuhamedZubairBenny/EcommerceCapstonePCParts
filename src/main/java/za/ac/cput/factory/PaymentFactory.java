package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class PaymentFactory {

    public static Payment buildPayment(Long paymentId, User user, Order order, String paymentType, double paymentTotal) {
        if (paymentId == null || Helper.isNullOrEmpty(paymentType) || paymentTotal <= 0) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setUser(user)
                .setOrder(order)
                .setPaymentType(paymentType)
                .setPaymentTotal(paymentTotal)
                .build();
    }

    public static Payment buildPayment ( User user, Order order, String paymentType, double paymentTotal) {
        if (Helper.isNullOrEmpty(paymentType) || paymentTotal <= 0 || user == null) {
            return null;
        }

        Long paymentId = Helper.generateLongId();

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setUser(user)
                .setOrder(order)
                .setPaymentType(paymentType)
                .setPaymentTotal(paymentTotal)
                .build();
    }
}
