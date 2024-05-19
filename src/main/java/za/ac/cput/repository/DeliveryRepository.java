package za.ac.cput.repository;

import za.ac.cput.domain.Delivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRepository implements IDeliveryRepository{
    private static IDeliveryRepository repository = null;
    private List<Delivery> deliveryList;
    private DeliveryRepository() {deliveryList = new ArrayList<Delivery>();}
    public static IDeliveryRepository getRepository(){
        if (repository == null){
            repository = new DeliveryRepository();
        }
        return repository;
    }
    @Override
    public Delivery create(Delivery delivery) {
        boolean success = deliveryList.add(delivery);
        if (success)
            return delivery;
        return null;
    }

    @Override
    public Delivery read(String id) {
        for (Delivery d : deliveryList){
            if (d.getDeliveryId().equals(id))
                return d;
        }
        return null;
    }

    @Override
    public Delivery update(Delivery delivery) {
        Delivery deliveryOld = read(delivery.getDeliveryId());

        boolean success = deliveryList.remove(deliveryOld);
        if (success){
            if (deliveryList.add(delivery))
                return delivery;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Delivery deliveryToDelete = read(id);
        boolean success = deliveryList.remove(deliveryToDelete);
        return success;
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryList;
    }

}
