package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.List;

public class CartFactory {
    public static Cart buildCart(String cartId, List<Product> products){
        if (Helper.isNullOrEmpty(cartId) ||  Helper.isListEmpty(products))
            return null;

        return new Cart.Builder().setCartId(cartId)
                .setProducts(products)
                .build();
    }

    public static Cart buildCart(List<Product> products){

        String cartId = Helper.generateId();
        return new Cart.Builder().setCartId(cartId)
                .setProducts(products)
                .build();
    }

}