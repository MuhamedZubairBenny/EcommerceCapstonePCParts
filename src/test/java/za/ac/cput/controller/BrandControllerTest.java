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
import za.ac.cput.domain.Brand;
import za.ac.cput.factory.BrandFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BrandControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ecommerceCapstonePCParts/brand";
    private static Brand brand;

    @BeforeAll
    public static void setip(){
        brand = BrandFactory.buildBrand("1234", "Asus");
    }

    @Test
    void a_create() {
       String url = BASE_URL + "/create";
        ResponseEntity<Brand> postResponse = restTemplate.postForEntity(url, brand, Brand.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Brand brandSaved = postResponse.getBody();
        assertEquals(brand.getBrandId(), brandSaved.getBrandId());
        System.out.println("Saved data: " + brandSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/"+brand.getBrandId();
        System.out.println("URL: " + url);
        ResponseEntity<Brand> response = restTemplate.getForEntity(url, Brand.class);
        assertEquals(brand.getBrandId(), response.getBody().getBrandId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Brand newBrand = new Brand.Builder().copy(brand).setBrandName("HP").build();
        ResponseEntity<Brand> postResponse = restTemplate.postForEntity(url, newBrand, Brand.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Brand brandUpdated = postResponse.getBody();
        assertEquals(newBrand.getBrandId(), brandUpdated.getBrandId());
        System.out.println("Updated data: " + brandUpdated);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/"+brand.getBrandId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted brand");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}