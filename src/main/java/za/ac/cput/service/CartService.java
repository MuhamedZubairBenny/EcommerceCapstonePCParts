package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.CartRepository;
import za.ac.cput.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {
    private CartRepository repository;
    private ProductRepository productRepository;
    @Autowired
    CartService(CartRepository repository,ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }
    @Override
    public Cart create(Cart cart) {return repository.save(cart);}
    @Override
    public Cart read(String cartId) {return repository.findById(cartId).orElse(null);}
    @Override
    public Cart update(Cart cart) {return repository.save(cart);}
    @Override
    public void delete(String id) {repository.deleteById(id);}
    @Override
    public List<Cart> getAll() {return repository.findAll();}

    public Cart addProductToCart(String cartId, String productId) {
        Cart cart = repository.findByCartId(cartId);

        if (cart == null) {
            throw new IllegalArgumentException("Cart not found");
        }

        Product product = productRepository.findByProductId(productId);

        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }

        cart.getProducts().add(product);

        Cart updatedCart = new Cart.Builder()
                .copy(cart)
                .setCartTotal(cart.getProducts().stream().mapToDouble(Product::getPrice).sum())
                .build();

        return repository.save(updatedCart);
    }

    public boolean removeProductFromCart(String cartId, String productId) {
        Cart cart = repository.findByCartId(cartId);

        if (cart == null) {
            throw new IllegalArgumentException("Cart not found");
        }

        Product product = productRepository.findByProductId(productId);

        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }

        boolean removed = cart.getProducts().removeIf(p -> p.getProductId().equals(productId));

        if (removed) {
            double newTotal = cart.getProducts().stream().mapToDouble(Product::getPrice).sum();

            Cart updatedCart = new Cart.Builder()
                    .copy(cart)
                    .setCartTotal(newTotal)
                    .build();

            repository.save(updatedCart);
        }

        return removed;
    }

}