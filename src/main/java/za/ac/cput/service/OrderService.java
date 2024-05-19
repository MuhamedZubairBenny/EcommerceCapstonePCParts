package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Order;

import za.ac.cput.repository.OrderRepository;

import java.util.List;
@Service
public class OrderService implements IOrderService {
    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public Order read(String id) {
        Order order = repository.findById(id).orElse(null);
        if (order != null) {
            order.getOrderItem().size();
        }
        return order;
    }


    @Override
    @Transactional
    public Order update(Order order) {
        Order existingOrder = repository.findById(order.getOrderId()).orElse(null);
        if (existingOrder != null) {
            existingOrder.getOrderItem().size();
            return repository.save(order);
        }
        return null;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        List<Order> orders = repository.findAll();
        for (Order order : orders) {
            order.getOrderItem().size();
        }
        return orders;
    }
}
