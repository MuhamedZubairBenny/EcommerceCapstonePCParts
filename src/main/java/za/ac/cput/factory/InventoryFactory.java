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
    public static Inventory buildInventory(Product product, int stockQuantity){
        if(Helper.isNullOrZero(stockQuantity) || Helper.isNullOrEmpty(product.getProductId()) ||
                Helper.isNullOrEmpty(product.getProduct()) || Helper.isNullOrEmpty(product.getDescription()) ||
                Helper.isNullOrZero(product.getPrice()) || Helper.isNullOrEmpty(product.getDimension()) ||
                Helper.isNullOrEmpty(product.getWarranty()))
            return null;

        return new Inventory.Builder().setProduct(product).setStockQuantity(stockQuantity).
                build();
    }

    public static Inventory buildInventory(int stockQuantity, String productId, String product, String description, double price, String dimension, String warranty){
        if(Helper.isNullOrZero(stockQuantity) || Helper.isNullOrEmpty(productId) ||
                Helper.isNullOrEmpty(product) || Helper.isNullOrEmpty(description) ||
                Helper.isNullOrZero(price) || Helper.isNullOrEmpty(dimension) ||
                Helper.isNullOrEmpty(warranty))
            return null;
        Product productInfo = new Product.Builder().setProductId(productId).
                setProduct(product).setDescription(description).
                setPrice(price).setDimension(dimension).
                setWarranty(warranty).build();


        return new Inventory.Builder().setStockQuantity(stockQuantity).setProduct(productInfo).build();

    }
}
