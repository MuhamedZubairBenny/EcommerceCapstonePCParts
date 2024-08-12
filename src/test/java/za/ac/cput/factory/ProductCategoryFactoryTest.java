package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductCategoryFactoryTest {

    @Test
    @Order(1)
    void buildProductCategory() {
        ProductCategory p = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    @Order(3)
    void testBuildProductCategoryWithFail() {
        ProductCategory p =ProductCategoryFactory.buildProductCategory("", "GPU");
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    @Order(2)
    void buildProductCategoryTest() {
        ProductCategory p = ProductCategoryFactory.buildProductCategory("Motherboard");
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    @Order(4)
    void buildProductCategoryWithFailTest() {
        ProductCategory p = ProductCategoryFactory.buildProductCategory("");
        assertNotNull(p);
        System.out.println(p);
    }
}