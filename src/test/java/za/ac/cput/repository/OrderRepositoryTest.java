package za.ac.cput.repository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.OrderFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderRepositoryTest {

    @Test
    void findByItemId() {
    }
}