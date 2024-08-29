package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.factory.BrandFactory;
import za.ac.cput.factory.ProductCategoryFactory;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3000/api/product";
    private static Product product;
    private static ProductCategory category;
    private static Brand brand;

    @BeforeAll
    public static void setup(){
        category = ProductCategoryFactory.buildProductCategory("03", "GPU");
        brand = BrandFactory.buildBrand("102", "Nvidia");
        product = ProductFactory.buildProduct("004","RTX 1660", category, brand, "Budget Gaming GPU", 4999.00, 15, "20cm", "3 years");
    }
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Product productSaved = postResponse.getBody();
        //assertEquals(product.getProductId(), productSaved.getProductId());
        System.out.println("Saved data: " + productSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/"+product.getProductId();
        System.out.println("URL: " + url);
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        assertEquals(product.getProductId(), response.getBody().getProductId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Product newProduct = new Product.Builder().copy(product).setProductName("GTX 1080").build();
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, newProduct, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Product productUpdated = postResponse.getBody();
        //assertEquals(newProduct.getProductId(), productUpdated.getProductId());
        System.out.println("Updated data: " + productUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + product.getProductId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted product");
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

    @Test
    void f_searchByProductName() {
        String searchString = "i3";
        String url = BASE_URL + "/search/" + searchString;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity <String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
    }

    @Test
    void g_searchByCategoryName() {
        String searchString = "CPU";
        String url = BASE_URL + "/category/" + searchString;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity <String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

    }

    @Test
    void g_searchByProductId() {
        String searchString = "008";
        String url = BASE_URL + "/searchById/" + searchString;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity <String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

    }
}