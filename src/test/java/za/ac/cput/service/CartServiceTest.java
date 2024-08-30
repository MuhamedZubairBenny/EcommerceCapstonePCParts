package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartServiceTest {
    @Autowired
    private CartService cartService;
    private static Cart cart;
    private static Customer customer;

    private static Product product2;

    @BeforeAll
    static void setUp() {
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
    @Order(1)
    void create() {
        Cart createdCart = cartService.create(cart);
        assertNotNull(createdCart);
        System.out.println(createdCart);
    }


    @Test
    @Order(2)
    void read() {
        Cart readCart = cartService.read(cart.getCartId());
        assertNotNull(readCart);
        System.out.println(cart);

    }

    @Test
    @Order(3)
    void update() {
        Customer updatedCustomer = new Customer.Builder().copy(customer).setFirstName("Zubair").setLastName("Benny").build();
        Cart newCart = new Cart.Builder().copy(cart).setCustomer(updatedCustomer).build();
        Cart updated = cartService.update(newCart);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    @Disabled
    void delete() {
        cartService.delete(cart.getCartId());
        assertNull(cartService.read(cart.getCartId()));
        System.out.println("Successfully deleted cart");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(cartService.getAll());
    }

    @Test
    @Order(6)
    void addCartProduct() {

        Cart existingCart = cartService.read(cart.getCartId());
        assertNotNull(existingCart);

        Cart updatedCart = cartService.addProductToCart(existingCart.getCartId(), product2.getProductId());

        assertTrue(updatedCart.getProducts().contains(product2));
        System.out.println(updatedCart);
    }

    @Test
    @Order(7)
    @Disabled
    void removeCartProduct() {

        Cart existingCart = cartService.read(cart.getCartId());
        assertNotNull(existingCart);
        cartService.addProductToCart(existingCart.getCartId(), product2.getProductId());

        existingCart = cartService.read(cart.getCartId());
        assertTrue(existingCart.getProducts().contains(product2));

        boolean removed = cartService.removeProductFromCart(existingCart.getCartId(), product2.getProductId());
        assertTrue(removed);

        Cart updatedCart = cartService.read(existingCart.getCartId());
        assertNotNull(updatedCart);
        assertFalse(updatedCart.getProducts().contains(product2));

        double expectedTotal = updatedCart.getProducts().stream().mapToDouble(Product::getPrice).sum();
        assertEquals(expectedTotal, updatedCart.getCartTotal(), "Cart total should be updated correctly after removing a product");

        System.out.println(updatedCart);
    }
}
