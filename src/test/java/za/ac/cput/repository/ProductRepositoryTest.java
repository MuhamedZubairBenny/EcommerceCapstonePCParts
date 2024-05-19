package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {
    private static IProductRepository repository = ProductRepository.getRepository();
    private Product product = ProductFactory.buildTestProduct("1234", "Rog Strix", "2345", "Motherboard", "3456", "Motherboard","TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
    @Test
    @Order(1)
    void create() {
        Product created = repository.create(product);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String productId = "1234";
        Product read = repository.read(productId);
        assertEquals(read, product);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Product updated = repository.update(new Product.Builder().copy(product).setProductName("MSI B450").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(product.getProductId()));
        System.out.println("Success: Deleted product");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}