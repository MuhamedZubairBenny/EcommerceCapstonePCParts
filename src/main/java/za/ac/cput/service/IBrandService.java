package za.ac.cput.service;

import za.ac.cput.domain.Brand;

import java.util.List;

public interface IBrandService extends IService<Brand, String>{
    List<Brand> getAll();
}
