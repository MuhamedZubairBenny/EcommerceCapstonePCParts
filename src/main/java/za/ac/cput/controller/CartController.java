package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.Cart;
import za.ac.cput.service.CartService;

import java.util.List;

@RestController
@RequestMapping("api/cart")
public class CartController {
    private CartService cartService;
    @Autowired
    CartController(CartService cartService) {this.cartService = cartService;}

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

    @GetMapping("/getAll")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PostMapping("/{cartId}/addProduct/{productId}")
    public ResponseEntity<Cart> addCartProduct(@PathVariable String cartId,@PathVariable String productId){
        Cart updatedCart = cartService.addProductToCart(cartId,productId);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{cartId}/removeProduct/{productId}")
    public ResponseEntity<String> removeProductFromCart(@PathVariable String cartId, @PathVariable String productId) {
        try {
            boolean success = cartService.removeProductFromCart(cartId, productId);
            if (success) {
                return ResponseEntity.ok("Product removed from cart");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product or Cart not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to remove product from cart");
        }
    }


}