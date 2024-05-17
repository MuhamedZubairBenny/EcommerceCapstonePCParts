package za.ac.cput.repository;

import za.ac.cput.domain.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandRepository implements IBrandRepository {
    private static IBrandRepository repository = null;
    private List<Brand> brandList;
    private BrandRepository(){brandList = new ArrayList<Brand>();}
    public static IBrandRepository getRepository(){
        if(repository == null){
            repository = new BrandRepository();
        }
        return repository;
    }

    @Override
    public Brand create(Brand brand) {
        boolean success = brandList.add(brand);
        if(success)
            return brand;
        return null;
    }

    @Override
    public Brand read(String brandId){
        for(Brand b : brandList){
            if(b.getBrandId().equals(brandId))
                return b;
        }
        return null;
    }

    @Override
    public Brand update(Brand brand){
        Brand brandName = read(brand.getBrandName());

        boolean success = brandList.remove(brandName);
        if(success){
            if(brandList.add(brand))
                return brand;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Brand brandToDelete = read(s);
        boolean success = brandList.remove(brandToDelete);
        return success;
    }

    @Override
    public List<Brand> getAll() {
        return brandList;
    }
}
