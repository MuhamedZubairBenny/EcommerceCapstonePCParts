package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;

public class PaymentFactory {

    public static Payment buildPayment(String paymentId, String paymentType, double paymentTotal) {
        if (Helper.isNullOrEmpty(paymentId) || Helper.isNullOrEmpty(paymentType) || paymentTotal <= 0) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setPaymentType(paymentType)
                .setPaymentTotal(paymentTotal) // This line sets the payment total
                .build();
    }

    public static Payment buildPayment(String paymentType, double paymentTotal) {
        if (Helper.isNullOrEmpty(paymentType) || paymentTotal <= 0) {
            return null;
        }

        String paymentId = Helper.generateId();

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setPaymentType(paymentType)
                .setPaymentTotal(paymentTotal)  // This line sets the payment total
                .build();
    }
}
