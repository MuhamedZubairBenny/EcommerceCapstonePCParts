package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CartRepositoryTest {
    @Test
    void findById(){

    }
 /*   private static ICartRepository repository = CartRepository.getRepository();
    Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
    Brand brand = BrandFactory.buildBrand("001","Nvidia");
    ProductCategory category = ProductCategoryFactory.buildProductCategory("001","GPU");
    Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);
    private static List<Product> productList = new ArrayList<>();{
        Product product = ProductFactory.buildProduct("GeForce 1080",category,brand,"gaming graphics card",1000.00,5,"20x10x5","3 years");
        productList.add(product);
    }
    Cart cart = CartFactory.buildCart("001", productList, customer,1000.00);
    @Test
    void a_create() {
        Cart created = repository.create(cart);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read() {
        String cartId = "001";
        Cart read = repository.read(cartId);
        assertEquals(read, cart);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Cart updated = repository.update(new Cart.Builder().copy(cart).setTotalPrice(2000.00).build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        assertTrue(repository.delete(cart.getCartId()));
        System.out.println("Success: Deleted Cart");
    }

    @Test
    void d_getAll() {
        System.out.println(repository.getAll());
    }*/
}
