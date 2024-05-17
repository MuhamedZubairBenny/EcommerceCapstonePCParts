package za.ac.cput.repository;


import za.ac.cput.domain.Delivery;

import java.util.List;

public interface IDeliveryRepository extends IRepository<Delivery, String>{
    List<Delivery> getAll();
}
