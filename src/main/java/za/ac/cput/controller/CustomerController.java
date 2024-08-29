package za.ac.cput.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.ContactService;
import za.ac.cput.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

   @GetMapping("/csrf-token")
   public CsrfToken getCsrfToken(HttpServletRequest request){
       return (CsrfToken) request.getAttribute("_csrf");
   }

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){return customerService.create(customer);}

    @GetMapping("/read/{customerId}")
    public Customer read(@PathVariable String customerId){ return customerService.read(customerId);}

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){return customerService.update(customer);}

    @DeleteMapping("/delete/{customerId}")
    public void delete(@PathVariable String customerId){customerService.delete(customerId);}

    @GetMapping("/getall")
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
