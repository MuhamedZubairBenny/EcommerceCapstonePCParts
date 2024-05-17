package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer buildCustomer(String customerId, String firstName, String lastName, String password, Contact contact){
        if (Helper.isNullOrEmpty(customerId)
                || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(password)
                || !Helper.emailIsValid(contact.getEmail(),"^(.+)@(\\S+)$")
                || Helper.isNullOrEmpty(contact.getMobile())
                || Helper.isNullOrEmpty(contact.getAddress())
                || Helper.isNullOrEmpty(contact.getCity())
                || Helper.isNullOrEmpty(contact.getState())
                || Helper.isNullOrEmpty(contact.getZipCode())
                || Helper.isNullOrEmpty(contact.getCountry()))
            return null;

        return new Customer.Builder().setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setContact(contact)
                .build();
    }

    public static Customer buildCustomer(String customerId, String firstName, String lastName, String password, String email, String mobile, String address, String city, String state, String zipCode, String country){
        if( Helper.isNullOrEmpty(customerId)
                || Helper.isNullOrEmpty(firstName)
                || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(password)
                || !Helper.emailIsValid(email,"^(.+)@(\\S+)$")
                || Helper.isNullOrEmpty(mobile)
                || Helper.isNullOrEmpty(address)
                || Helper.isNullOrEmpty(city)
                || Helper.isNullOrEmpty(state)
                || Helper.isNullOrEmpty(zipCode)
                || Helper.isNullOrEmpty(country))
            return null;

        Contact contact = new Contact.Builder().setEmail(email)
                .setMobile(mobile)
                .setAddress(address)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setCountry(country)
                .build();

        return new Customer.Builder().setCustomerId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setContact(contact)
                .build();
    } }