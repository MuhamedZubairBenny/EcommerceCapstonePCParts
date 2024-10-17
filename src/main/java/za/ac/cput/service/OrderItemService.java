//package za.ac.cput.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import za.ac.cput.domain.OrderItem;
//import za.ac.cput.domain.Payment;
//import za.ac.cput.repository.*;
//
//import java.util.List;
//
//@Service
//public class OrderItemService implements IOrderItemService{
//    private OrderItemRepository repository;
//    private OrderRepository orderRepository;
//
//
//    @Autowired
//    public OrderItemService(OrderItemRepository repository, OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//        this.repository = repository;
//    }
//
//    @Override
//    @Transactional
//    public OrderItem create(OrderItem orderItem) {
//        orderRepository.save(orderItem.getOrder());
//        return repository.save(orderItem);
//    }
//
//    @Override
//    public OrderItem read(String id) {
//        return repository.findById(id).orElse(null);
//    }
//
//    @Override
//    @Transactional
//    public OrderItem update(OrderItem orderItem) {
//        orderRepository.save(orderItem.getOrder());
//        return repository.save(orderItem);
//    }
//    @Override
//    public void delete(String id) {
//        repository.deleteById(id);
//    }
//
//
//    @Override
//    public List<OrderItem> getAll() {
//        return repository.findAll();
//    }}
