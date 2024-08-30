package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    OrderController(OrderService orderService) {this.orderService = orderService;}

    @PostMapping("/create")
   public Order create(@RequestBody Order order) {return orderService.create(order);}

    @GetMapping("/read/{id}")
    public Order read (@PathVariable String id) {return orderService.read(id);}

    @PostMapping("/update")
    public Order update(@RequestBody Order order) {return orderService.update(order);}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {orderService.delete(id);}

    @GetMapping("/getall")
    public List<Order> getAll() {return orderService.getAll();}

    @GetMapping("/findCustomer/{id}")
    public Customer findCustomer(@PathVariable String id){return orderService.getCustomerByOrderId(id);}


}
