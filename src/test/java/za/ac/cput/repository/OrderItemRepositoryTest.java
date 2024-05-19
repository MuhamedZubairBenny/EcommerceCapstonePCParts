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

    @Test
    void findByItemId() {
    }
}
