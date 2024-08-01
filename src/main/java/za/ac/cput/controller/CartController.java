package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.Cart;
import za.ac.cput.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @GetMapping("/read/{id}")
    public Cart read(@PathVariable String id) {
        return cartService.read(id);
    }

    @PostMapping("/update")
    public Cart update(@RequestBody Cart cart) {
        return cartService.update(cart);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        cartService.delete(id);
    }

    @GetMapping("/getall")
    public List<Cart> getAll() {
        return cartService.getAll();
    }
}
