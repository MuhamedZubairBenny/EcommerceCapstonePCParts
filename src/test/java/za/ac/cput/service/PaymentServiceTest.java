package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {

    @Autowired
    private IPaymentService service;

    private Customer customer1;
    private OrderItem orderItem;
    private List<OrderItem> orderItemList;
    private Order order;
    private Payment payment;

    @BeforeEach
    void a_setUp() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> products = new ArrayList<>();
        Cart cart = CartFactory.buildCart(products);

        //Build Customer
        customer1 = CustomerFactory.buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer1);
        System.out.println(customer1);
        order = OrderFactory.buildOrder("001", 14500.00);
        payment = PaymentFactory.buildPayment("001", customer1, order, "Credit card", 1000.0);
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
    @Disabled
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
