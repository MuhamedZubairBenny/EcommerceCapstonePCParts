package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3000/api/customer";
    private static Contact contact;
    private static Customer customer;

    @BeforeAll
    public static void setup(){
        contact = ContactFactory.buildContact("ben@gmail.com", "075 435 2231", "109 Bridge Street", "Manchester", "Tea", "4200", "England");
        customer = CustomerFactory.buildCustomer("10", "Ben", "Maverickal", "valorant", contact);
    }
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Customer customerSaved = postResponse.getBody();
        //assertEquals(customer.getCustomerId(), customerSaved.getCustomerId());
        System.out.println("URL: " + url);
        System.out.println("Saved data: " + customerSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + customer.getCustomerId();
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
        assertEquals(customerUpdated.getCustomerId(), newCustomer.getCustomerId());
        System.out.println("URL: " + url);
        System.out.println("Updated data: " + customerUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + customer.getCustomerId();
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