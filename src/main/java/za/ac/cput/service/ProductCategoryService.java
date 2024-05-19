package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.repository.ProductCategoryRepository;

import java.util.List;

@Service
public class ProductCategoryService implements IProductCategoryService{
    private ProductCategoryRepository repository;

    @Autowired
    ProductCategoryService(ProductCategoryRepository repository){
        this.repository = repository;
    }

    @Override
    public ProductCategory create(ProductCategory productCategory) {
        return repository.save(productCategory);
    }

    @Override
    public ProductCategory read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return repository.save(productCategory);
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }

    @Override
    public List<ProductCategory> getAll() {
        return repository.findAll();
    }
}
