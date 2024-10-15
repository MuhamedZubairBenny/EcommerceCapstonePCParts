package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static User buildUser(Long id, String firstName, String lastName, String email, String password, String mobileNumber, LocalDate dateOfBirth, Shipping shipping, Cart cart){
        if (id == null || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(mobileNumber) || dateOfBirth == null || shipping == null || cart == null)
            return null;

        return new User.Builder()
                .setId(id)
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

    public static User buildUser(String firstName, String lastName, String email, String password){
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password))
            return null;
        Long id = Helper.generateLongId();
        String mobileNumber = "111 222 3456";
        LocalDate dateOfBirth = LocalDate.of(2000,1,1);
        List<Product> productList = new ArrayList<>();
        Cart cart = CartFactory.buildCart(productList);
        //Order order = OrderFactory.buildOrder(1000);
        Shipping shipping = ShippingFactory.buildShipping("Placeholder", "Placeholder", "Placeholder", "Placeholder", "Placeholder");
        //Payment payment = PaymentFactory.buildPayment(order,"Credit card",100);

        return new User.Builder()
                .setId(id)
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
}
