package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Brand;
import za.ac.cput.factory.BrandFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class BrandServiceTest {
    @Autowired
    private BrandService brandService;
    private static Brand brand1;
    private static Brand brand2;
    private static Brand brand3;

    @Test
    void a_setup(){
        brand1 = BrandFactory.buildBrand("001", "Asus");
        assertNotNull(brand1);
        System.out.println(brand1);
        brand2= BrandFactory.buildBrand("002", "HP");
        assertNotNull(brand2);
        System.out.println(brand2);
        brand3= BrandFactory.buildBrand("003", "Intel");
        assertNotNull(brand3);
        System.out.println(brand3);
    }


    @Test
    void b_create() {
        Brand created1 = brandService.create(brand1);
        assertNotNull(created1);
        System.out.println(created1);
        Brand created2 = brandService.create(brand2);
        assertNotNull(created2);
        System.out.println(created2);
        Brand created3 = brandService.create(brand3);
        assertNotNull(created3);
       System.out.println(created3);
    }

    @Test
    void c_read() {
        Brand read = brandService.read(brand1.getBrandId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Brand newBrand = new Brand.Builder().copy(brand1).setBrandName("Lenovo").build();
        Brand updated = brandService.update(newBrand);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_delete(){
        brandService.delete(brand3.getBrandId());
    }

    @Test
    void f_getAll() {
        System.out.println(brandService.getAll());
    }
}
