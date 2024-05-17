package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryFactoryTest {

    @Test
    void buildProductCategory() {
        ProductCategory p = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        assertNotNull(p);
        System.out.println(p.toString());
    }

    @Test
    void testBuildProductCategoryWithFail() {
        ProductCategory p =ProductCategoryFactory.buildProductCategory("", "GPU");
        assertNotNull(p);
        System.out.println(p.toString());
    }

    @Test
    void buildProductCategoryTest() {
        ProductCategory p = ProductCategoryFactory.buildProductCategory("Motherboard");
        assertNotNull(p);
        System.out.println(p.toString());
    }

    @Test
    void buildProductCategoryWithFailTest() {
        ProductCategory p = ProductCategoryFactory.buildProductCategory("Motherboard");
        assertNull(p);
        System.out.println(p.toString());
    }
}