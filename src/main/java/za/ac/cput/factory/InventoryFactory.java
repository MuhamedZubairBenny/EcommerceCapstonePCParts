package za.ac.cput.factory;
/*
Author:
Imaan Sadien - 221752838
GitHub Repo:
https://github.com/Elentiya10/EcommercePCParts
 */

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;
import za.ac.cput.domain.Inventory;

public class InventoryFactory {
    public static Inventory buildInventory(String inventoryId, Product product, int stockQuantity){
        if(Helper.isNullOrEmpty(inventoryId) || Helper.isNullOrZeroInt(stockQuantity) ||
                Helper.isNullOrEmpty(product.getProductId()) || Helper.isNullOrEmpty(product.getProductName()) ||
                Helper.isNullOrEmpty(product.getDescription()) || Helper.isNullOrZeroDouble(product.getPrice()) ||
                Helper.isNullOrEmpty(product.getDimension()) || Helper.isNullOrEmpty(product.getWarranty()))
            return null;

        return new Inventory.Builder().setInventoryId(inventoryId).setProduct(product).setStockQuantity(stockQuantity).
                build();
    }

    public static Inventory buildInventory(String inventoryId, int stockQuantity, String productId,  String productName, String description, double price, String dimension, String warranty){
        if(Helper.isNullOrEmpty(inventoryId) ||
                Helper.isNullOrZeroInt(stockQuantity) ||
                Helper.isNullOrEmpty(productId) ||
                Helper.isNullOrEmpty(productName) ||
                Helper.isNullOrEmpty(description) ||
                Helper.isNullOrZeroDouble(price) ||
                Helper.isNullOrEmpty(dimension) ||
                Helper.isNullOrEmpty(warranty))
            return null;
        Product productInfo = new Product.Builder().setProductId(productId).
                setProductName(productName).setDescription(description).
                setPrice(price).setDimension(dimension).
                setWarranty(warranty).build();


        return new Inventory.Builder().setInventoryId(inventoryId).setStockQuantity(stockQuantity).setProduct(productInfo).build();

    }
}
