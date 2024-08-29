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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceTest {
    @Autowired
    private ProductService productService;
    private static Product product1;

    @Test
    void a_setup(){
        ProductCategory category = ProductCategoryFactory.buildProductCategory("02", "CPU");
        ProductCategory category1 = ProductCategoryFactory.buildProductCategory("01", "GPU");
        Brand brand2 = BrandFactory.buildBrand("101", "AMD");
        product1 = ProductFactory.buildProduct("001","Ryzen 5 5600X", category, brand2, "Ryzen CPU", 3999.00, 23, "10cm", "2 years", "Ryzen5Products/Ryzen_5_5600.png");
        assertNotNull(product1);
        System.out.println(product1);
    }


    @Test
    void b_create() {
        Product created1 = productService.create(product1);
        assertNotNull(created1);
        System.out.println(created1);
    }

    @Test
    void c_read() {
        Product read = productService.read(product1.getProductId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Disabled
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

    @Test
    public void testSearchProductsByName() {
        String name = "i3";
        List<Product> result = productService.searchProductsByName(name);
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void testSearchProductsByCategory() {
        String categoryName = "CPU";
        List<Product> result = productService.searchProductsByCategory(categoryName);
        assertNotNull(result);
        System.out.println(result);
    }
}