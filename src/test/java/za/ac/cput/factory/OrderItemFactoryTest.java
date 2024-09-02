package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderItemFactoryTest {

    @Test
    void a_buildOrderItem() {
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        Cart cart = CartFactory.buildCart(productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        System.out.println(orderItem);
    }
    @Test
    void b_buildOrderItemGeneratedId() {
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        Cart cart = CartFactory.buildCart(productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder( 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        System.out.println(orderItem);
    }

    @Test
    void c_buildOrderItemFail() {
        Brand brand = BrandFactory.buildBrand("2134", "Asus");
        ProductCategory category = ProductCategoryFactory.buildProductCategory("12345", "GPU");
        Product product = ProductFactory.buildProduct("12345","ROG Strix", category, brand, "TRX40-E Gaming Motherboard", 49995.00, 10, "10cm", "5 years", "Picture URL");
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        Cart cart = CartFactory.buildCart(productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("", 14500.00,customer);
        OrderItem orderItem = OrderItemFactory.buildOrderItem("100",product,1,order);
        System.out.println(orderItem);
    }

}