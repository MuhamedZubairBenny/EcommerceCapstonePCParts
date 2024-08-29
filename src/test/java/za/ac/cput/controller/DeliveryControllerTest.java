//package za.ac.cput.controller;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import za.ac.cput.domain.Delivery;
//import za.ac.cput.domain.Customer;
//import za.ac.cput.domain.Contact;
//import za.ac.cput.domain.Order;
//import za.ac.cput.domain.OrderItem;
//import za.ac.cput.domain.Payment;
//import za.ac.cput.factory.DeliveryFactory;
//import za.ac.cput.factory.CustomerFactory;
//import za.ac.cput.factory.ContactFactory;
//import za.ac.cput.factory.OrderFactory;
//import za.ac.cput.factory.OrderItemFactory;
//import za.ac.cput.factory.PaymentFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class DeliveryControllerTest {
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private final String BASE_URL = "http://localhost:8080/pcparts/delivery";
//    private static Delivery delivery;
//    private static Contact contact;
//    private static Customer customer;
//
//    private static Order order;
//    private static Payment payment;
//
//    @BeforeAll
//    public static void setup(){
//        Contact contact = ContactFactory.buildContact("imaan@gmail.com","0631249584","20 Berry Lane", "Cape Town", "Western Cape", "7264", "South Africa");
//        Customer customer = CustomerFactory.buildCustomer("01", "Imaan", "Sadien", "ryanreynolds", contact );
//        OrderItem orderItem = OrderItemFactory.buildOrderItem("01", "SSD", 820.00, "Solid State Drive", 1);
//        Order order = OrderFactory.buildOrder("001", 820.00, customer, orderItem.getItemId(), orderItem.getItem(), 820.00, "Solid State Drive", 1);
//        Payment payment = PaymentFactory.buildPayment("001", customer, order, "Card",820.00);
//        delivery = DeliveryFactory.buildDelivery("001",customer,order, payment,"15/05/2024","23/05/2024");
//        assertNotNull(delivery);
//
//    }
//
//    @Test
//    void a_create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<Delivery> postResponse = restTemplate.postForEntity(url, delivery, Delivery.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        Delivery deliverySaved = postResponse.getBody();
//        System.out.println("URL: " + url);
//        System.out.println("Saved data: " + deliverySaved);
//    }
//
//    @Test
//    void b_read() {
//        String url = BASE_URL + "/read/" + delivery.getDeliveryId();
//        System.out.println("URL: " + url);
//        ResponseEntity<Delivery> postResponse = restTemplate.getForEntity(url, Delivery.class);
//        System.out.println("Read: " + postResponse.getBody());
//    }
//
//    @Test
//    void update() {
//        String url = BASE_URL + "/update";
//        Delivery newDelivery = new Delivery.Builder().copy(delivery).setTransitDate("31 August 2024").build();
//        ResponseEntity<Delivery> postResponse = restTemplate.postForEntity(url, newDelivery, Delivery.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        Delivery deliveryUpdated = postResponse.getBody();
//        assertEquals(deliveryUpdated.getDeliveryId(), newDelivery.getDeliveryId());
//        System.out.println("URL: " + url);
//        System.out.println("Updated Data: " + deliveryUpdated);
//    }
//
//    @Test
//    @Disabled
//    void d_delete() {
//        String url = BASE_URL + "/delete/" + delivery.getDeliveryId();
//        System.out.println("URL: " + url);
//        restTemplate.delete(url);
//        System.out.println("Success: Deleted Delivery");
//    }
//
//    @Test
//    void e_getAll() {
//        String url = BASE_URL + "/getall";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println("URL: " + url);
//        System.out.println("Show All: ");
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//}