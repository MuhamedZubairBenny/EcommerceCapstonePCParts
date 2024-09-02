package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Shipping;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ShippingFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3000/api/customer";
    private static Customer customer;

    @BeforeAll
    public static void setup(){
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> products = new ArrayList<>();
        Cart cart = CartFactory.buildCart(products);

        //Build Customer
        customer = CustomerFactory.buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer);
        System.out.println(customer);
    }
//    @Test
//    void a_create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        Customer customerSaved = postResponse.getBody();
//        //assertEquals(customer.getCustomerId(), customerSaved.getCustomerId());
//        System.out.println("URL: " + url);
//        System.out.println("Saved data: " + customerSaved);
//    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + customer.getCustomer_id();
        System.out.println("URL: " + url);
        ResponseEntity<Customer> postResponse = restTemplate.getForEntity(url, Customer.class);
        //assertEquals(customer.getCustomerId(), postResponse.getBody().getCustomerId());
        System.out.println("Read: " + postResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Customer newCustomer = new Customer.Builder().copy(customer).setFirstName("Bob").build();
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, newCustomer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Customer customerUpdated = postResponse.getBody();
        //assertEquals(customerUpdated.getCustomer_id(), newCustomer.getCustomer_id());
        System.out.println("URL: " + url);
        System.out.println("Updated data: " + customerUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + customer.getCustomer_id();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted employee");
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