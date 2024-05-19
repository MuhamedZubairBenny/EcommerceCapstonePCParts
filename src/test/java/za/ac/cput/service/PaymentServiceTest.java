package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {

    @Autowired
    private IPaymentService service;

    private Contact contact;
    private Customer customer;
    private OrderItem orderItem;
    private List<OrderItem> orderItemList;
    private Order order;
    private Payment payment;

    @BeforeEach
    void a_setUp() {
        contact = ContactFactory.buildContact("Mark@gmail.com", "0987654321", "29 Waterway", "Cape Town", "Western Province", "2604", "South Africa");
        customer = CustomerFactory.buildCustomer("001", "Mark", "Stevens", "Qw123", contact);
        orderItem = OrderItemFactory.buildOrderItem("01", "Graphic Card", 4500.00, "GeForce RTX 3050", 2);
        orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);
        order = OrderFactory.buildOrder("001", 1000.00, customer, orderItemList);
        payment = PaymentFactory.buildPayment("001", customer, order, "Credit card", 1000.0);
    }

    @Test
    void b_create() {
        Payment created = service.create(payment);
        assertNotNull(created);
        assertEquals(payment.getPaymentId(), created.getPaymentId());
        System.out.println("Created: " + created);
    }

    @Test
    void c_read() {
        Payment created = service.create(payment);
        Payment read = service.read(created.getPaymentId());
        assertNotNull(read);
        assertEquals(created.getPaymentId(), read.getPaymentId());
        System.out.println("Read: " + read);
    }

    @Test
    void d_update() {
        Payment created = service.create(payment);
        Payment updatedPayment = new Payment.Builder().copy(created).setPaymentTotal(1200.00).build();
        Payment updated = service.update(updatedPayment);
        assertNotNull(updated);
        assertEquals(1200.00, updated.getPaymentTotal());
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        Payment created = service.create(payment);
        service.delete(created.getPaymentId());
        Payment deleted = service.read(created.getPaymentId());
        assertNull(deleted);
        System.out.println("Deleted: " + created.getPaymentId());
    }

    @Test
    void f_getAll() {
        service.create(payment);
        List<Payment> payments = service.getAll();
        assertNotNull(payments);
        assertFalse(payments.isEmpty());
        System.out.println("All Payments: " + payments);
    }
}
