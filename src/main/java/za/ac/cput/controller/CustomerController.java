package za.ac.cput.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.dto.CustomerDto;
import za.ac.cput.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer updateCustomer = customerService.update(customer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }
//
//    @DeleteMapping("/delete/{customerId}")
//    public void delete(@PathVariable String customerId){customerService.delete(customerId);}

    @GetMapping("/getall")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/login/{email}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String email){
        Customer customer = customerService.getCustomer(email);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity <Boolean> login(@PathVariable String email, @PathVariable String password){
        boolean verifyLogin = customerService.verifyLogin(email, password);
        return  new ResponseEntity<>(verifyLogin, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody CustomerDto customerDto) {
        try {
            customerService.register(customerDto);
            return ResponseEntity.ok("Customer registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration");
        }
    }
}