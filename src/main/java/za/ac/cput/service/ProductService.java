package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;
import za.ac.cput.repository.BrandRepository;
import za.ac.cput.repository.ProductCategoryRepository;
import za.ac.cput.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private ProductRepository repository;
    private ProductCategoryRepository productCategoryRepository;
    private BrandRepository brandRepository;

    @Autowired
    ProductService(ProductRepository repository, ProductCategoryRepository productCategoryRepository, BrandRepository brandRepository){
        this.repository = repository;
        this.productCategoryRepository = productCategoryRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public Product create(Product product) {
        productCategoryRepository.save(product.getCategory());
        brandRepository.save((product.getBrand()));
        return repository.save(product);
    }

    @Override
    public Product read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return repository.findByProductNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> searchProductsByCategory(String categoryName) {
        return repository.findByCategory_CategoryNameContaining(categoryName);
    }

    @Override
    public List<Product> searchProductsById(String productId) {
        return repository.findByProductIdIgnoreCase(productId);
    }

}
