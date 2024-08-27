package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartProduct;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.List;

public class CartFactory {

    public static Cart buildCart(String cartId, Customer customer, List<CartProduct> cartProducts, double totalPrice){
        if (Helper.isNullOrEmpty(cartId) || Helper.isNullOrEmpty(customer.getCustomerId()) || cartProducts== null || cartProducts.isEmpty() || Helper.isLessZero(totalPrice))
            return null;
        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomer(customer)
                .setCartProducts(cartProducts)
                .setTotalPrice(totalPrice)
                .build();
    }

    public static Cart buildCart(Customer customer, List<CartProduct> cartProducts, double totalPrice){
        if (Helper.isNullOrEmpty(customer.getCustomerId()) || cartProducts.isEmpty() || Helper.isLessZero(totalPrice))
            return null;

        String cartId = Helper.generateId();
        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomer(customer)
                .setCartProducts(cartProducts)
                .setTotalPrice(totalPrice)
                .build();
    }

    public static Cart buildCart(String cartId, Customer customer, double totalPrice){
        if (Helper.isNullOrEmpty(cartId) || Helper.isNullOrEmpty(customer.getCustomerId()) || Helper.isLessZero(totalPrice))
            return null;

        List<CartProduct> cartProducts = new ArrayList<>();
        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomer(customer)
                .setCartProducts(cartProducts)
                .setTotalPrice(totalPrice)
                .build();
    }

}