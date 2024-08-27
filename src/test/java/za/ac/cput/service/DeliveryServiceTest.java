//package za.ac.cput.service;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.domain.Delivery;
//import za.ac.cput.domain.Customer;
//import za.ac.cput.domain.Contact;
//import za.ac.cput.domain.Order;
//import za.ac.cput.domain.OrderItem;
//import za.ac.cput.domain.Payment;
//import za.ac.cput.factory.*;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class DeliveryServiceTest {
//    @Autowired
//    private DeliveryService deliveryService;
//    private static Delivery delivery1;
//
//    private static Contact contact;
//
//
//    @Test
//    void a_setup(){
//        Contact contact = ContactFactory.buildContact("imaan@gmail.com","0631249584","20 Berry Lane", "Cape Town", "Western Cape", "7264", "South Africa");
//        Customer customer = CustomerFactory.buildCustomer("01", "Imaan", "Sadien", "ryanreynolds", contact );
//        OrderItem orderItem = OrderItemFactory.buildOrderItem("01", "SSD", 820.00, "Solid State Drive", 1);
//        Order order = OrderFactory.buildOrder("001", 820.00, customer, orderItem.getItemId(), orderItem.getItem(), 820.00, "Solid State Drive", 1);
//        Payment payment = PaymentFactory.buildPayment("001", customer, order, "Card",820.00);
//        delivery1 = DeliveryFactory.buildDelivery("001",customer,order, payment,"15/05/2024","23/05/2024");
//        assertNotNull(delivery1);
//    }
//
//    @Test
//    void b_create() {
//        Delivery created1 = deliveryService.create(delivery1);
//        assertNotNull(created1);
//        System.out.println(created1);
//
//    }
//
//    @Test
//    void c_read() {
//        Delivery read = deliveryService.read(delivery1.getDeliveryId());
//        assertNotNull(read);
//        System.out.println(read);
//    }
//
//    @Test
//    void d_update() {
//        Delivery deliveryNew = new Delivery.Builder().copy(delivery1).setDeliveryId("2132").build();
//        assertNotNull(deliveryNew);
//        System.out.println(deliveryNew);
//    }
//
//    @Test
//    void d_getAll() {
//        System.out.println(deliveryService.getAll());
//    }
//}