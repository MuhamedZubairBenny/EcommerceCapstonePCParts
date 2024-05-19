package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.factory.BrandFactory;
import za.ac.cput.factory.InventoryFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.ProductCategoryFactory;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryRepositoryTest {
    private static IinventoryRepository repository = InventoryRepository.getRepository();
    private ProductCategory category = ProductCategoryFactory.buildProductCategory("01","GPU") ;
    private Brand brand = BrandFactory.buildBrand("01","Nvidia");
    private Product product = ProductFactory.buildProduct("101","Geforce 1080", category,brand,"Gaming graphics card",1500.00,10,"20x10x5","5 years");
    private Inventory inventory = InventoryFactory.buildInventory("001",product,50);

    @Test
    @Order(1)
    void create() {
        Inventory created = repository.create(inventory);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String inventoryId = "001";
        Inventory read = repository.read(inventoryId);
        assertEquals(read, inventory);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Inventory updated = repository.update(new Inventory.Builder().copy(inventory).setStockQuantity(101).build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(inventory.getInventoryId()));

        System.out.println("Success");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}