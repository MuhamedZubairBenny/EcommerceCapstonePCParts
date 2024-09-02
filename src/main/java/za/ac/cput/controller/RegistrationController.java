package za.ac.cput.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.api.Registration;
import za.ac.cput.domain.Customer;
import za.ac.cput.dto.CustomerDto;
import za.ac.cput.service.CustomerService;

@RestController
@RequestMapping("api/customer")
public class RegistrationController {

    private final Registration customerRegistration;

    @Autowired
    public RegistrationController(Registration customerRegistration) {
        this.customerRegistration = customerRegistration;
    }

//    @PostMapping("/register")
//    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
//        Customer newCustomer = customerRegistration.registerCustomer(customer);
//        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
//    }

}