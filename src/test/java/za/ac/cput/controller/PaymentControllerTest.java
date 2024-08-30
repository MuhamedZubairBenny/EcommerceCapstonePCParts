package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3000/api/payment";
    private static Contact contact;
    private static Customer customer;
    private static OrderItem orderItem;
    private static List<OrderItem> orderItemList;
    private static Order order;
    private static Payment payment;


    @BeforeAll
    public static void setup(){
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Customer customer = CustomerFactory.buildCustomer("01","Mark","Stevens","Qw123",contact);
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");

        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        payment = PaymentFactory.buildPayment("001",customer,order,"Credit card",1000.00);
        assertNotNull(payment);
        System.out.println(payment);
    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Payment paymentSaved = postResponse.getBody();
        assertEquals(payment.getPaymentId(), paymentSaved.getPaymentId());
        System.out.println("URL: " + url);
        System.out.println("Saved data: " + paymentSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + payment.getPaymentId();
        System.out.println("URL: " + url);
        ResponseEntity<Payment> postResponse = restTemplate.getForEntity(url, Payment.class);
        assertEquals(payment.getPaymentId(), postResponse.getBody().getPaymentId());
        System.out.println("Read: " + postResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Payment newPayment = new Payment.Builder().copy(payment).setPaymentTotal(12000).build();
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, newPayment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Payment paymentUpdated = postResponse.getBody();
        assertEquals(paymentUpdated.getPaymentId(), newPayment.getPaymentId());
        System.out.println("URL: " + url);
        System.out.println("Updated data: " + paymentUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + payment.getPaymentId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted payment");
    }

    @Test
    void e_getall() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("URL: " + url);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}