package za.ac.cput.repository;

import za.ac.cput.domain.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IPaymentRepository {
    private static IPaymentRepository repository = null;
    private List<Payment> paymentList;

    private PaymentRepository() {
        paymentList = new ArrayList<>();
    }

    public static IPaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        boolean success = paymentList.add(payment);
        if (success)
            return payment;
        return null;
    }

    @Override
    public Payment read(String id) {
        for (Payment p : paymentList) {
            if (p.getPaymentId().equals(id))
                return p;
        }
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        Payment paymentToUpdate = read(payment.getPaymentId());

        boolean success = paymentList.remove(paymentToUpdate);
        if (success) {
            if (paymentList.add(payment))
                return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String paymentId) {
        Payment paymentToDelete = read(paymentId);
        boolean success = paymentList.remove(paymentToDelete);
        return success;
    }

    @Override
    public List<Payment> getAll() {
        return paymentList;
    }
}
