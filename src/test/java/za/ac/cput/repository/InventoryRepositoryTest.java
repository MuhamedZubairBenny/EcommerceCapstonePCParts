package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Inventory;
import za.ac.cput.factory.InventoryFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryRepositoryTest {
    private static IinventoryRepository repository = InventoryRepository.getRepository();
    private Inventory inventory = InventoryFactory.buildInventory("1525", 156, "1584", "GPU", "Graphic Processing Unit", 1200.00, "270mm", "6 months");

    @Test
    @Order(1)
    void create() {
        Inventory created = repository.create(inventory);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String inventoryId = "1525";
        Inventory read = repository.read(inventoryId);
        assertEquals(read, inventory);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Inventory updated = repository.update(new Inventory.Builder().copy(inventory).setStockQuantity(124).build());
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