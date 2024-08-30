package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.ProductCategory;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByProductId(String productId);

    List<Product> findByProductNameContainingIgnoreCase(String productName);

    List<Product> findByCategory_CategoryNameContaining(String category);

    List<Product> findByProductIdIgnoreCase(String productId);
}
