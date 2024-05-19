package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    @Test
    void buildProduct() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
        assertNotNull(p);
        System.out.println(p.toString());
    }

    @Test
    void buildProductFail() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("", "ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
        assertNotNull(p);
        System.out.println(p.toString());
    }
    @Test
    void testBuildProduct() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
        assertNotNull(p);
        System.out.println(p.toString());
    }

    @Test
    void testBuildProductFail() {
        ProductCategory category = new ProductCategoryFactory().buildProductCategory("2345", "Motherboard");
        Brand brand = new BrandFactory().buildBrand("3456", "Asus");
        Product p = ProductFactory.buildProduct("ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
        assertNull(p);
        System.out.println(p.toString());
    }

    @Test
    void BuildProductTest() {
        Product p = ProductFactory.buildTestProduct("1234", "Rog Strix", "2345", "Motherboard", "3456", "Motherboard","TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
        assertNotNull(p);
        System.out.println(p.toString());
    }

    @Test
    void BuildProductTestFail() {
        Product p = ProductFactory.buildTestProduct("1234", "Rog Strix", "2345", "Motherboard", "3456", "Motherboard","TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
        assertNull(p);
        System.out.println(p.toString());
    }

}