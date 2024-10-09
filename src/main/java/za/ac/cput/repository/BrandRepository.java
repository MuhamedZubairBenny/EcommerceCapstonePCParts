package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    Brand findByBrandId(String brandId);
}
