package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.OrderItem;

import java.util.ArrayList;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
    OrderItem findByItemId(String itemId);
    }


