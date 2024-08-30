package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer buildCustomers(String customerId, String firstName, String lastName, String password, String email){
        if (Helper.isNullOrEmpty(customerId)
                || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(password)
                || !Helper.emailIsValid(email,"^(.+)@(\\S+)$"))
            return null;

        return new Customer.Builder().setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .build();
    }

    public static Customer buildCustomer(String customerId, String firstName, String lastName, String password, String email){
        if( Helper.isNullOrEmpty(customerId)
                || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(password)
                || !Helper.emailIsValid(email,"^(.+)@(\\S+)$"))
            return null;

        return new Customer.Builder().setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .build();
    } }