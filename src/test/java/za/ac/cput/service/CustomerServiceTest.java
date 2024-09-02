package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Shipping;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.ShippingFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    private static Customer customer1;
    private static Customer customer2;

    @Test
    void a_setup(){
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> products = new ArrayList<>();
        Cart cart = CartFactory.buildCart(products);

        //Build Customer
        customer1 = CustomerFactory.buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        assertNotNull(customer1);
        System.out.println(customer1);

        Shipping shipping2 = ShippingFactory.buildShipping("Ship02", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping2);
        System.out.println(shipping2);
        List<Product> products2 = new ArrayList<>();
        Cart cart2 = CartFactory.buildCart(products2);

        //Build Customer
        customer2 = CustomerFactory.buildCustomer("Cust02","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping2, cart2);
        assertNotNull(customer2);
        System.out.println(customer2);
    }
    @Test
    void b_create() {
        Customer created1 = customerService.create(customer2);
        assertNotNull(created1);
        System.out.println(created1);

    }

    @Test
    void c_read() {
        Customer read = customerService.read(customer1.getCustomer_id());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Customer newCustomer = new Customer.Builder().copy(customer1).setFirstName("Muhamed Zubair").build();
        Customer updatedCustomer = customerService.update(newCustomer);
        assertNotNull(updatedCustomer);
        System.out.println(updatedCustomer);
    }

    @Test
    @Disabled
    void e_delete(){
        customerService.delete(customer2.getCustomer_id());
    }
    @Test
    void f_getAll() {
        System.out.println(customerService.getAll());
    }
}