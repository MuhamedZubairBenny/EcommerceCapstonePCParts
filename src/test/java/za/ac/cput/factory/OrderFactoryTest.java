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
class OrderFactoryTest {

    @Test

    void a_buildOrder() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("001", 14500.00,customer);
        assertNotNull(order);
        System.out.println(order);
    }

    @Test
    void b_testBuildOrderGeneratedID() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder( 14500.00,customer);
        assertNotNull(order);
        System.out.println(order);
    }

    @Test
    void c_buildOrderFail(){
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        Customer customer = new CustomerFactory().buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        Order order = OrderFactory.buildOrder("", 14500.00,customer);
        assertNotNull(order);
        System.out.println(order);
    }
}