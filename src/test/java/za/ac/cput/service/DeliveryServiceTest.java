package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.OrderItemFactory;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.PaymentFactory;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryServiceTest {
    @Autowired
    private DeliveryService deliveryService;
    private static Delivery delivery1;
    private static Delivery delivery2;

    @Test
    void a_setup(){
        Contact contact = ContactFactory.buildContact("imaan@gmail.com","0631249584","20 Berry Lane", "Cape Town", "Western Cape", "7264", "South Africa");
        Customer customer = CustomerFactory.buildCustomer("1236", "Imaan", "Sadien", "ryanreynolds", contact );
        OrderItem orderItem = OrderItemFactory.buildOrderItem("6245", "SSD", 820.00, "Solid State Drive", 1);
        Order order = OrderFactory.buildOrder("1624", 820.00, customer, orderItem.getItemId(), orderItem.getItem(), 820.00, "Solid State Drive", 1);
        Payment payment = PaymentFactory.buildPayment("2564", customer, order, "Card",820.00);
        delivery1 = DeliveryFactory.buildDelivery(customer,order, payment,"15/05/2024","23/05/2024");
        assertNotNull(delivery1);
        Contact contact2 = ContactFactory.buildContact("aqeel@yahoo.com","0864325648","42 Hop Street", "Cape Town", "Western Cape", "1325", "South Africa");
        Customer customer2 = CustomerFactory.buildCustomer("1634", "Aqeel", "Taliep", "blakelively", contact2);
        OrderItem orderItem2 = OrderItemFactory.buildOrderItem("3649", "GPU", 1200.00, "Graphics Card", 1);
        Order order2 = OrderFactory.buildOrder("6321", 1200.00, customer2, orderItem2.getItemId(), orderItem2.getItem(), 1200.00, "Graphics Card", 1);
        Payment payment2 = PaymentFactory.buildPayment("5216", customer2, order2, "Card",1200.00);
        delivery2 = DeliveryFactory.buildDelivery(customer2, order2, payment2,"17/05/2024","25/05/2024");
        assertNotNull(delivery2);
    }

    @Test
    void b_create() {
        Delivery created1 = deliveryService.create(delivery1);
        assertNotNull(created1);
        System.out.println(created1);
        Delivery created2 = deliveryService.create(delivery2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Delivery read = deliveryService.read(delivery1.getDeliveryId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Delivery deliveryNew = new Delivery.Builder().copy(delivery1).setDeliveryId("2132").build();
        assertNotNull(deliveryNew);
        System.out.println(deliveryNew);
    }

    @Test
    void d_getAll() {
        System.out.println(deliveryService.getAll());
    }
}