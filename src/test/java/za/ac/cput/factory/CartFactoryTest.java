package za.ac.cput.factory;

import jdk.jfr.Category;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartFactoryTest {

    @Test
    @Order(1)
    void testBuildCartWithValidInput() {
        Contact contact = ContactFactory.buildContact("Mark@gmail.com","0987654321","29 Waterway","Cape Town","Western Province","2604","South Africa");
        Brand brand = BrandFactory.buildBrand("001","Nvidia");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("001","GPU");
        Customer customer = CustomerFactory.buildCustomer("001","Mark","Stevens","Qw123",contact);
        List<Product> productList = new ArrayList<>();
        Product product = ProductFactory.buildProduct("GeForce 1080",category,brand,"gaming graphics card",1000.00,5,"20x10x5","3 years");
        productList.add(product);
        Cart cart = CartFactory.buildCart("001",productList,customer,1000.00 );
        assertNotNull(cart);
        System.out.println(cart);
    }

    @Test
    @Order(2)
    void testBuildCartWithInvalidCartId() {
        Contact contact = ContactFactory.buildContact("Steven@gmail.com","0887452321","25 Earthway","Cape Town","Western Province","2623","South Africa");
        Brand brand = BrandFactory.buildBrand("002","Nvidia");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("002","GPU");
        Customer customer = CustomerFactory.buildCustomer("002","Steven","Stevenson","Qw12345",contact);
        List<Product> productList = new ArrayList<>();
        Product product = ProductFactory.buildProduct("GeForce 1080",category,brand,"gaming graphics card",1000.00,5,"20x10x5","3 years");
        productList.add(product);
        Cart cart = CartFactory.buildCart(productList,customer,1000.00 );
        assertNotNull(cart);
        System.out.println(cart);
    }

    @Test
    @Order(3)
    void testBuildCartWithFail() {
        Contact contact = ContactFactory.buildContact("Steven@gmail.com","0887452321","25 Earthway","Cape Town","Western Province","2623","South Africa");
        Brand brand = BrandFactory.buildBrand("002","Nvidia");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("002","GPU");
        Customer customer = CustomerFactory.buildCustomer("002","Steven","Stevenson","Qw12345",contact);
        List<Product> productList = new ArrayList<>();
        Product product = ProductFactory.buildProduct("GeForce 1080",category,brand,"gaming graphics card",1000.00,5,"20x10x5","3 years");
        productList.add(product);
        Cart cart = CartFactory.buildCart("",productList,customer,1000.00 );
        assertNotNull(cart);
        System.out.println(cart);
    }
}
