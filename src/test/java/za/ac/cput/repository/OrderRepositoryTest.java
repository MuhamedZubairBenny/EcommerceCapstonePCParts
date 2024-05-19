package za.ac.cput.repository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.factory.OrderItemFactory;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderRepositoryTest {

    private static IOrderRepository repository = OrderRepository.getRepository();

    OrderItem orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050"
            , 2);
    OrderItem orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Sapphire Pure AMD Radeon RX 7700"
            , 1);
    //This is a list
   private static List<OrderItem> orderItemList = new ArrayList<OrderItem>();
    {
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);
    }

    private Delivery delivery1 = DeliveryFactory.buildDelivery("11/01/2024","20/01/2024");
    private Customer customer1 = CustomerFactory.buildCustomer("101", "James","Gunn", "ILoveYou","jamesgunn@gmail.com", "0744345354"
            ," 4 Thomas Bowler", "Cape Town", "Western Cape", "7441", "South Africa");
    private Order order = OrderFactory.buildOrder("001", 14500.00, delivery1,customer1,orderItemList);


    @Test
    void a_create() {
        Order created = repository.create(order);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test

    void b_read() {
        String orderId = "001";
        Order read = repository.read(orderId);
        assertEquals(read, order);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Order updated = repository.update(new Order.Builder().copy(order).setOverallPrice(25000.00).build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test

    void e_delete() {
        assertTrue(repository.delete(order.getOrderId()));
        System.out.println("Success: Deleted Order");
    }

    @Test
    void d_getAll() {
        System.out.println(repository.getAll());
    }
}