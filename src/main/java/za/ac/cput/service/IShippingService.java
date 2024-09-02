package za.ac.cput.service;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Shipping;

import java.util.List;

public interface IShippingService extends IService<Shipping, String> {
    List<Shipping> getAll();
}
