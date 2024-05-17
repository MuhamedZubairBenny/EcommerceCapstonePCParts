package za.ac.cput.factory;

import za.ac.cput.domain.ProductCategory;
import za.ac.cput.util.Helper;

public class ProductCategoryFactory {

    public static ProductCategory buildProductCategory(String categoryId, String categoryName){

        if(Helper.isNullOrEmpty(categoryId) || Helper.isNullOrEmpty(categoryName))
            return null;

        return new ProductCategory.Builder()
                .setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .build();
    }

    public static ProductCategory buildProductCategory(String categoryName){

        if(Helper.isNullOrEmpty(categoryName))
            return null;
        String categoryId = Helper.generateId();

        return new ProductCategory.Builder()
                .setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .build();
    }
}
