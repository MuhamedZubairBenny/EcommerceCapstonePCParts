package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void buildOrder() {
        Customer customer1 = CustomerFactory.buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
        Order order = OrderFactory.buildOrder("001", 14500.00,customer1);
        assertNotNull(order);
        System.out.println(order);
    }

    @Test
    void testBuildOrderNoObjects() {
        Customer customer = CustomerFactory.buildCustomer( "69", "Charles","Barkley", "ILoveYou","cbarkley@gmail.com", "0744345355"," 21 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
        Order order = OrderFactory.buildOrder(14500.00,customer);
        assertNotNull(order);
        System.out.println(order);
    }

    @Test
    void buildOrderFail(){
        Customer customer = CustomerFactory.buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
        Order order = OrderFactory.buildOrder("", 14500.00,customer);
        assertNotNull(order);
        System.out.println(order);
    }
}