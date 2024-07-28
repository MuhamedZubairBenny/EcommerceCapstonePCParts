package za.ac.cput.controller;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_URL = "http://localhost:8080/payroll/pcparts";
    private static Order order1, Order2;

    @BeforeAll
    public static void setUp(){
        OrderItem orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4000.00, "Palit GeForce RTX 3060", 2);
        OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 12000.00, "Sapphire Pure AMD Radeon RX 8700", 1);
    }

    @Test
    void a_create(){
        String url = Base_URL + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order1, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
//        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        Order orderSaved= postResponse.getBody();
        assertEquals(order1.getOrderId(),orderSaved.getOrderId());
        System.out.println("Saved data: "+orderSaved);
    }
    @Test
    void b_read(){
        String url = Base_URL + "/read/"+ order1.getOrderId();
        System.out.println("URL: "+url);
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        assertEquals(order1.getOrderId(),response.getBody().getOrderId());
        System.out.println("Read data: "+response.getBody());
    }
    @Test
    void c_update() {
        String url = Base_URL + "/update";
        Order newOrder = new Order.Builder().copy(order1)
                .setOverallPrice(3500).build();
        ResponseEntity<Order>postResponse = restTemplate.postForEntity(url, newOrder, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(),HttpStatus.OK);
        Order orderUpdated = postResponse.getBody();
        assertEquals(newOrder.getOrderId(), orderUpdated.getOrderId());
        System.out.println("Updated data: " + orderUpdated);

    }
    @Test
    void d_delete(){
        String url = Base_URL + "/deleteById"+order1.getOrderId();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted order");
    }
    @Test
    void e_getAll(){
        String url = Base_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity=new HttpEntity<>(null,headers);
        ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }


}
