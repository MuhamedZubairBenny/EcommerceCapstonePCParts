package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Brand;
import za.ac.cput.factory.BrandFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BrandRepositoryTest {
    private static IBrandRepository repository = BrandRepository.getRepository();
    private Brand brand = BrandFactory.buildBrand("4567", "Asus" );
    @Test
    @Order(1)
    void create() {
        Brand created = repository.create(brand);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String brandId = "4567";
        Brand read = repository.read(brandId);
        assertEquals(read, brand);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Brand updated = repository.update(new Brand.Builder().copy(brand).setBrandName("MSI").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(brand.getBrandId()));
        System.out.println("Success: Deleted brand");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}