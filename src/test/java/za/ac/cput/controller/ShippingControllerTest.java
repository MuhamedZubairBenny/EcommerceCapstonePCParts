package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Shipping;
import za.ac.cput.factory.BrandFactory;
import za.ac.cput.factory.ProductCategoryFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.factory.ShippingFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShippingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3000/api/shipping";

    private static Shipping shipping;
    @BeforeAll
    static void setup(){
        shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
    }
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Shipping> postResponse = restTemplate.postForEntity(url, shipping, Shipping.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Shipping shippingSaved = postResponse.getBody();
         //assertEquals(shipping.getShippingId(),shippingSaved.getShippingId());
        System.out.println("Saved data: " + shippingSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/"+shipping.getShippingId();
        System.out.println("URL: " + url);
        ResponseEntity<Shipping> response = restTemplate.getForEntity(url,Shipping.class);
       // assertEquals(shipping.getShippingId(), response.getBody().getShippingId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Shipping newShipping = new Shipping.Builder().copy(shipping).setState("Sukuna").build();
        ResponseEntity<Shipping> postResponse = restTemplate.postForEntity(url, newShipping, Shipping.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Shipping shippingUpdated = postResponse.getBody();
        //assertEquals(newShipping.getShippingId(), shippingUpdated.getShippingId());
        System.out.println("Updated data: " + shippingUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + shipping.getShippingId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted shipping");
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