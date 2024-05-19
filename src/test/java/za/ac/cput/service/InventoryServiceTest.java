package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.domain.Brand;
import za.ac.cput.factory.BrandFactory;
import za.ac.cput.factory.InventoryFactory;
import za.ac.cput.factory.ProductCategoryFactory;
import za.ac.cput.factory.ProductFactory;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class InventoryServiceTest {
    @Autowired
    private InventoryService inventoryService;
    private static Inventory inventory1;
    private static Inventory inventory2;

    @Test
    void a_setup(){
        ProductCategory category = ProductCategoryFactory.buildProductCategory("1634", "Storage");
        Brand brand = BrandFactory.buildBrand("1254", "MSI");
        Product product = ProductFactory.buildProduct("1255", "SSD", category , brand, "Solid State Drive", 800.00, 134, "2.5 inch", "6 months");
        inventory1 = InventoryFactory.buildInventory("1254", product, 152);
        assertNotNull(inventory1);
        ProductCategory category2 = ProductCategoryFactory.buildProductCategory("1215", "Graphics");
        Brand brand2 = BrandFactory.buildBrand("1248", "Nvidia");
        Product product2 = ProductFactory.buildProduct("1547", "GPU", category2 , brand2, "Graphic Processing Unit", 1500.00, 105, "9.5 inch", "6 months");
        inventory2 = InventoryFactory.buildInventory("1254", product2, 152);
        assertNotNull(inventory2);

    }
    @Test
    void b_create() {
        Inventory created1 = inventoryService.create(inventory1);
        assertNotNull(created1);
        System.out.println(created1);
        Inventory created2 = inventoryService.create(inventory2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void c_read() {
        Inventory read = inventoryService.read(inventory1.getInventoryId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Inventory inventoryNew = new Inventory.Builder().copy(inventory1).setInventoryId("1364").build();
        assertNotNull(inventoryNew);
        System.out.println(inventoryNew);
    }

    @Test
    void getAll() {
        System.out.println(inventoryService.getAll());
    }
}