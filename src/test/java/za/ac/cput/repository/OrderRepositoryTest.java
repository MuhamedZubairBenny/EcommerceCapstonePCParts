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

    @Test
    void findByItemId() {
    }
}