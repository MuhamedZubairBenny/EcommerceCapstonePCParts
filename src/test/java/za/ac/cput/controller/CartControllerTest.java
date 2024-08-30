package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
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
    private static Customer customer;

    private static Product product2;
    @BeforeAll
    public static void setup(){
        Contact contact  = ContactFactory.buildContact("zbenny@gmail.com","021 112 3345", "29 Bundu Street", "Cape Town", "Western Cape", "7345","South Africa");
        assertNotNull(contact);
        customer = CustomerFactory.buildCustomer("01","Muhamed","Zubair", "123", contact);
        assertNotNull(customer);

        ProductCategory category = ProductCategoryFactory.buildProductCategory("02", "CPU");
        Brand brand = BrandFactory.buildBrand("101", "AMD");
        Product product = ProductFactory.buildProduct("001","Ryzen 5 5600X", category, brand, "Ryzen CPU", 3999.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5600.png");
        product2 = ProductFactory.buildProduct("005","Ryzen 5 5500GT", category, brand, "Ryzen CPU", 3499.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5500GT.png");

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        cart = CartFactory.buildCart("01", customer, productList);
        assertNotNull(cart);
        System.out.println(cart);
    }
    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, cart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Cart cartSaved = postResponse.getBody();
        assertEquals(cart.getCartId(), cartSaved.getCartId());
        System.out.println("URL: " + url);
        System.out.println("Saved data: " + cartSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + cart.getCartId();
        System.out.println("URL: " + url);
        ResponseEntity<Cart> postResponse = restTemplate.getForEntity(url, Cart.class);
        assertEquals(cart.getCartId(), postResponse.getBody().getCartId());
        System.out.println("Read: " + postResponse.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/update";
        Customer updatedCustomer = new Customer.Builder().copy(customer).setFirstName("Zubair").setLastName("Benny").build();
        Cart newCart = new Cart.Builder().copy(cart).setCustomer(updatedCustomer).build();
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, newCart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Cart cartUpdated = postResponse.getBody();
        assertEquals(cartUpdated.getCartId(), newCart.getCartId());
        System.out.println("URL: " + url);
        System.out.println("Updated data: " + cartUpdated);
    }

    @Test
    @Disabled
    void d_delete() {
        String url = BASE_URL + "/delete/" + cart.getCartId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
        System.out.println("Success: Deleted cart");
    }

    @Test
    void e_getall() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("URL: " + url);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void f_addCartProduct() {
        String url = BASE_URL + "/" + cart.getCartId() + "/addProduct/" + product2.getProductId();
        System.out.println("URL: " + url);

        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, null, Cart.class);

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse.getBody());
        assertTrue(postResponse.getBody().getProducts().contains(product2));

        System.out.println("Updated Cart: " + postResponse.getBody());
    }
    @Disabled
    @Test
    void g_removeCartProduct() {
        String url = BASE_URL + "/" + cart.getCartId() + "/removeProduct/" + product2.getProductId();
        System.out.println("URL: " + url);

        restTemplate.delete(url);

        ResponseEntity<Cart> getResponse = restTemplate.getForEntity(BASE_URL + "/read/" + cart.getCartId(), Cart.class);
        Cart updatedCart = getResponse.getBody();

        assertNotNull(updatedCart);
        assertFalse(updatedCart.getProducts().contains(product2));
        System.out.println("Updated Cart after removal: " + updatedCart);
    }

}