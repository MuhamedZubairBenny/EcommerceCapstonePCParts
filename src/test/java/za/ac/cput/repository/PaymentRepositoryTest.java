package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentRepositoryTest {

    private static IPaymentRepository repository = PaymentRepository.getRepository();
    Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
    Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);
    Order order = OrderFactory.buildOrder("001",1000.00,customer,orderItemList);
    OrderItem orderItem = OrderItemFactory.buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050", 2);
    private static List<OrderItem> orderItemList = new ArrayList<OrderItem>();{
        orderItemList.add(orderItem);
    }
    Payment payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
    Delivery delivery = DeliveryFactory.buildDelivery(customer, order, payment, "01/06/2024","05/06/2024");

    @Test
    void a_create() {
        Payment created = repository.create(payment);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        String paymentId = "001";
        Payment read = repository.read(paymentId);
        assertEquals(read, payment);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Payment updated = repository.update(new Payment.Builder().copy(payment).setPaymentTotal(2000.00).build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        assertTrue(repository.delete(payment.getPaymentId()));
        System.out.println("Success: Deleted Payment");
    }

    @Test
    void d_getAll() {
        System.out.println(repository.getAll());
    }
}
