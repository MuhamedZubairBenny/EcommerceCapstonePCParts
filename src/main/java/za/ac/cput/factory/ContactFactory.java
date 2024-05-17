package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {
    public static Contact buildContact(String email, String mobile, String address, String city, String state, String zipCode, String country){
        if(Helper.isNullOrEmpty(email)
                || Helper.isNullOrEmpty(mobile)
                || Helper.isNullOrEmpty(address)
                || Helper.isNullOrEmpty(city)
                || Helper.isNullOrEmpty(state)
                || Helper.isNullOrEmpty(zipCode)
                || Helper.isNullOrEmpty(country))
            return null;

        if(!Helper.emailIsValid(email,"^(.+)@(\\S+)$"))
            return null;

        return new Contact.Builder().setEmail(email)
                .setMobile(mobile)
                .setAddress(address)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setCountry(country)
                .build();
    }
}
