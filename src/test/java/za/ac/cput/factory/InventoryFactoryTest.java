package za.ac.cput.factory;
/*
Author:
Imaan Sadien - 221752838
GitHub Repo:
https://github.com/Elentiya10/EcommercePCParts
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryFactoryTest {

    @Test
    @Order(1)
     void buildInventory() {
        Product product = new Product.Builder().setProductId("1256").
                setProductName("GPU").setDescription("Graphic Processing Unit").
                setPrice(1500.00).setDimension("270mm").
                setWarranty("12 Months").build();
        Inventory inventory = InventoryFactory.buildInventory(product, 125);
        assertNotNull(inventory);
        System.out.println(inventory);
    }

    @Test
    @Order(3)
    void buildInventoryFail() {
        Product product = new Product.Builder().setProductId("").
                setProductName("GPU").setDescription("Graphic Processing Unit").
                setPrice(1500.00).setDimension("270mm").
                setWarranty("12 Months").build();
        Inventory inventory = InventoryFactory.buildInventory(product, 125);
        assertNotNull(inventory);
        System.out.println(inventory);
    }
    @Test
    @Order(2)
    void testBuildInventory() {
        Inventory inventory = InventoryFactory.buildInventory(125, "1256", "GPU", "Graphic Processing Unit", 1500.00, "270mm", "12 months");
        assertNotNull(inventory);
        System.out.println(inventory);
    }

    @Test
    @Order(4)
    void testBuildInventoryFail() {
        Inventory inventory = InventoryFactory.buildInventory(125, "", "GPU", "Graphic Processing Unit", 1500.00, "270mm", "12 months");
        assertNotNull(inventory);
        System.out.println(inventory);
    }
}