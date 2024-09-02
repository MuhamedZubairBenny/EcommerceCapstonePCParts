package za.ac.cput.factory;

import za.ac.cput.domain.Shipping;
import za.ac.cput.util.Helper;

public class ShippingFactory {
    public static Shipping buildShipping(String shippingId, String address, String city, String state, String zipCode, String country){
        if (Helper.isNullOrEmpty(shippingId) || Helper.isNullOrEmpty(address) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(state) || Helper.isNullOrEmpty(zipCode) || Helper.isNullOrEmpty(country))
            return null;

        return new Shipping.Builder()
                .setShippingId(shippingId)
                .setAddress(address)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setCountry(country)
                .build();
    }

    public static Shipping buildShipping(String address, String city, String state, String zipCode, String country){
        if (Helper.isNullOrEmpty(address) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(state) || Helper.isNullOrEmpty(zipCode) || Helper.isNullOrEmpty(country))
            return null;

        String shippingId = Helper.generateId();

        return new Shipping.Builder()
                .setShippingId(shippingId)
                .setAddress(address)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setCountry(country)
                .build();
    }
}