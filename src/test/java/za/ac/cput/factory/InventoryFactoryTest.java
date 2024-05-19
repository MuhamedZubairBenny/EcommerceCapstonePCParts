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
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryFactoryTest {

    @Test
    @Order(1)
     void buildInventory() {
        ProductCategory category = ProductCategoryFactory.buildProductCategory("111","GPU");
        Brand brand = BrandFactory.buildBrand("001","Nvidia");
        Product product = ProductFactory.buildProduct("Geforce 1080",category,brand,"Gaming grpahics card",2000.00,10,"20x15x5","5 years");
        Inventory inventory = InventoryFactory.buildInventory("1569", product, 125);
        assertNotNull(inventory);
        System.out.println(inventory);
    }


    @Test
    @Order(2)
    void testBuildInventory() {
        ProductCategory category = ProductCategoryFactory.buildProductCategory("111","GPU");
        Brand brand = BrandFactory.buildBrand("001","Nvidia");
        Product product = ProductFactory.buildProduct("Geforce 1080",category,brand,"Gaming grpahics card",2000.00,10,"20x15x5","5 years");
        Inventory inventory = InventoryFactory.buildInventory("1569", product, 125);
        assertNotNull(inventory);
        System.out.println(inventory);
    }

    @Test
    @Order(3)
    void buildInventoryFail() {
        ProductCategory category = ProductCategoryFactory.buildProductCategory("111","GPU");
        Brand brand = BrandFactory.buildBrand("001","Nvidia");
        Product product = ProductFactory.buildProduct("Geforce 1080",category,brand,"Gaming grpahics card",2000.00,10,"20x15x5","5 years");
        Inventory inventory = InventoryFactory.buildInventory("", product, 125);
        assertNotNull(inventory);
        System.out.println(inventory);
    }
    @Test
    @Order(4)
    void testBuildInventoryFail() {
        Inventory inventory = InventoryFactory.buildInventory("1569",125, "", "GPU", "Graphic Processing Unit", 1500.00, "270mm", "12 months");
        assertNotNull(inventory);
        System.out.println(inventory);
    }
}