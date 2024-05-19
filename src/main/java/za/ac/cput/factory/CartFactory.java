package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.List;

public class CartFactory {

    public static Cart buildCart(String cartId, List<Product> productList, Customer customer, double totalPrice) {
        if (Helper.isNullOrEmpty(cartId) || Helper.isLessZero(totalPrice) || Helper.isListEmpty(productList)) {
            return null;
        }

        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomer(customer)
                .setProducts(productList)
                .setTotalPrice(totalPrice)
                .build();
    }

    public static Cart buildCart(List<Product> productList, Customer customer, double totalPrice) {
        if (Helper.isLessZero(totalPrice) || Helper.isListEmpty(productList))
            return null;
        String cartId = Helper.generateId();


        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomer(customer)
                .setProducts(productList)
                .setTotalPrice(totalPrice)
                .build();
    }

}
//