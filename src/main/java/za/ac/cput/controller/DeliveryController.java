package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.DeliveryService;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.OrderService;
import za.ac.cput.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/create")
    public Delivery create(@RequestBody Delivery delivery){return deliveryService.create(delivery);}

    @GetMapping("/read/{deliveryId}")
    public Delivery read(@PathVariable String deliveryId){return deliveryService.read(deliveryId);}

    @PostMapping("/update")
    public Delivery update(@RequestBody Delivery delivery){return deliveryService.update(delivery);}

    @DeleteMapping("/delete/{deliveryId}")
    public void delete(@PathVariable String deliveryId){deliveryService.delete(deliveryId);}

    @GetMapping("/getall")
    public List<Delivery> getAll(){return deliveryService.getAll();}

}
