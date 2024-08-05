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
class ContactControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/pcparts/contact";
    private static Contact contact;

    @BeforeAll
    public static void setup(){
        contact = ContactFactory.buildContact("ben@gmail.com", "075 435 2231", "109 Bridge Street", "Manchester", "Tea", "4200", "England");}
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, contact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact contactSaved = postResponse.getBody();
        assertEquals(contact.getEmail(), contactSaved.getEmail());
        System.out.println("URL: " + url);
        System.out.println("Saved data: " + contactSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + contact.getEmail();
        System.out.println("URL: " + url);
        ResponseEntity<Contact> postResponse = restTemplate.getForEntity(url, Contact.class);
        //assertEquals(customer.getCustomerId(), postResponse.getBody().getCustomerId());
        System.out.println("Read: " + postResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Contact newContact = new Contact.Builder().copy(contact).setState("Pitsburg").build();
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, newContact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact contactUpdated = postResponse.getBody();
        assertEquals(contactUpdated.getEmail(), newContact.getEmail());
        System.out.println("URL: " + url);
        System.out.println("Updated data: " + contactUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + contact.getEmail();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted contact");
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