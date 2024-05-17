package za.ac.cput.repository;

import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryRepository implements IProductCategoryRepository {
    private static IProductCategoryRepository repository = null;
    private List<ProductCategory> productCategorytList;
    private ProductCategoryRepository(){productCategorytList = new ArrayList<ProductCategory>();}
    public static IProductCategoryRepository getRepository(){
        if(repository == null){
            repository = new ProductCategoryRepository();
        }
        return repository;
    }

    @Override
    public ProductCategory create(ProductCategory category) {
        boolean success = productCategorytList.add(category);
        if(success)
            return category;
        return null;
    }

    @Override
    public ProductCategory read(String id){
        for(ProductCategory p : productCategorytList){
            if(p.getCategoryId().equals(id))
                return p;
        }
        return null;
    }

    @Override
    public ProductCategory update(ProductCategory product){
        ProductCategory categoryName = read(product.getCategoryName());

        boolean success = productCategorytList.remove(categoryName);
        if(success){
            if(productCategorytList.add(product))
                return product;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        ProductCategory brandToDelete = read(s);
        boolean success = productCategorytList.remove(brandToDelete);
        return success;
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategorytList;
    }
}
