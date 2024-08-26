package za.ac.cput.factory;

import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.util.Helper;

public class ProductFactory {

    public static Product buildProduct(String productId, String productName, ProductCategory category, Brand brand, String description, double price, int stockQuantity, String dimension, String warranty, String productPicture){

        if(Helper.isNullOrEmpty(productId) || Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(category.getCategoryId())
                || Helper.isNullOrEmpty(category.getCategoryName()) || Helper.isNullOrEmpty(brand.getBrandId()) || Helper.isNullOrEmpty(brand.getBrandName())
                || Helper.isNullOrEmpty(description) || Helper.isLessZero(price) || Helper.isLessThanZero(stockQuantity)
                || Helper.isNullOrEmpty(dimension) || Helper.isNullOrEmpty(warranty) || Helper.isNullOrEmpty(productPicture))
            return null;

        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setCategory(category)
                .setBrand(brand)
                .setDescription(description)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setDimension(dimension)
                .setWarranty(warranty)
                .setProductPicture(productPicture)
                .build();
    }

    public static Product buildProduct(String productName, ProductCategory category, Brand brand, String description, double price, int stockQuantity, String dimension, String warranty, String productPicture) {

        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(category.getCategoryId())
                || Helper.isNullOrEmpty(category.getCategoryName()) || Helper.isNullOrEmpty(brand.getBrandId()) || Helper.isNullOrEmpty(brand.getBrandName())
                || Helper.isNullOrEmpty(description) || Helper.isLessZero(price) || Helper.isLessThanZero(stockQuantity)
                || Helper.isNullOrEmpty(dimension) || Helper.isNullOrEmpty(warranty) || Helper.isNullOrEmpty(productPicture))
            return null;
        String productId = Helper.generateId();

        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setCategory(category)
                .setBrand(brand)
                .setDescription(description)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setDimension(dimension)
                .setWarranty(warranty)
                .setProductPicture(productPicture)
                .build();
    }

    public static Product buildProduct(String productId, String productName, ProductCategory category, Brand brand, String description, double price, int stockQuantity, String dimension, String warranty){
        if (Helper.isNullOrEmpty(productId) || Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(brand.getBrandId()) || Helper.isNullOrEmpty(brand.getBrandName())
                || Helper.isNullOrEmpty(category.getCategoryId()) || Helper.isNullOrEmpty(category.getCategoryName()) || Helper.isNullOrEmpty(description) || Helper.isNullOrZeroDouble(price) || Helper.isNullOrZeroInt(stockQuantity) || Helper.isNullOrEmpty(dimension) || Helper.isNullOrEmpty(warranty))
            return null;

        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setCategory(category)
                .setBrand(brand)
                .setDescription(description)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setDimension(dimension)
                .setWarranty(warranty)
                .setProductPicture("No image URL")
                .build();
    }
}
