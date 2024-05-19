package za.ac.cput.repository;

import za.ac.cput.domain.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartRepository implements ICartRepository {
    private static ICartRepository repository = null;
    private List<Cart> cartList;

    private CartRepository() {
        cartList = new ArrayList<Cart>();
    }

    public static ICartRepository getRepository() {
        if (repository == null) {
            repository = new CartRepository();
        }
        return repository;
    }

    @Override
    public Cart create(Cart cart) {
        boolean success = cartList.add(cart);
        if (success)
            return cart;
        return null;
    }

    @Override
    public Cart read(String cartId) {
        for (Cart c : cartList) {
            if (c.getCartId().equals(cartId))
                return c;
        }
        return null;
    }

    @Override
    public Cart update(Cart cart) {
        Cart cartOld = read(cart.getCartId());

        boolean success = cartList.remove(cartOld);
        if (success) {
            if (cartList.add(cart))
                return cart;
        }
        return null;
    }

    @Override
    public boolean delete(String cartId) {
        Cart cartToDelete = read(cartId);
        boolean success = cartList.remove(cartToDelete);
        return success;
    }

    @Override
    public List<Cart> getAll() {
        return cartList;
    }
}
