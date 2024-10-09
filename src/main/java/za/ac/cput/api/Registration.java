package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Shipping;
import za.ac.cput.domain.User;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.service.CartService;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.ShippingService;
import za.ac.cput.service.UserService;

@Service
public class Registration {
    private final UserService userService;
    private final CartService cartService;

    private final ShippingService shippingService;

    @Autowired
    public Registration(UserService userService, CartService cartService, ShippingService shippingService){
        this.userService = userService;
        this.cartService = cartService;
        this.shippingService = shippingService;
    }

    @Transactional
    public User registerUser(User user){
        User newUser = userService.create(user);
        Shipping shippingNew = shippingService.create(user.getShipping());
        Cart cartTest = cartService.create(user.getCart());

        return newUser;
    }
}
