package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByProductId(String productId);

    List<Product> findByProductNameContainingIgnoreCase(String productName);
}
