package za.ac.cput.factory;

import za.ac.cput.domain.Brand;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.util.Helper;

public class ProductFactory {

    public static Product buildProduct(String productId, String productName, ProductCategory category, Brand brand,
                                       String description, double price, int stockQuantity, String dimension, String warranty){

        if(Helper.isNullOrEmpty(productId) || Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(category.getCategoryId())
                || Helper.isNullOrEmpty(category.getCategoryName()) || Helper.isNullOrEmpty(brand.getBrandId()) || Helper.isNullOrEmpty(brand.getBrandName())
                || Helper.isNullOrEmpty(description) || Helper.isLessZero(price) || Helper.isLessThanZero(stockQuantity)
                || Helper.isNullOrEmpty(dimension) || Helper.isNullOrEmpty(warranty))
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
                .build();
    }

    public static Product buildProduct(String productName, ProductCategory category, Brand brand,
                                       String description, double price, int stockQuantity, String dimension, String warranty) {

        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(category.getCategoryId())
                || Helper.isNullOrEmpty(category.getCategoryName()) || Helper.isNullOrEmpty(brand.getBrandId()) || Helper.isNullOrEmpty(brand.getBrandName())
                || Helper.isNullOrEmpty(description) || Helper.isLessZero(price) || Helper.isLessThanZero(stockQuantity)
                || Helper.isNullOrEmpty(dimension) || Helper.isNullOrEmpty(warranty))
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
                .build();
    }

    public static Product buildTestProduct(String productId, String productName, String categoryId, String categoryName, String brandId,
                                           String brandName, String description, double price, int stockQuantity, String dimension, String warranty) {

        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(categoryId)
                || Helper.isNullOrEmpty(categoryName) || Helper.isNullOrEmpty(brandId) || Helper.isNullOrEmpty(brandName)
                || Helper.isNullOrEmpty(description) || Helper.isLessZero(price) || Helper.isLessThanZero(stockQuantity)
                || Helper.isNullOrEmpty(dimension) || Helper.isNullOrEmpty(warranty))
            return null;

        ProductCategory category = new ProductCategory.Builder()
                .setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .build();

        Brand brand = new Brand.Builder()
                .setBrandId(brandId)
                .setBrandName(brandName)
                .build();

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
                .build();
    }
}
