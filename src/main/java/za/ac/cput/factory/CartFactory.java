package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;
import java.util.List;

public class CartFactory {
    public static Cart buildCart(String cartId, Customer customer, List<Product> products){
        if (Helper.isNullOrEmpty(cartId) || customer == null || Helper.isListEmpty(products))
            return null;

        return new Cart.Builder().setCartId(cartId)
                                .setCustomer(customer)
                                .setProducts(products)
                                .build();
    }

    public static Cart buildCart(Customer customer, List<Product> products){
        if (customer == null || Helper.isListEmpty(products))
            return null;

        String cartId = Helper.generateId();
        return new Cart.Builder().setCartId(cartId)
                .setCustomer(customer)
                .setProducts(products)
                .build();
    }

}