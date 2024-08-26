package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.Payment;
import za.ac.cput.service.IPaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/read/{paymentId}")
    public Payment read(@PathVariable String paymentId) {
        return paymentService.read(paymentId);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }

    @DeleteMapping("/delete/{paymentId}")
    public void delete(@PathVariable String paymentId) {
        paymentService.delete(paymentId);
    }

    @GetMapping("/getall")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }
}
