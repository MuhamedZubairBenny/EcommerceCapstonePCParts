package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartFactoryTest {

    @Test
    @Order(1)
    void buildCart() {
        //Build Product
        ProductCategory category = ProductCategoryFactory.buildProductCategory("2345", "Motherboard");
        Brand brand = BrandFactory.buildBrand("3456", "Asus");
        Product product = ProductFactory.buildProduct("prod01","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        Product product2 = ProductFactory.buildProduct("prod02","GTX 1080", category, brand, "Gaming GPU", 49995.00, 10, "10cm", "5 years", "Picture URL");

        //Create list of Products
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);

        //Create Cart
        Cart cart = CartFactory.buildCart("01", productList);
        assertNotNull(cart);
        System.out.println(cart);
    }

    @Test
    @Order(2)
    void testBuildCart() {
        //Build Product
        ProductCategory category = ProductCategoryFactory.buildProductCategory("2345", "Motherboard");
        Brand brand = BrandFactory.buildBrand("3456", "Asus");
        Product product = ProductFactory.buildProduct("prod01","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        Product product2 = ProductFactory.buildProduct("prod02","GTX 1080", category, brand, "Gaming GPU", 49995.00, 10, "10cm", "5 years", "Picture URL");

        //Create list of Products
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);

        //Create Cart
        Cart cart = CartFactory.buildCart(productList);
        assertNotNull(cart);
        System.out.println(cart);
    }
}