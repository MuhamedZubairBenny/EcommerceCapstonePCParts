package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Shipping;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerFactory {

    // Method to build Customer with Shipping object
    public static Customer buildCustomer(String customerId, String firstName, String lastName, String email, String password, String mobileNumber, LocalDate dateOfBirth, Shipping shipping, Cart cart){
        if (Helper.isNullOrEmpty(customerId) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(mobileNumber) || dateOfBirth == null || shipping == null || cart == null)
            return null;

        return new Customer.Builder()
                .setCustomer_id(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setMobileNumber(mobileNumber)
                .setDateOfBirth(dateOfBirth)
                .setShipping(shipping)
                .setCart(cart)
                .build();
    }

    public static Customer buildCustomer(String firstName, String lastName, String email, String password, String mobileNumber, LocalDate dateOfBirth, Shipping shipping,Cart cart){
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(mobileNumber) || dateOfBirth == null || shipping == null || cart == null)
            return null;

        String customerId = Helper.generateId();

        return new Customer.Builder()
                .setCustomer_id(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setMobileNumber(mobileNumber)
                .setDateOfBirth(dateOfBirth)
                .setShipping(shipping)
                .setCart(cart)
                .build();
    }

    public static Customer buildCustomer(String firstName, String lastName, String email, String password){
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password))
            return null;

        String customerId = Helper.generateId();
        String mobileNumber = "111 222 3456";
        LocalDate dateOfBirth = LocalDate.of(2000,1,1);
        List<Product> productList = new ArrayList<>();
        Cart defaultCart = CartFactory.buildCart(productList);
        Shipping defaultShipping = ShippingFactory.buildShipping("Placeholder", "Placeholder", "Placeholder", "Placeholder", "Placeholder");
        return new Customer.Builder()
                .setCustomer_id(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setMobileNumber(mobileNumber)
                .setDateOfBirth(dateOfBirth)
                .setShipping(defaultShipping)
                .setCart(defaultCart)
                .build();
    }
}