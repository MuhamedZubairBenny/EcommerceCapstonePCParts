package za.ac.cput.repository;


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Brand;
import za.ac.cput.domain.OrderItem;

import java.util.List;
@Repository
public interface IOrderItemRepository extends IRepository<OrderItem, String>{
    List<OrderItem> getAll();
}
