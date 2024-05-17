package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
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
        Delivery delivery1 = new DeliveryFactory().buildDelivery("05-03-2024", "10-03-2024");
        Order order = new OrderFactory().buildOrder("001", 14500.00, delivery1,);
    }

    @Test
    void testBuildOrderNoObjects() {
        OrderItem orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
                , 2);
        Order order = OrderFactory.buildOrder("001", 9000.00,"02-01-2024", "10-01-2024", "JK",
                "01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050", 2);
        assertNotNull(order);
        System.out.println(order);

    }}