package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.util.List;

@Service
public class CartService implements ICartService {
    private CartRepository repository;
    @Autowired
    CartService(CartRepository repository) {
        this.repository = repository;
    }
    @Override
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
}
