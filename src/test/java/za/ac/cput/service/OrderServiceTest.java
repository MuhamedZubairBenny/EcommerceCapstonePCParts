package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.ShippingFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    private static Customer customer1;
    private static Order order;

    @BeforeAll
     static void a_setup() {
        Shipping shipping = ShippingFactory.buildShipping("Ship01", "21 Savage Street", "Cape Town", "Western Cape", "7230", "South Africa");
        assertNotNull(shipping);
        System.out.println(shipping);
        List<Product> products = new ArrayList<>();
        Cart cart = CartFactory.buildCart(products);

        //Build Customer
        customer1 = CustomerFactory.buildCustomer("Cust01","Zubi", "Benny", "benzub@gmail.com", "user", "111 121 1111", LocalDate.of(2000,1,1), shipping, cart);
        order = OrderFactory.buildOrder("001", 14500.00,customer1);
        assertNotNull(order);
        System.out.println(order);
    }

    @Test
    void b_create() {
        Order created = orderService.create(order);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void c_read() {
        Order read = orderService.read(order.getOrderId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Disabled
    void d_update() {
        Order newOrder = new Order.Builder().copy(order).setOverallPrice(20000).build();
        Order updated = orderService.update(newOrder);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void e_delete() {
        orderService.delete("69");
    }

    @Test
    void f_getAll() {
        System.out.println(orderService.getAll());
    }

    @Test
    void g_findCustomerByOrderId() {
        Customer foundCustomer = orderService.getCustomerByOrderId(order1.getOrderId());
        assertNotNull(foundCustomer);
        System.out.println(foundCustomer);
    }
}