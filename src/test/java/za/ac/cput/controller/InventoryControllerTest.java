package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.domain.Brand;
import za.ac.cput.factory.InventoryFactory;
import za.ac.cput.factory.ProductFactory;
import za.ac.cput.factory.ProductCategoryFactory;
import za.ac.cput.factory.BrandFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/pcparts/inventory";
    private static Inventory inventory;
    private static Brand brand;
    private static ProductCategory productCategory;
    private static Product product;

    @BeforeAll
    public static void setUp() {
        brand = BrandFactory.buildBrand("1234", "Asus");
        productCategory = ProductCategoryFactory.buildProductCategory("1234", "Graphic Card");
        product = ProductFactory.buildProduct("23456", "Asus Nvidia Geforce RTX 3060", productCategory, brand, "ASUS Dual -RTX3060-O12G-V2 NVIDIA GeForce RTX 3060 12 GB GDDR6", 7500.00, 125, "20 x 12.3 x 3.8 cm", "1 Year");
        inventory = InventoryFactory.buildInventory("1254", product, 125);


    }

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Inventory> postResponse = restTemplate.postForEntity(url, inventory, Inventory.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Inventory inventorySaved = postResponse.getBody();
        System.out.println("URL: " + url);
        System.out.println("Saved Data: " + inventorySaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + inventory.getInventoryId();
        System.out.println("URL: " + url);
        ResponseEntity<Inventory> postResponse = restTemplate.getForEntity(url, Inventory.class);
        System.out.println("Read: " + postResponse.getBody());
    }

    @Test
    void update() {
        String url = BASE_URL + "/update";
        Inventory newInventory = new Inventory.Builder().copy(inventory).setStockQuantity(116).build();
        ResponseEntity<Inventory> postResponse = restTemplate.postForEntity(url, newInventory, Inventory.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Inventory inventoryUpdated = postResponse.getBody();
        assertEquals(inventoryUpdated.getInventoryId(), newInventory.getInventoryId());
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + inventoryUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + inventory.getInventoryId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted Inventory");
    }

    @Test
    void e_getAll() {
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