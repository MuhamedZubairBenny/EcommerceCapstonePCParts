package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

public class PaymentFactory {

    public static Payment buildPayment(String paymentId, Customer customer, Order order, String paymentType, double paymentTotal) {
        if (Helper.isNullOrEmpty(paymentId) || Helper.isNullOrEmpty(paymentType) || paymentTotal <= 0) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setCustomer(customer)
                .setOrder(order)
                .setPaymentType(paymentType)
                .setPaymentTotal(paymentTotal)
                .build();
    }

    public static Payment buildPayment(String paymentType,Customer customer, Order order,double paymentTotal) {
        if (Helper.isNullOrEmpty(paymentType) || paymentTotal <= 0) {
            return null;
        }

        String paymentId = Helper.generateId();

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setCustomer(customer)
                .setOrder(order)
                .setPaymentType(paymentType)
                .setPaymentTotal(paymentTotal)
                .build();
    }
}
