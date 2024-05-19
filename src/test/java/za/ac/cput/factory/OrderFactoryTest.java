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
        OrderItem orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
                , 2);
        OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Sapphire Pure AMD Radeon RX 7700"
                , 1);
        List<OrderItem>orderItemList = new ArrayList<OrderItem>();
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
        Customer customer1 = new CustomerFactory().buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"
                                                               ," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa"  );
        Order order = new OrderFactory().buildOrder("001", 14500.00,customer1,orderItemList);
   assertNotNull(order);
        System.out.println(order);
    }

    @Test
    void testBuildOrderNoObjects() {
        Customer customer = new CustomerFactory().buildCustomer( "43", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa"  );
        Order order1 = OrderFactory.buildOrder("001", 9000.00,customer, "01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050", 2);
        assertNotNull(order1);
        System.out.println(order1);
    }
}