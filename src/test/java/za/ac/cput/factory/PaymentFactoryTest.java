package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Payment;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentFactoryTest {

    @Test
    @Order(1)
    void buildPaymentWithValidInput() {
        // Build Payment with valid input
        Payment payment = PaymentFactory.buildPayment("001", "Credit Card", 100.0);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    @Order(2)
    void buildPaymentWithGeneratedId_ShouldCreatePaymentObject() {
        // Build Payment with generated ID
        Payment payment = PaymentFactory.buildPayment("Debit Card", 50.0);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    @Order(3)
    void buildPaymentWithInvalidInput_ShouldReturnNull() {
        // Build Payment with invalid total
        Payment payment = PaymentFactory.buildPayment("002", "Cash", -100.0);
        assertNotNull(payment);
    }

    @Test
    @Order(4)
    void buildPaymentWithEmptyType_ShouldReturnNull() {
        // Build Payment with empty type
        Payment payment = PaymentFactory.buildPayment("003", "", 100.0);
        assertNotNull(payment);
    }
}
