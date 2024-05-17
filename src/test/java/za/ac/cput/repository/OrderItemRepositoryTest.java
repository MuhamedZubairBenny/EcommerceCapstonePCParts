package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderItemRepositoryTest {

    private static IOrderItemRepository repository = OrderItemRepository.getRepository();

    private OrderItem orderItem = OrderItemFactory.buildOrderItem("001", "Graphic Card", 4500.00, "Palit GeForce RTX 3050",1);


    @Test
    @Order(1)
    void create() {
        OrderItem created = repository.create(orderItem);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String itemId = "001";
        OrderItem read = repository.read(itemId);
        assertEquals(read, orderItem);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        OrderItem updated = repository.update(new OrderItem.Builder().copy(orderItem).setDescription("Sapphire Pure AMD Radeon RX 7700").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(orderItem.getItemId()));
        System.out.println("Success: Deleted item");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}
