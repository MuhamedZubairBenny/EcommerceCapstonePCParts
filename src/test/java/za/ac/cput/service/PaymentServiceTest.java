package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {

    @Autowired
    private IPaymentService service;


    private static Payment payment;

    @BeforeAll
    static void a_setUp() {
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Customer customer = CustomerFactory.buildCustomer("01","Mark","Stevens","Qw123",contact);
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");

        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
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
        Payment updatedPayment = new Payment.Builder().copy(payment).setPaymentTotal(1200.00).build();
        Payment updated = service.update(updatedPayment);
        assertNotNull(updated);
        assertEquals(1200.00, updated.getPaymentTotal());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void delete() {
        service.delete(payment.getPaymentId());
        Payment deleted = service.read(payment.getPaymentId());
        assertNull(deleted);
        System.out.println("Deleted payment: ");
    }

    @Test
    void f_getAll() {
        List<Payment> payments = service.getAll();
        assertNotNull(payments);
        assertFalse(payments.isEmpty());
        System.out.println("All Payments: " + payments);
    }
}
