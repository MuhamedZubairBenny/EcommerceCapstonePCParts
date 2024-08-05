package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemFactoryTest {

    @Test
    void buildOrderItem() {
        OrderItem orderItem = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
        , 2);
    OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Sapphire Pure AMD Radeon RX 7700"
            , 1);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(orderItem);
        orderItems.add(orderItem2);
    assertNotNull(orderItem);
        System.out.println(orderItems);
}
    @Test
    void buildOrderItemFail() {
        OrderItem orderItem = new OrderItemFactory().buildOrderItem("", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
                , 2);
        OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Sapphire Pure AMD Radeon RX 7700"
                , 1);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(orderItem);
        orderItems.add(orderItem2);
        assertNotNull(orderItem);
        System.out.println(orderItems);
    }

}