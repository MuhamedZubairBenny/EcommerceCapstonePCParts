package za.ac.cput.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderItemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/pcparts/orderItem";
    private static OrderItem orderItem1, orderItem2, orderItem3;

    @BeforeAll
    public static void setUp() {
        orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 3000.00, "Palit GeForce RTX 3050", 2);
        assertNotNull(orderItem1);
        orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 12000.00, "Palit GeForce RTX 4090", 1);
        assertNotNull(orderItem2);

        orderItem3 = new OrderItemFactory().buildOrderItem("03", "Graphic Card", 33000.00, "Palit GeForce Nvida 1060", 6);
        assertNotNull(orderItem3);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url, orderItem1, OrderItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        OrderItem orderItemSaved = postResponse.getBody();
        assertEquals(orderItem1.getItemId(), orderItemSaved.getItemId());
        System.out.println("Saved data: " + orderItemSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + orderItem1.getItemId();
        System.out.println("URL: " + url);
        ResponseEntity<OrderItem> response = restTemplate.getForEntity(url, OrderItem.class);
        assertEquals(orderItem1.getItemId(), response.getBody().getItemId());
        System.out.println("Read data: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem1).setPrice(8757.56).build();
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url, newOrderItem, OrderItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        OrderItem orderItemUpdated = postResponse.getBody();
        assertEquals(newOrderItem.getItemId(), orderItemUpdated.getItemId());
        System.out.println("Updated data: " + orderItemUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + orderItem1.getItemId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted orderItem");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Show ALL:");
        System.out.println(response.getBody());
    }
}