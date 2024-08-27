package za.ac.cput.service;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;

import java.util.List;

public interface ICartService extends IService<Cart, String> {
    List<Cart> getAll();
    CartProduct addCartProduct(CartProduct cartProduct);
    List<CartProduct> getCartProducts(Cart cart);
}
