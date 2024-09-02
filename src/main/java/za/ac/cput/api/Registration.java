package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Shipping;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.service.CartService;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.ShippingService;

@Service
public class Registration {
    private final CustomerService customerService;
    private final CartService cartService;

    private final ShippingService shippingService;

    @Autowired
    public Registration(CustomerService customerService, CartService cartService, ShippingService shippingService){
        this.customerService = customerService;
        this.cartService = cartService;
        this.shippingService = shippingService;
    }

    @Transactional
    public Customer registerCustomer(Customer customer){
        Customer customerNew = customerService.create(customer);
        Shipping shippingNew = shippingService.create(customer.getShipping());
        Cart cartTest = cartService.create(customer.getCart());

        return customerNew;
    }
}
