package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.ShippingFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:3000/api/order";
    private static Order order;

    @BeforeAll
    public static void setUp() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> products = new ArrayList<>();
        Cart cart = CartFactory.buildCart(products);

        //Build Customer
        Customer customer = CustomerFactory.buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        order = OrderFactory.buildOrder("001", 14500.00,customer);
        assertNotNull(order);
        System.out.println(order);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Order orderSaved = postResponse.getBody();
       // assertEquals(order.getOrderId(), orderSaved.getOrderId());
        System.out.println("Saved data: " + orderSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + order.getOrderId();
        System.out.println("URL: " + url);
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
       // assertEquals(order.getOrderId(), response.getBody().getOrderId());
        System.out.println("Read data: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Order newOrder = new Order.Builder().copy(order).setOverallPrice(3500).build();
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, newOrder, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Order orderUpdated = postResponse.getBody();
        //assertEquals(newOrder.getOrderId(), orderUpdated.getOrderId());
        System.out.println("Updated data: " + orderUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + order.getOrderId();
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
        String url = BASE_URL + "/findCustomer/" + order.getOrderId();
        System.out.println("URL: " + url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
        System.out.println("Find customer: " + response.getBody());
    }
}