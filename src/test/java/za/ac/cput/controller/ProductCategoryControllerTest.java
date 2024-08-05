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
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.factory.ProductCategoryFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductCategoryControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ecommerceCapstonePCParts/productCategory";
    private static ProductCategory category;

    @BeforeAll
    public static void setup(){
        category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
    }
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<ProductCategory> postResponse = restTemplate.postForEntity(url, category, ProductCategory.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ProductCategory categorySaved = postResponse.getBody();
        assertEquals(category.getCategoryId(), categorySaved.getCategoryId());
        System.out.println("Saved data: " + categorySaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/"+category.getCategoryId();
        System.out.println("URL: " + url);
        ResponseEntity<ProductCategory> response = restTemplate.getForEntity(url, ProductCategory.class);
        assertEquals(category.getCategoryId(), response.getBody().getCategoryId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        ProductCategory newCategory = new ProductCategory.Builder().copy(category).setCategoryName("Motherboard").build();
        ResponseEntity<ProductCategory> postResponse = restTemplate.postForEntity(url, newCategory, ProductCategory.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ProductCategory categoryUpdated = postResponse.getBody();
        assertEquals(newCategory.getCategoryId(), categoryUpdated.getCategoryId());
        System.out.println("Updated data: " + categoryUpdated);
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/"+category.getCategoryId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted category");
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