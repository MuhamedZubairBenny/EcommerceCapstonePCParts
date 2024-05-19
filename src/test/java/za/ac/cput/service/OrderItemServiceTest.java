package za.ac.cput.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderItemServiceTest {
    @Autowired
    private OrderItemService orderItemService;

    private static OrderItem orderItem1;
    private static OrderItem orderItem2;
    private static OrderItem orderItem3;

    @Test
    void a_setup() {
    orderItem1 = new OrderItemFactory().buildOrderItem("01", "Graphic Card", 4500.00, "Palit GeForce RTX 3050", 2);
        assertNotNull(orderItem1);
       orderItem2 = new OrderItemFactory().buildOrderItem("02", "Graphic Card", 10000.00, "Palit GeForce RTX 4090", 1);
        assertNotNull(orderItem2);

    orderItem3 = new OrderItemFactory().buildOrderItem("03", "Graphic Card", 33000.00, "Palit GeForce Nvida 1060", 6);
    assertNotNull(orderItem3);
}
    @Test
    void b_create() {
            OrderItem createdOrderItem1 = orderItemService.create(orderItem1);
        assertNotNull(createdOrderItem1);
        System.out.println(createdOrderItem1);
        OrderItem createdOrderItem2 = orderItemService.create(orderItem2);
        assertNotNull(createdOrderItem2);
        System.out.println(createdOrderItem2);
    }

    @Test
    void c_read() {
        OrderItem read = orderItemService.read(orderItem1.getItemId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem1).setDescription("amd rtX5648").build();
        OrderItem updateOrderItem =orderItemService.update(newOrderItem);
        assertNotNull(updateOrderItem);
        System.out.println(updateOrderItem);
    }
    @Test
    @Disabled
    void e_delete(){
        orderItemService.delete(orderItem3.getItemId());
        System.out.println("Delete successful");
    }
    @Test
    @Disabled
    void e_delete() {
        orderItemService.delete(orderItem1.getItemId());
    }
    @Test
    void f_getAll() {
        System.out.println(orderItemService.getAll());
    }
}
