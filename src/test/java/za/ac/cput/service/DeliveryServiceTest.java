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
class DeliveryServiceTest {
    @Autowired
    private DeliveryService deliveryService;
    private static Delivery delivery1;


    @BeforeAll
    static void a_setup(){
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> products = new ArrayList<>();
        Cart cart = CartFactory.buildCart(products);

        //Build Customer
        Customer customer1 = CustomerFactory.buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer1);
        System.out.println(customer1);
        Order order = OrderFactory.buildOrder("001", 14500.00);
        Payment payment = PaymentFactory.buildPayment("001", customer1, order, "Credit card", 1000.0);

        delivery1 = DeliveryFactory.buildDelivery("001",customer1,order, payment,"15/05/2024","23/05/2024");
        assertNotNull(delivery1);
    }

    @Test
    void b_create() {
        Delivery created1 = deliveryService.create(delivery1);
        assertNotNull(created1);
        System.out.println(created1);

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
    @Disabled
    void e_delete() {
        deliveryService.delete(delivery1.getDeliveryId());
        }


    @Test
    void f_getAll() {
        System.out.println(deliveryService.getAll());
    }
}
