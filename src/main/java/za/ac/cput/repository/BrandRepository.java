package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, String> {
    Brand findByBrandId(String brandId);
}
