package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.OrderItemRepository;

import java.util.List;

@Service
public class OrderItemService implements IOrderItemService{
    private OrderItemRepository repository;

    @Autowired
    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override

    public OrderItem create(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    @Override

    public OrderItem read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override

    public OrderItem update(OrderItem orderItem) {
        return repository.save(orderItem);
    }
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItem> getAll() {
        return repository.findAll();
    }
}
