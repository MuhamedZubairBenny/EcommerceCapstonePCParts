package za.ac.cput.repository;

import za.ac.cput.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static IProductRepository repository = null;
    private List<Product> productList;
    private ProductRepository(){productList = new ArrayList<Product>();}
    public static IProductRepository getRepository(){
        if(repository == null){
            repository = new ProductRepository();
        }
        return repository;
    }

    @Override
    public Product create(Product product) {
        boolean success = productList.add(product);
        if(success)
            return product;
        return null;
    }

    @Override
    public Product read(String id){
        for(Product p : productList){
            if(p.getProductId().equals(id))
                return p;
        }
        return null;
    }

    @Override
    public Product update(Product product){
        Product productOld = read(product.getProductId());

        boolean success = productList.remove(productOld);
        if(success){
            if(productList.add(product))
                return product;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Product brandToDelete = read(s);
        boolean success = productList.remove(brandToDelete);
        return success;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }
}
