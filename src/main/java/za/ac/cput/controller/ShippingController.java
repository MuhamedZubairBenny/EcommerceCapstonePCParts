package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Shipping;
import za.ac.cput.service.ShippingService;

import java.util.List;

@RestController
@RequestMapping("api/shipping")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;

    @PostMapping("/create")
    public Shipping create(@RequestBody Shipping shipping) {return shippingService.create(shipping);}

    @GetMapping("/read/{email}")
    public Shipping read(@PathVariable String email) {return shippingService.read(email);}

    @PostMapping("/update")
    public Shipping update(@RequestBody Shipping shipping){return shippingService.update(shipping);}

    @DeleteMapping("/delete/{email}")
    public void delete(@PathVariable String email) {shippingService.delete(email);}

    @GetMapping("/getall")
    public List<Shipping> getAll(){return shippingService.getAll();}
}