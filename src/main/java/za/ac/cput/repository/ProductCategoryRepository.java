package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
    ProductCategory findByCategoryId(String categoryId);
}
