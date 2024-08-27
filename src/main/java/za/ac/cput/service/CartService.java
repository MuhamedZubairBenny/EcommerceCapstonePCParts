package za.ac.cput.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.repository.CartProductRepository;
import za.ac.cput.repository.CartRepository;

import java.util.List;

@Service
public class CartService implements ICartService {
    private CartRepository repository;
    private CartProductRepository cartProductRepository;

    @Autowired
    CartService(CartRepository repository, CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
        this.repository = repository;
    }
    @Override
    @Transactional
    public Cart create(Cart cart) {
        return repository.save(cart);
    }
    @Override
    public Cart read(String cartId) {
        return repository.findById(cartId).orElse(null);
    }
    @Override
    public Cart update(Cart cart) {
        return repository.save(cart);
    }
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
    @Override
    public List<Cart> getAll() {
        return repository.findAll();
    }
    @Override
    public CartProduct addCartProduct(CartProduct cartProduct) {
        return cartProductRepository.save(cartProduct);
    }
    @Override
    public List<CartProduct> getCartProducts(Cart cart) {
        return cartProductRepository.findByCart(cart);
    }

}
