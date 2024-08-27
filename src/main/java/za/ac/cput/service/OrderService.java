package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Order;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.repository.OrderRepository;

import java.util.List;
@Service
public class OrderService implements IOrderService {
    private OrderRepository repository;
    private CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository repository, CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.repository = repository;
    }

    @Override
    @Transactional
    public Order create(Order order) {
        customerRepository.save(order.getCustomer());
        return repository.save(order);
    }

    @Override
    public Order read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Order update(Order order) {
        customerRepository.save(order.getCustomer());
        return repository.save(order);
    }
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }
}
