package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3000/api/cart";
    private static Cart cart;


    @BeforeAll
    public static void setup() {
        ProductCategory category = ProductCategoryFactory.buildProductCategory("02", "CPU");
        Brand brand = BrandFactory.buildBrand("101", "AMD");
        Product product = ProductFactory.buildProduct("001","Ryzen 5 5600X", category, brand, "Ryzen CPU", 3999.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5600.png");

        //Create list of Products
        List<Product> products = new ArrayList<>();
        products.add(product);

        //Create Cart
        cart = CartFactory.buildCart("01", products);
        assertNotNull(cart);
        System.out.println(cart);

    }
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, cart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Cart cartSaved = postResponse.getBody();
        System.out.println("Saved data: " + cartSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + cart.getCartId();
        System.out.println("URL: " + url);
        ResponseEntity<Cart> response = restTemplate.getForEntity(url, Cart.class);
       // assertEquals(cart.getCartId(), response.getBody().getCartId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        List<Product> products = new ArrayList<>();
        Cart updatedCart = new Cart.Builder().copy(cart).setProducts(products).build();
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, updatedCart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Cart cartUpdated = postResponse.getBody();
        //assertEquals(updatedCart.getCartId(), cartUpdated.getCartId());
        System.out.println("Updated data: " + cartUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + cart.getCartId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Successfully deleted cart");
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}