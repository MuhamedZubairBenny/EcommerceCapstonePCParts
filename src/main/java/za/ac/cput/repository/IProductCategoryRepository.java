package za.ac.cput.repository;

import za.ac.cput.domain.ProductCategory;

import java.util.List;

public interface IProductCategoryRepository extends IRepository<ProductCategory, String>{
    List<ProductCategory> getAll();
}
