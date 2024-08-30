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

    private final String BASE_URL = "http://localhost:3000/api/order";
    private static Order order1;

    @BeforeAll
    public static void setUp() {
        Customer customer = CustomerFactory.buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
        assertNotNull(customer);
        System.out.println(customer);
        order1 = OrderFactory.buildOrder("001", 14500.00,customer);
        assertNotNull(order1);
        System.out.println(order1);
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

    @Test
    void f_findCustomer() {
        String url = BASE_URL + "/findCustomer/" + order1.getOrderId();
        System.out.println("URL: " + url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
        System.out.println("Find customer: " + response.getBody());
    }
}