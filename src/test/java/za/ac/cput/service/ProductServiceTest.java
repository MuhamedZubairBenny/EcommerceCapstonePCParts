package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.factory.BrandFactory;
import za.ac.cput.factory.ProductCategoryFactory;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    private static Product product1;
    private static Product product2;

    @Test
    void a_setup(){
        ProductCategory category1 = new ProductCategoryFactory().buildProductCategory("1234", "Motherboard");
        Brand brand1 = new BrandFactory().buildBrand("1234", "Asus");
        product1 = ProductFactory.buildProduct("12345","ROG Strix", category1, brand1, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years");
        assertNotNull(product1);
        System.out.println(product1);
        ProductCategory category2 = new ProductCategoryFactory().buildProductCategory("2345", "CPU");
        Brand brand2 = new BrandFactory().buildBrand("2345", "HP");
        product2 = ProductFactory.buildProduct("23456","ROG", category2, brand2, "TRX40-E Gaming CPU", 39995.00, 23, "20cm", "2 years");
        assertNotNull(product2);
        System.out.println(product2);
    }


    @Test
    void b_create() {
        Product created1 = productService.create(product1);
        assertNotNull(created1);
        System.out.println(created1);
        Product created2 = productService.create(product2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Product read = productService.read(product1.getProductId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Product newProduct = new Product.Builder().copy(product1).setStockQuantity(10).build();
        Product updated = productService.update(newProduct);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void f_delete(){
        productService.delete(product1.getProductId());
    }

    @Test
    void e_getAll() {
        System.out.println(productService.getAll());
    }
}