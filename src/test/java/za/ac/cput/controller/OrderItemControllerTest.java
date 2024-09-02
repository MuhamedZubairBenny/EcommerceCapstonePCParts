package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderItemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:3000/api/orderItem";
    private static OrderItem orderItem;


    @BeforeAll
    public static void setUp() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);

        //Build Customer
        Customer customer = new CustomerFactory().buildCustomer("Cust02","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer);
        System.out.println(customer);
        ProductCategory category = ProductCategoryFactory.buildProductCategory("02", "CPU");
        Brand brand = BrandFactory.buildBrand("101", "AMD");
        Product product = ProductFactory.buildProduct("001","Ryzen 5 5600X", category, brand, "Ryzen CPU", 3999.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5600.png");
        Order order = OrderFactory.buildOrder("10", 15000, customer);

        orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        assertNotNull(orderItem);
        System.out.println(orderItem);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url, orderItem, OrderItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
        OrderItem orderItemSaved = postResponse.getBody();
        //assertEquals(orderItem.getItemId(), orderItemSaved.getItemId());
        System.out.println("Saved data: " + orderItemSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + orderItem.getItemId();
        System.out.println("URL: " + url);
        ResponseEntity<OrderItem> response = restTemplate.getForEntity(url, OrderItem.class);
        //assertEquals(orderItem.getItemId(), response.getBody().getItemId());
        System.out.println("Read data: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem).setQuantity(10).build();
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url, newOrderItem, OrderItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        OrderItem orderItemUpdated = postResponse.getBody();
       // assertEquals(newOrderItem.getItemId(), orderItemUpdated.getItemId());
        System.out.println("Updated data: " + orderItemUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + orderItem.getItemId();
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