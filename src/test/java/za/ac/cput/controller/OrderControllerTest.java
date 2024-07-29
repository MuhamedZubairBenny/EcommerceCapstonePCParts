package za.ac.cput.controller;



import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderItemFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/pcparts/order";
    private static Order order1, order2;

    @BeforeAll
    public static void setUp() {
        OrderItem orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4000.00, "Palit GeForce RTX 3060", 2);
        OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 12000.00, "Sapphire Pure AMD Radeon RX 8700", 1);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);

        Contact contact1 = ContactFactory.buildContact("ihassan@gmail.com", "012 345 6789", "21 Jump Street", "Cape Town", "Western Cape", "7540", "South Africa");
        Customer customer1 = CustomerFactory.buildCustomer("01", "Isa", "Hassan", "123", contact1);
        order1 = OrderFactory.buildOrder("001", 45000, customer1, orderItems);
        assertNotNull(order1);

        Contact contact2 = ContactFactory.buildContact("thassan@gmail.com", "012 5643 6789", "22 Jump Street", "Cape Town", "Western Cape", "7540", "South Africa");
        Customer customer2 = CustomerFactory.buildCustomer("02", "Tariq", "Hassan", "1234", contact2);
        order2 = OrderFactory.buildOrder("002", 43000, customer2, orderItems);
        assertNotNull(order2);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order1, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Order orderSaved = postResponse.getBody();
        assertEquals(order1.getOrderId(), orderSaved.getOrderId());
        System.out.println("Saved data: " + orderSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + order1.getOrderId();
        System.out.println("URL: " + url);
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        assertEquals(order1.getOrderId(), response.getBody().getOrderId());
        System.out.println("Read data: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Order newOrder = new Order.Builder().copy(order1).setOverallPrice(3500).build();
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, newOrder, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Order orderUpdated = postResponse.getBody();
        assertEquals(newOrder.getOrderId(), orderUpdated.getOrderId());
        System.out.println("Updated data: " + orderUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + order1.getOrderId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted order");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Show ALL:");
        System.out.println(response.getBody());
    }
}