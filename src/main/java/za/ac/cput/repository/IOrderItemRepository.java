package za.ac.cput.repository;


import za.ac.cput.domain.Brand;
import za.ac.cput.domain.OrderItem;

import java.util.List;

public interface IOrderItemRepository extends IRepository<OrderItem, String>{
    List<OrderItem> getAll();
}
