package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Brand;
import za.ac.cput.repository.BrandRepository;
import za.ac.cput.repository.ProductRepository;

import java.util.List;

@Service
public class BrandService implements IBrandService {
    private BrandRepository repository;

    @Autowired
    BrandService(BrandRepository repository){
        this.repository = repository;
    }

    @Override
    public Brand create(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Brand update(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public void delete(String s) {
        repository.deleteById(s);
    }

    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }
}
