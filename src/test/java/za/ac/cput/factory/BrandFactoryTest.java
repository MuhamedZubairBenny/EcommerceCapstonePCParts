package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Brand;

import static org.junit.jupiter.api.Assertions.*;

class BrandFactoryTest {

    @Test
    void buildBrand() {
        Brand b = BrandFactory.buildBrand("2134", "Asus");
                assertNotNull(b);
        System.out.println(b.toString());
    }

    @Test
    void buildBrandWIthFail(){
        Brand b = BrandFactory.buildBrand("", "Asus");
        assertNotNull(b);
        System.out.println(b.toString());
    }

    @Test
    void testBuildBrand() {
        Brand b = BrandFactory.buildBrand("XFX");
        assertNotNull(b);
        System.out.println(b.toString());
    }

    @Test
    void testBuildBrandWithFail() {
        Brand b = BrandFactory.buildBrand("XFX");
        assertNull(b);
        System.out.println(b.toString());
    }
}