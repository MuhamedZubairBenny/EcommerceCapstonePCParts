//package za.ac.cput.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import za.ac.cput.domain.Order;
//import za.ac.cput.domain.OrderItem;
//import za.ac.cput.service.OrderItemService;
//import za.ac.cput.service.OrderService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/orderItem")
//public class OrderItemController {
//    private OrderItemService orderItemService;
//
//    @Autowired
//    OrderItemController(OrderItemService orderItemService) {this.orderItemService = orderItemService;}
//
//    @PostMapping("/create")
//    public OrderItem create(@RequestBody OrderItem orderItem) {return orderItemService.create(orderItem);}
//
//    @GetMapping("/read/{id}")
//    public OrderItem read (@PathVariable String id) {return orderItemService.read(id);}
//
//    @PostMapping("/update")
//    public OrderItem update(@RequestBody OrderItem orderItem) {return orderItemService.update(orderItem);}
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable String id) {orderItemService.delete(id);}
//
//    @GetMapping("/getall")
//    public List<OrderItem> getAll() {return orderItemService.getAll();}
//
//
//}
