package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Shipping;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerFactoryTest {

    @Test
    @Order(1)
    void buildCustomerWithObject() {
        //Build Shipping
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);

        //Build Customer
        Customer customer = new CustomerFactory().buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    @Order(2)
    void buildCustomerWithGeneratedId() {
        //Build Shipping
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);

        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);

        //Build Customer
        Customer customer = new CustomerFactory().buildCustomer("ID10","Zubair", "Benny", "ben@gamil.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    @Order(3)
    void buildCustomerWithObjectFail() {
        //Build Shipping
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        //Build Customer
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        Customer customer = new CustomerFactory().buildCustomer("", "Zubair", "Benny", "user", "pword", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer);
        System.out.println(customer);
    }
}