package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Shipping;
import za.ac.cput.repository.ShippingRepository;

import java.util.List;

@Service
public class ShippingService implements IShippingService{
    private ShippingRepository repository;

    @Autowired
    ShippingService(ShippingRepository repository){
        this.repository = repository;
    }

    @Override
    public Shipping create(Shipping shipping) {
        return repository.save(shipping);
    }

    @Override
    public Shipping read(String id) {
        return repository.findByShippingId(id);
    }

    @Override
    public Shipping update(Shipping shipping) {
        return repository.save(shipping);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Shipping> getAll() {
        return repository.findAll();
    }
}