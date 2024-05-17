package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartFactory {
    public static Cart buildCart(String cartId, String customerId, String productName, double productPrice, double totalPrice) {
        if (Helper.isNullOrEmpty(cartId) || Helper.isNullOrEmpty(customerId) || Helper.isNullOrEmpty(productName) || productPrice <= 0 || totalPrice <= 0) {
            return null;
        }

        List<Product> products = List.of(new Product(productName, productPrice));

        Customer customer = new Customer(customerId);

        return new Cart.Builder()
                .setCartId(cartId)
                .setCustomer(customer)
                .setProducts(products)
                .setTotalPrice(totalPrice)
                .build();
    }
}
