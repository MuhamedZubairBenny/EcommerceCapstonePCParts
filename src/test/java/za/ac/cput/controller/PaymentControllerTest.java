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
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3000/api/payment";
    private static Payment payment;
    private static Order order;
    private static OrderItem orderItem;
    private static Customer customer;
    @BeforeAll
     static void setup(){
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> products = new ArrayList<>();
        Cart cart = CartFactory.buildCart(products);

        //Build Customer
        customer = CustomerFactory.buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer);
        System.out.println(customer);
        order = OrderFactory.buildOrder("001", 14500.00,customer);
        payment = PaymentFactory.buildPayment("001", customer, order, "Credit card", 1000.0);
    }
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Payment paymentSaved = postResponse.getBody();
        //assertEquals(product.getProductId(), productSaved.getProductId());
        System.out.println("Saved data: " + paymentSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/"+payment.getPaymentId();
        System.out.println("URL: " + url);
        ResponseEntity<Payment> response = restTemplate.getForEntity(url, Payment.class);
        //assertEquals(payment.getPaymentId(), response.getBody().getPaymentId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Payment newPayment = new Payment.Builder().copy(payment).setPaymentTotal(1300).build();
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, newPayment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Payment paymentUpdated = postResponse.getBody();
        //assertEquals(newProduct.getProductId(), productUpdated.getProductId());
        System.out.println("Updated data: " + paymentUpdated);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + payment.getPaymentId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted payment");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}