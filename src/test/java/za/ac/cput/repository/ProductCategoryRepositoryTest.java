package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.factory.ProductCategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation .class)
class ProductCategoryRepositoryTest {
    private static IProductCategoryRepository repository = ProductCategoryRepository.getRepository();
    private ProductCategory category = ProductCategoryFactory.buildProductCategory("1234", "Motherboard" );
    @Test
    @Order(1)
    void create() {
        ProductCategory created = repository.create(category);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String categoryId = "1234";
        ProductCategory read = repository.read(categoryId);
        assertEquals(read, category);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        ProductCategory updated = repository.update(new ProductCategory.Builder().copy(category).setCategoryName("CPU").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(category.getCategoryId()));
        System.out.println("Success: Deleted productCategory");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}