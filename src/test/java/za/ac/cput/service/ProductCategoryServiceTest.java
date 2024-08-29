package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.factory.ProductCategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductCategoryServiceTest {
    @Autowired
    private ProductCategoryService categoryService;
    private static ProductCategory category1;
    private static ProductCategory category2;

    @Test
    void a_setup(){
        category1 = ProductCategoryFactory.buildProductCategory("11", "Motherboard");
        assertNotNull(category1);
        System.out.println(category1);
        category2 = ProductCategoryFactory.buildProductCategory("002", "CPU");
        assertNotNull(category2);
        System.out.println(category2);
    }


    @Test
    void b_create() {
        ProductCategory created1 = categoryService.create(category1);
        assertNotNull(created1);
        System.out.println(created1);
        ProductCategory created2 = categoryService.create(category2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        ProductCategory read = categoryService.read(category1.getCategoryId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        ProductCategory newCategory = new ProductCategory.Builder().copy(category1).setCategoryName("GPU").build();
        ProductCategory updated = categoryService.update(newCategory);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void f_delete(){
        categoryService.delete(category1.getCategoryId());
    }

    @Test
    void e_getAll() {
        System.out.println(categoryService.getAll());
    }
}