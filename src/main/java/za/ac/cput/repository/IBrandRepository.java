package za.ac.cput.repository;

import za.ac.cput.domain.Brand;

import java.util.List;

public interface IBrandRepository extends IRepository<Brand, String>{
    List<Brand> getAll();
}
