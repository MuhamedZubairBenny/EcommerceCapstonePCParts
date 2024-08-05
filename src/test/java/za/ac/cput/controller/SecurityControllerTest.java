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
import za.ac.cput.domain.Security;
import za.ac.cput.factory.SecurityFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ecommerceCapstonePCParts/security";
    private static Security security;
    @BeforeAll
    public static void setup(){
        security = SecurityFactory.buildSecurity("BenZub","ben10@2000", 2,"admin","22/03-2024");
        assertNotNull(security);
        System.out.println(security);
    }

    @Test
    @Order(1)

    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Security> postResponse = restTemplate.postForEntity(url, security, Security.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Security securitySaved = postResponse.getBody();
        assertEquals(security.getUsername(), securitySaved.getUsername());
        System.out.println("URL: " + url);
        System.out.println("Saved Data: " + securitySaved);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/"+security.getUsername();
        System.out.println("URL: " + url);
        ResponseEntity<Security> response = restTemplate.getForEntity(url, Security.class);
        assertEquals(security.getUsername(), response.getBody().getUsername());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Security newSecurity = new Security.Builder().copy(security).setPassword("eldenring123").build();
        ResponseEntity<Security> postResponse = restTemplate.postForEntity(url, newSecurity, Security.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Security securityUpdated = postResponse.getBody();
        assertEquals(newSecurity.getPassword(), securityUpdated.getPassword());
        System.out.println("Updated data: " + securityUpdated);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/"+security.getUsername();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted details");
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