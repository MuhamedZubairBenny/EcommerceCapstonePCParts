package za.ac.cput.factory;

import za.ac.cput.domain.Brand;
import za.ac.cput.util.Helper;

public class BrandFactory {

    public static Brand buildBrand(String brandId, String brandName){

        if(Helper.isNullOrEmpty(brandId) || Helper.isNullOrEmpty(brandName))
            return null;

        return new Brand.Builder()
                .setBrandId(brandId)
                .setBrandName(brandName)
                .build();
    }

    public static Brand buildBrand(String brandName){

        if(Helper.isNullOrEmpty(brandName))
            return null;
        String brandId = Helper.generateId();

        return new Brand.Builder()
                .setBrandId(brandId)
                .setBrandName(brandName)
                .build();
    }
}
