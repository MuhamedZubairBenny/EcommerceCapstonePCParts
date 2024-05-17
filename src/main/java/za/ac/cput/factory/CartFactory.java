package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartFactory {
    public static Cart buildCart(String cartId, Customer customer, List<Product> products, double totalPrice) {
        if (Helper.isNullOrEmpty(cartId) || customer == null || products == null || products.isEmpty()) {
            return null;
        }

        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomer(customer)
                .setProducts(products)
                .setTotalPrice(totalPrice)
                .build();
    }
}

