package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartServiceTest {

    @Autowired
    private CartService service;

    private Contact contact = ContactFactory.buildContact("test@example.com", "1234567890", "123 Main St", "Cape Town", "Western Cape", "8000", "South Africa");
    private Brand brand = BrandFactory.buildBrand("001", "Nvidia");
    private ProductCategory category = ProductCategoryFactory.buildProductCategory("001", "GPU");
    private Customer customer = CustomerFactory.buildCustomer("001", "John", "Doe", "password", contact);

    private List<Product> productList = new ArrayList<>();
    private Cart cart;

    @BeforeEach
    void a_setUp() {
        Product product = ProductFactory.buildProduct("GeForce GTX 1080", category, brand, "High-end gaming GPU", 699.99, 10, "10x10x5", "2 years", "Picture URL");
        productList.add(product);
        cart = CartFactory.buildCart("001", productList, customer, 699.99);
    }

    @Test
    void b_create() {
        Cart created = service.create(cart);
        assertNotNull(created);
        assertEquals(cart.getCartId(), created.getCartId());
        System.out.println("Created: " + created);
    }

    @Test
    void c_read(){
        Cart read = service.read(cart.getCartId());
        assertNotNull(read);
        assertEquals(cart.getCartId(), read.getCartId());
        System.out.println("Read: " + read);
    }

    @Test
    void d_update() {
        Cart updatedCart = new Cart.Builder().copy(cart).setTotalPrice(799.99).build();
        Cart updated = service.update(updatedCart);
        assertNotNull(updated);
        assertEquals(799.99, updated.getTotalPrice());
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        Cart created = service.create(cart);
        service.delete(created.getCartId());
        Cart deleted = service.read(created.getCartId());
        assertNull(deleted);
        System.out.println("Deleted: " + created.getCartId());
    }

    @Test
    void f_getAll() {
        List<Cart> carts = service.getAll();
        assertNotNull(carts);
        assertFalse(carts.isEmpty());
        System.out.println("All Carts: " + carts);
    }
}
