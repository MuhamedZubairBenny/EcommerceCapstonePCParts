package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductFactoryTest {

    @Test
    @Order(1)
    void buildProduct() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    @Order(2)
    void buildProductWithGeneratedId() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    @Order(3)
    void buildProductWithNoPicture() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    @Order(4)
    void buildProductFailEmptyId() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("", "ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        assertNotNull(p);
        System.out.println(p);
    }

    @Test
    @Order(5)
    void buildProductFailEmptyPicture() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "");
        assertNotNull(p);
        System.out.println(p);
    }
}