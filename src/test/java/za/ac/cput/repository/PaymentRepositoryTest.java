package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentRepositoryTest {

    private static IPaymentRepository repository = PaymentRepository.getRepository();

    Payment payment1 = PaymentFactory.buildPayment("001", "Credit Card", 1000.00);
    Payment payment2 = PaymentFactory.buildPayment("002", "Debit Card", 1500.00);
    private static List<Payment> paymentList = new ArrayList<>();
    {
        paymentList.add(payment1);
        paymentList.add(payment2);
    }

    @Test
    void a_create() {
        Payment created = repository.create(payment1);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        String paymentId = "001";
        Payment read = repository.read(paymentId);
        assertEquals(read, payment1);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Payment updated = repository.update(new Payment.Builder().copy(payment1).setPaymentTotal(2000.00).build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        assertTrue(repository.delete(payment1.getPaymentId()));
        System.out.println("Success: Deleted Payment");
    }

    @Test
    void d_getAll() {
        System.out.println(repository.getAll());
    }
}
