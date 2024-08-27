package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    private static Customer customer;
    private static Order order1, order2;

    @Test
     void a_setup() {
        customer = CustomerFactory.buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
        assertNotNull(customer);
        System.out.println(customer);
        order1 = OrderFactory.buildOrder("001", 14500.00,customer);
        assertNotNull(order1);
        System.out.println(order1);
    }

    @Test
    void b_create() {
        Order created = orderService.create(order1);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void c_read() {
        Order read = orderService.read(order1.getOrderId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Order newOrder = new Order.Builder().copy(order1).setOverallPrice(20000).build();
        Order updated = orderService.update(newOrder);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        orderService.delete("69");
    }

    @Test
    void f_getAll() {
        System.out.println(orderService.getAll());
    }
}